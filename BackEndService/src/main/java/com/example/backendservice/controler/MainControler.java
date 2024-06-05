package com.example.backendservice.controler;

import com.example.backendservice.dto.dto;
import com.example.backendservice.model.User;
import com.example.backendservice.service.ServiceLayer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainControler {

    private final ServiceLayer serviceLayer;

    @PostMapping("/save")
    public User save(@RequestBody dto dto) {
        return serviceLayer.save(dto);
    }

    @RequestMapping("/get")
    public List<User> findAll() {
        return serviceLayer.findAll();
    }

    @RequestMapping("/getName/{name}")
    public User getName(@PathVariable String name) {
        return serviceLayer.getName(name);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "name") String name) {
        serviceLayer.delete(name);
    }
    @PutMapping("/update")
    public void update(@RequestParam(value = "name") String name,@RequestBody dto dto){
      serviceLayer.update(name, dto);
    }
    @RequestMapping("/getAge")
    public List<User> getAge(@RequestParam(value = "age") int age){
       return serviceLayer.getAge(age);
    }
    @RequestMapping("/getAVG")
    public Double getAvg(){
        return serviceLayer.getAvg();
    }
    @RequestMapping("/getName1")
    public List<User> getName1(@RequestParam(value = "boks") String boks){
        return serviceLayer.getName1(boks);
    }
}

