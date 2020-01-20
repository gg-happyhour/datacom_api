import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.testng.annotations.Test;


public class GET_JSON_Request {

    @Test
    public void getEmployeesDetails() throws IOException, InterruptedException, ExecutionException {

        String getEndpoint = "https://reqres.in/api/users/1";

        //Adhering to standard implementation
        var request = HttpRequest.newBuilder()
            .uri(URI.create(getEndpoint))
            .GET()
            .build();

        var client = HttpClient.newHttpClient();

        //Executing the request using Async Method
        CompletableFuture <Object> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);

        System.out.println("Response: " , response.get().toString());

    }
}