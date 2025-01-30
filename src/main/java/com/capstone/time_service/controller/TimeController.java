package com.capstone.time_service.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.time_service.entity.DateEntity;
import com.capstone.time_service.entity.DateTimePojo;
import com.capstone.time_service.repository.TimeRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/time")
public class TimeController {
    @Autowired
    TimeRepo timeRepo;

    public LocalDateTime changeDate(LocalDateTime dateTime, LocalDate newDate) {
        return LocalDateTime.of(newDate, dateTime.toLocalTime());
    }

    public DateTimePojo convertToDateTimePojo(DateEntity dateEntity, LocalDateTime dateTime) {
        DateTimePojo dateTimePojo = new DateTimePojo(dateEntity.getId(), changeDate(dateTime, dateEntity.getDate()));
        return dateTimePojo;
    }

    @PutMapping("")
    public ResponseEntity<DateTimePojo> getTime(@RequestBody DateTimePojo dateTimePojo) {
        DateEntity dateEntity = timeRepo.findById(1).orElse(null);
        if (dateEntity != null) {
            return new ResponseEntity<DateTimePojo>(convertToDateTimePojo(dateEntity, dateTimePojo.getDateTime()),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<DateTimePojo>(
                    convertToDateTimePojo(new DateEntity(0, LocalDate.now()), dateTimePojo.getDateTime()),
                    HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<DateEntity> updateTime(@RequestBody DateEntity updateEntity) {
        DateEntity dateEntity = timeRepo.findById(1).orElse(null);
        if (dateEntity != null) {
            dateEntity.setDate(updateEntity.getDate());
            timeRepo.save(dateEntity);
            return new ResponseEntity<DateEntity>(dateEntity, HttpStatus.OK);
        } else {
            dateEntity = timeRepo.saveAndFlush(new DateEntity(1, updateEntity.getDate()));
            return new ResponseEntity<DateEntity>(dateEntity, HttpStatus.OK);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteTime() {
        timeRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
