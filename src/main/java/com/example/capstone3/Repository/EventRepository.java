package com.example.capstone3.Repository;

import com.example.capstone3.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
//Bayan
@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    Event findEventById (Integer id);

    List<Event> findByEndDateBefore (LocalDate date);
}
