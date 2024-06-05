package com.example.backendservice.repository;

import com.example.backendservice.dto.dto;
import com.example.backendservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * from users where name=:name", nativeQuery = true)
    User getName(@Param(value = "name") String name);

    @Transactional
    @Modifying
    @Query(value = "delete from users where name=:name", nativeQuery = true)
    void delete(@Param(value = "name") String name);

    @Query(value = "SELECT * from users where age<:age",nativeQuery = true)
    List<User> getAge(int age);

    @Query(value = "SELECT avg(age) from users",nativeQuery = true)
    Double getAvg();

    @Query(value = "SELECT * from users where name like :prefics% ",nativeQuery = true)
    List<User> getName1(@Param("prefics") String prefics);
}
