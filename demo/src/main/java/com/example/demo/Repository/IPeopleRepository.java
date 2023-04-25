package com.example.demo.Repository;

import com.example.demo.Dto.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People, Long> {
 /*   ResponseEntity<People> createPeople(People people);
    People updatePeople(People people);
    void deletePeople(Long id);
    List<People> getAllPeople();*/
}
