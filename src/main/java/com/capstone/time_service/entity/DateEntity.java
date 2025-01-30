package com.capstone.time_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "date_service")
public class DateEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

}
