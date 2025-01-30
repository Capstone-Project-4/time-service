package com.capstone.time_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.time_service.entity.DateEntity;

@Repository
public interface TimeRepo extends JpaRepository<DateEntity, Integer> {

}
