package com.TripDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TripDemo.model.Trip;

public interface ITripRepository extends JpaRepository<Trip, Integer> {
    // JpaRepository ya tiene métodos como findAll(), save(), findById(), deleteById().
}