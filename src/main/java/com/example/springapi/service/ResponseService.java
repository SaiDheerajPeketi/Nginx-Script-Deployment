package com.example.springapi.service;

import com.example.springapi.api.model.ResponseModel;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ResponseService {
    public ResponseModel getResponse(String name) {
        String filename = "data.txt"; // Specify your file name here
        String lastRow = null;

        try {
            // Create a FileReader object
            FileReader fr = new FileReader(filename);

            // Wrap the FileReader with a BufferedReader for efficiency
            BufferedReader br = new BufferedReader(fr);

            // Read the file line by line until reaching the end
            String line;
            while ((line = br.readLine()) != null) {
                lastRow = line;
            }

            // Close the BufferedReader
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        if (lastRow != null) {
            return new ResponseModel(lastRow);
        } else {
            return new ResponseModel("File is empty or could not read from it.");
        }
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
