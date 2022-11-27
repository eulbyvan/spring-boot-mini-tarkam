package com.enigmacamp.skuymaen.minitarkam.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PlayerRepo {
    @Autowired
    private EntityManager em;


}
