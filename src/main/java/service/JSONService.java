package service;


import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;


import entities.Inf;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JSONService {

    public Inf getJson(String data) {
        Inf infJson = new Inf();

        Gson gson = new Gson();
        infJson = gson.fromJson(data, Inf.class);


        return infJson;
    }

}