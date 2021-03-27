package service;


import java.io.IOException;
import java.util.List;

import entities.Inf;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JSONService {

    public Inf getJson(String data) {
        Inf infJson = new Inf();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            infJson = objectMapper.readValue(data, Inf.class);
        } catch (IOException err) {
            System.out.printf("Error", err.toString());
        }

        return infJson;
    }

}