package com.example.backendservice.service;

import com.example.backendservice.dto.dto;
import com.example.backendservice.model.User;
import com.example.backendservice.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceLayer {
 private final  ServiceRepository serviceRepository;


    public User save(dto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setHight(dto.getHight());
     return    serviceRepository.save(user);
    }

    public List<User> findAll() {
       return serviceRepository.findAll();
    }

    public User getName(String name) {
        return serviceRepository.getName(name);
    }

    public void delete(String name) {
        serviceRepository.delete(name);
    }

    public void update(String name,dto dto) {
        User name1 = getName(name);
        name1.setName(dto.getName());
        name1.setAge(dto.getAge());
        name1.setHight(dto.getHight());
        serviceRepository.save(name1);

    }

    public List<User> getAge(int age) {
        return  serviceRepository.getAge(age);

    }
    public Double getAvg(){
        return serviceRepository.getAvg();
    }

    public List<User> getName1(String name) {
        return serviceRepository.getName1(name);
    }
}
