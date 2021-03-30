package api;


import entities.Inf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.JSONService;
import service.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.List;

@RestController
public class Parser {
//
//    @PostMapping(value = "/parse")
//    public ResponseEntity<Object> parse(@RequestBody Inf inf) throws IOException, ParseException {
//        Service service = new Service();
//        return new ResponseEntity<>(service.getFinalJSON(inf), HttpStatus.OK);
//    }

    @PostMapping(value = "/parse")
    public ResponseEntity<Object> parse(@RequestParam("file")MultipartFile file) throws IOException, ParseException {
        Service service = new Service();
        byte[] bytes = file.getBytes();

        JSONService jsonService = new JSONService();
        Inf inf = jsonService.getJson(new String(bytes, StandardCharsets.UTF_8));

        return new ResponseEntity<>(service.getFinalJSON(inf), HttpStatus.OK);
    }




    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }
}

