import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.annotations.Test;

public class PUT_Request {

    @Test
    public void updateEmployee() throws IOException, InterruptedException {

        String putEndpoint = "https://reqres.in/api/users/1";

        String inputJson = "{\n" +
            "  \"name\": \"John Reives\",\n" +
            "  \"job\": \"Automation Tester\"\n" +
            "}";

        var request = HttpRequest.newBuilder()
            .uri(URI.create(putEndpoint))
            .header("Content-Type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
            .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());


    }
}