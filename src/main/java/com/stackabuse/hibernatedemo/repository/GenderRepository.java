package com.stackabuse.hibernatedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackabuse.hibernatedemo.entidades.Gender;

public interface GenderRepository  extends JpaRepository<Gender, Long>{

}
