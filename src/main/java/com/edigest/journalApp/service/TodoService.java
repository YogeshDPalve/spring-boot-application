package com.edigest.journalApp.service;

import com.edigest.journalApp.api.responce.TodoResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class TodoService {

    private static final String API = "http://localhost:5000/api/v1/todo/list";
    @Autowired
    private RestTemplate restTemplate;
    public TodoResponce getTodos(){
      ResponseEntity<TodoResponce> response =  restTemplate.exchange(API, HttpMethod.GET, null, TodoResponce.class);
      return response.getBody();

    }
}
