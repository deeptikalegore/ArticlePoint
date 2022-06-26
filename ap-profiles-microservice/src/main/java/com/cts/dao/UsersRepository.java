package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

}