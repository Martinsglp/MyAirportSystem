package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.VIPUser;

public interface IVIPUserRepo extends CrudRepository<VIPUser, Integer>{

}
