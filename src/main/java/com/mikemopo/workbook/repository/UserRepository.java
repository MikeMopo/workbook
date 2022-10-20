package com.mikemopo.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikemopo.workbook.model.User;

public interface UserRepository extends JpaRepository <User,Long>{

}
