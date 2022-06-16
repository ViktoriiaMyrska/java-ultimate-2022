package homework;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;

public class DemoApp {

    public static void main(String[] args) {
        var nasaApiUrl = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=15&api_key=DEMO_KEY";
        var restTemplate = new RestTemplate();
        var response = restTemplate.getForEntity(nasaApiUrl, Photos.class);
        var maxSize = 0L;
        var findImg = new Pair();
        for(Photo photo: Objects.requireNonNull(response.getBody()).getPhotos()){
            var httpHeaders = restTemplate.headForHeaders(photo.getImg_src());
            var imgUri = httpHeaders.getLocation();
            assert imgUri != null;
            var headers = restTemplate.headForHeaders(imgUri);
            long imgSize = headers.getContentLength();
            if(imgSize > maxSize){
                findImg.setKey(imgUri);
                findImg.setValue(imgSize);
                maxSize = imgSize;
            }
        }
        System.out.println("img_src: " + findImg.getKey());
        System.out.println("size: " + findImg.getValue());
    }

}
