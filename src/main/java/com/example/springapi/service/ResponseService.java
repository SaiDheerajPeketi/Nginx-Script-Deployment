package com.example.springapi.service;

import com.example.springapi.api.model.ResponseModel;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

@Service
public class ResponseService {
    public ResponseModel getResponse(String name) {
        return new ResponseModel("Welcome " + name  + "! I'm a Response from Spring API");
    }

    public ResponseModel storeData(String temperature) {
        String filename = "data.txt"; // Specify your file name here
        String contentToAppend = temperature;

        try {
            // Create a FileWriter object in append mode
            FileWriter fw = new FileWriter(filename, true);

            // Wrap the FileWriter with a BufferedWriter for efficiency
            BufferedWriter bw = new BufferedWriter(fw);

            // Append the string followed by a newline character
            bw.write(contentToAppend);
            bw.newLine();

            // Close the BufferedWriter
            bw.close();

            System.out.println("String appended to file successfully.");
        } catch (IOException e) {
            System.err.println("Error appending string to file: " + e.getMessage());
        }
        return new ResponseModel("Stored Data in Data Store " + temperature);
    }

}
