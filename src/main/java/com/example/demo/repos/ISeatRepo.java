package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Seat;

public interface ISeatRepo extends CrudRepository<Seat, Integer> {

}
