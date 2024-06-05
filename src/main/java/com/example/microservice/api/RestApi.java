package com.example.microservice.api;

import com.example.microservice.dtoUser.User_dto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component


public class RestApi {
    private  RestTemplate restTemplate;

    @Autowired
    public RestApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public  void saveMetod(User_dto userDto) {
        HttpEntity<User_dto> httpEntity = new HttpEntity<>(userDto);
        restTemplate.postForEntity("http://localhost:8081/api/save", httpEntity, User_dto.class);

    }

    public  ResponseEntity<ArrayList> getMetod() {
        return restTemplate.getForEntity("http://localhost:8081/api/get", ArrayList.class);
    }

    public  ResponseEntity<User_dto> getName(String name) {
        return restTemplate.getForEntity("http://localhost:8081/api/getName/" + name, User_dto.class);
    }

    public  void delete(String name) {
        restTemplate.delete("http://localhost:8081/api/delete?name=" + name);
    }

    public  void update(String name, User_dto userDto) {
        HttpEntity<User_dto> httpEntity = new HttpEntity<>(userDto);


        restTemplate.put("http://localhost:8081/api/update?name=" + name, httpEntity);

    }

    public  ResponseEntity<ArrayList> getAge(int age) {
        return restTemplate.getForEntity("http://localhost:8081/api/getAge?age=" + age, ArrayList.class);
    }

    public  ResponseEntity<Double> getAvg() {
        return restTemplate.getForEntity("http://localhost:8081/api/getAVG", Double.class);
    }

    public  ResponseEntity<ArrayList> getName1(String name) {
        return restTemplate.getForEntity("http://localhost:8081/api/getName1?boks=" + name, ArrayList.class);
    }

}

