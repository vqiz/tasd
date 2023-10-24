package com.vqiz.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/github")
public class Github {
    @POST
    @Consumes("application/json")
    public Response post(String jsonPayload) {
        try {
            // Create an ObjectMapper for deserialization
            ObjectMapper objectMapper = new ObjectMapper();

            // Deserialize the JSON payload into a GitHubWebhookPayload object
            GitHubWebhookPayload payload = objectMapper.readValue(jsonPayload, GitHubWebhookPayload.class);

            // Access the repository name from the GitHub webhook payload
            String repositoryName = payload.repository.name;

            System.out.println("Received GitHub webhook for repository: " + repositoryName);
            System.out.println("Downloading......");

            // You can access other fields from the payload as needed

            return Response.status(Response.Status.OK).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Define a Java class to match the structure of the GitHub webhook payload
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GitHubWebhookPayload {
        public String action;
        public Repository repository;
        // Add more fields as needed to match the payload structure
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Repository {
        public String name;
        // Add more fields as needed to match the repository structure
    }

}
