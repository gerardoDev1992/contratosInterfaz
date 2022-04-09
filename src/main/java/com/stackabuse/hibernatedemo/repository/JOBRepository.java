package com.stackabuse.hibernatedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackabuse.hibernatedemo.entidades.JOB;

public interface JOBRepository extends JpaRepository<JOB, Long> {

}
