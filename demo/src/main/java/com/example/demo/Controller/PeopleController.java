package com.example.demo.Controller;

import com.example.demo.Dto.People;
import com.example.demo.Repository.IPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class PeopleController {

    @Autowired
    private IPeopleRepository iPeopleRepository;

    @PostMapping("addpeople")
    public ResponseEntity<People> createPeople(@RequestBody People people) {
        try {
            return new ResponseEntity<>(iPeopleRepository.save(people), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getallpeople")
    public ResponseEntity<List<People>> getAllPeople() {
        try {
            List<People> peopleList = iPeopleRepository.findAll();
            if (peopleList.isEmpty() || peopleList.size() == 0) {
                return new ResponseEntity<List<People>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<People>>(peopleList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @GetMapping("getpeople")
    public List<People> getPeople(){
        return this.iPeopleRepository.findAll();
    }*/

    @GetMapping("getpeople/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable Long id) {
        Optional<People> person = iPeopleRepository.findById(id);
        if (person.isPresent()) {
            return new ResponseEntity<People>(person.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<People>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("updatepeople/{id}")
    public ResponseEntity<People> updatePeople(@RequestBody People people) {
        try {
            return new ResponseEntity<People>(iPeopleRepository.save(people),HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deletepeople/{id}")
    public ResponseEntity<HttpStatus> deletePeople(@PathVariable Long id) {
        try {
            Optional<People> people = iPeopleRepository.findById(id);
            if(people.isPresent()){
                iPeopleRepository.delete(people.get());
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
