package api;


import entities.Inf;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.Service;

import java.io.*;
import java.text.ParseException;

@RestController
public class Parser {
    
    @PostMapping(value = "/parse", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> parse(@RequestBody Inf inf) throws IOException, ParseException {
        Service service = new Service();
        return new ResponseEntity<>(service.getFinalJSON(inf), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }
}
