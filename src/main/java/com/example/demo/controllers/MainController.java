package com.example.demo.controllers;

import com.example.demo.exceptions.CustomException;
import com.example.demo.models.Request;
import com.example.demo.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {
    private final RequestService requestService;

    public MainController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<?> index(){
        try{
            return new ResponseEntity<>("index page", HttpStatus.OK);
        } catch (Exception e) {
            CustomException customException = new CustomException();
            customException.setMessage("something went wrong");
            return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> postAction(@RequestBody Request request) {
        try{
            return new ResponseEntity<>(requestService.checking(request), HttpStatus.OK);
        } catch (Exception e) {
            CustomException customException = new CustomException();
            customException.setMessage("check the correctness of your input data");
            return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
        }
    }
}
