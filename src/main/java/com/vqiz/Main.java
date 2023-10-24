package com.vqiz;

import org.bson.Document;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("config.comp");
        System.out.println("Starting Server");
        System.out.println("Checking Config File...");
        if (!file.exists()){
        System.out.println("Generating Config File...");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your license: ");
        String license = reader.nextLine();
        reader.close();
        System.out.println("Checking license...");
        if (!checklicense(license)){
            System.out.println("WRONG LICENSE...");
            System.exit(-1);
        }
        System.out.println("License valid!");
        System.out.println("Please make shure you opend this in a seperate screen ! (screen -S screename)");
        System.out.println("Make Shure you have port 81 open!");
        System.out.println("Starting http server!");
        try {
            file.createNewFile();
        }catch (Exception e){
            System.out.println("Error creating config file...");
            System.exit(-1);
        }
        try {
            FileWriter fileWriter = new FileWriter("config.comp");

            Document document = new Document();
            document.put("license", license);
            fileWriter.write(document.toJson());
            fileWriter.close();
            System.out.println("Created config file...");
        }catch (Exception e){
            System.out.println("Error creating config file...");
            System.exit(-1);
        }
        }else {
            String license = "";
            try {
                // Create a FileReader with the specified file path
                FileReader fileReader = new FileReader("config.comp");

                // Create a BufferedReader to read lines from the file
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Read the file line by line and store it in a StringBuilder
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                // Close the BufferedReader
                bufferedReader.close();
                license = content.toString();
                // Print the content read from the file

            } catch (IOException e) {
                System.out.println("Error reading config.... ");
                System.exit(-1);
            }
            if (!checklicense(Document.parse(license).getString("license"))){
                System.out.println("WRONG LICENSE...");
                System.exit(-1);
            }
        }
        try {
            ResourceConfig resourceConfig = new ResourceConfig().packages("com.vqiz.api");
            URI baseUri = URI.create("http://[2a0d:c2c0:9:9331:0000:0000:0000:0001]:81");
            HttpServer container = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);
            container.start();
            System.out.println("Server started. Press Ctrl+C to exit.");
            Thread.currentThread().join();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error starting server...");
            System.exit(-1);
        }
    }
    public static boolean checklicense(String lic){
        return true;
        //try {
            // Define the URL you want to send the POST request to
            //String url = "https://example.com/api/resource";

            // Create a URL object
            //URL obj = new URL(url);

            // Open a connection to the URL
            //HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Set the request method to POST
            //connection.setRequestMethod("POST");

            // Set the request property to indicate that you're sending JSON
            //connection.setRequestProperty("Content-Type", "application/json");

            // Enable input/output streams for the connection
            //connection.setDoOutput(true);

            // Define the JSON data you want to send
            //Document document = new Document();
            //document.put("license", lic);
            //String jsonInputString = document.toJson();

            // Write the JSON data to the output stream
            //try (OutputStream os = connection.getOutputStream()) {
                //byte[] input = jsonInputString.getBytes("utf-8");
                //os.write(input, 0, input.length);
            //}

            // Get the response code
            //int responseCode = connection.getResponseCode();


            //if (responseCode == HttpURLConnection.HTTP_OK) {
            //    return true;
            //} else {
            //   return false;
            //}
        //} catch (Exception e) {
           // e.printStackTrace();
            //return false;
       // }

    }

}