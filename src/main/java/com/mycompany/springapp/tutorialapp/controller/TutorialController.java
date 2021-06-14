package com.mycompany.springapp.tutorialapp.controller;

import com.mycompany.springapp.tutorialapp.model.TutorialModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")// class level mapping
public class TutorialController {
    public List<TutorialModel> getAllTutorial(){
     return null;
    }
    public TutorialModel getTutorialById(long id){
        return null;
    }
    public void deleteTutorial(long id){
    }
    public void updateTutorial(TutorialModel tm){
    }
    public void createTutorial(TutorialModel tm){
    }
    /*@GetMapping(value = "/healthcheck1")
    public String healthCheck1(){
        return "Simply healthy";
    }*/
    @PostMapping(value = "/healthcheck")
    public ResponseEntity<TutorialModel> healthCheckPost(@RequestBody TutorialModel tutorialModel){
        ResponseEntity<TutorialModel> tm = new ResponseEntity<TutorialModel>(tutorialModel, HttpStatus.CREATED);
        return tm;
       // return "Simply healthy";
    }
    @PutMapping(value = "/healthcheck/{tutorialId}")
    public ResponseEntity<TutorialModel> healthCheckPost(@RequestBody TutorialModel tutorialModel, @PathVariable Long tutorialId){
        ResponseEntity<TutorialModel> tm = new ResponseEntity<TutorialModel>(tutorialModel, HttpStatus.CREATED);
        return tm;
        // return "Simply healthy";
    }
    @GetMapping(value = "/healthcheck")
    public String healthCheck(@RequestParam("id") long xyzId,
                              @RequestParam("name") String name,
                              @RequestParam("title") String title){
        return "healthy "+"id is "+xyzId+" Name is "+name+" Title is "+title ;
    }
    @GetMapping(value = "/healthcheck/{id}")
    public String healthCheckById(@PathVariable("id") Long xyzId){
        System.out.println("Id is "+xyzId);
        return "health + id is "+xyzId;
    }
    @GetMapping(value = "/healthcheck/{id}/{name}")
    public String healthCheckById(@PathVariable("id") Long xyzId,@PathVariable("name") String abc){
        System.out.println("Id is "+xyzId+ " "+abc);
        return "health + id is "+xyzId +" "+abc;
    }

}
