package homework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DemoApp {

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

        StreamSupport.stream(jsonResponse.get("photos").spliterator(), false)
                .map(p -> p.get("img_src"))
                .map(JsonNode::asText)
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(), url -> {
                            try {
                                return getSize(httpClient, url);
                            } catch (IOException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }),
                        map -> map.entrySet().stream()
                                .max(Map.Entry.comparingByValue())))
                .ifPresent(max -> System.out.format("Url: %s \nsize: %d\n", max.getKey(), max.getValue()));
    }

    @SneakyThrows
    private static long getSize(HttpClient httpClient, String url) throws IOException, InterruptedException {
        return httpClient.send(
                HttpRequest.newBuilder().GET().uri(URI.create(url)).build(),
                HttpResponse.BodyHandlers.discarding())
                .headers()
                .firstValueAsLong("Content-Length")
                .orElseThrow();
    }
}
