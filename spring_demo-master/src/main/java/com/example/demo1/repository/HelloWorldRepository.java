package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorldMessageEntity, Integer> {
    HelloWorldMessageEntity findById(int id);
}
