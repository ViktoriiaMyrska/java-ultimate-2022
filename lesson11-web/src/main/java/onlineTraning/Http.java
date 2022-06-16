package onlineTraning;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.StreamSupport;

public class Http {

    public static void main(String[] args) throws IOException, InterruptedException {
        var nasaApiUrl = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=15&api_key=DEMO_KEY";
        var httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> response = httpClient.send(
                HttpRequest.newBuilder().GET().uri(URI.create(nasaApiUrl)).build(),
                HttpResponse.BodyHandlers.ofString()
        );
        var objectMapper = new ObjectMapper();
        var jsonResponse = objectMapper.readTree(response.body());
        StreamSupport.stream(jsonResponse.get("photos").spliterator(), false)
                .map(p -> p.get("img_src"))
                .map(JsonNode::asText)
                .forEach(System.out::println);

//        StreamSupport.stream(jsonResponse.get("photos").spliterator(), false)
//                .map(p -> p.get("img_src"))
//                .forEach(s -> httpClient.send(
//                                HttpRequest.newBuilder().GET().uri(URI.create(nasaApiUrl)).build(),
//                                HttpResponse.BodyHandlers.ofString()).headers()..getBytes())


    }

}
