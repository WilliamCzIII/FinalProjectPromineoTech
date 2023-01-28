package com.William.skiTrail.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.William.skiTrail.entity.Trail;
import com.William.skiTrail.repository.TrailRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/SKI_TRAILS")
public class TrailController {
  
  @Autowired
  TrailRepository trailRepository;
  

  
  //create a trail API
  @PostMapping("/trail")
  public ResponseEntity<String> saveTrail(@RequestBody Trail trail){
    try {
      trailRepository.save(new Trail(trail.getTrail_name(), trail.getTrail_difficulty(), trail.getTrail_features()));
      return new ResponseEntity<>("Trail was created successfully." ,HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
  }
 
  //read all trails API
  @GetMapping("/trail")
  public ResponseEntity<List<Trail>> getAllTrails(@RequestParam(required = false) String trail){
    try {
      List<Trail> trails = new ArrayList<Trail>();

      if (trail == null)
        trailRepository.findAll().forEach(trails::add);
      else
        trailRepository.findByFeature(trail).forEach(trails::add);

      if (trails.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(trails, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  //get trail by Id API
  @GetMapping("/trail/{trail_id}")
  public ResponseEntity<Trail> getTrailById(@PathVariable("trail_id") int trailId) {
    Trail trail = trailRepository.findById(trailId);

    if (trail != null) {
      return new ResponseEntity<>(trail, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  //putting trail API
  @PutMapping("/trail/{trail_id}")
  public ResponseEntity<String> updateTrail(@PathVariable("trail_id") int trailId, @RequestBody Trail trail){

    Trail _trail = trailRepository.findById(trailId);

    if (_trail != null) {
      _trail.setTrail_name(trail.getTrail_name());
      _trail.setTrail_difficulty(trail.getTrail_difficulty());
      _trail.setTrail_features(trail.getTrail_features());

      trailRepository.update(_trail);
      return new ResponseEntity<>("Trail was updated successfully",HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Cannot find trail with id=" + trailId, HttpStatus.NOT_FOUND);
    }
  }
  
  //delete trail API
  @DeleteMapping("/trail/{trail_id}")
  public ResponseEntity<String> deleteTrail(@PathVariable("trail_id") int trailId){
    try {
      int result = trailRepository.deleteById(trailId);
      if (result == 0) {
        return new ResponseEntity<>("Cannot find Trail with id=" + trailId, HttpStatus.OK);
      }
      return new ResponseEntity<>("Trail was deleted successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete trail.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  }
