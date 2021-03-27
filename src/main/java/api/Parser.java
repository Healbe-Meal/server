package api;


import entities.Inf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping(value = "/parse", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Object> parse(@RequestBody Inf inf) throws IOException, ParseException {
//        Service service = new Service();
//        return new ResponseEntity<>(service.getFinalJSON(inf), HttpStatus.OK);
//    }

    @PostMapping(value = "/parse",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })

    public void parse(@RequestParam("file")MultipartFile file) throws IOException, ParseException {
        byte[] bytes = file.getBytes();

        String content = new String(bytes);

        System.out.println(content);
    }



    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }
}
