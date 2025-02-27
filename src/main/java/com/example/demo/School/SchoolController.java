package com.example.demo.School;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/school")
public class SchoolController {

    private SchoolRepository repository;


    public SchoolController(SchoolRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School add(@RequestBody School school){
        return this.repository.save(school);
    }

    @GetMapping
    public List<School> getAll(){
        return this.repository.findAll();
    }


}
