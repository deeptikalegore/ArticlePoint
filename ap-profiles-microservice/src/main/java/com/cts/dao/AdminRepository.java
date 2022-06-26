package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
