package com.William.skiTrail.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.William.skiTrail.entity.Lift;
import com.William.skiTrail.repository.LiftRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/SKI_TRAILS")
public class LiftController {

  @Autowired
  LiftRepository liftRepository;
  
//get lift by Id API
  @GetMapping("/lift/{lift_id}")
  public ResponseEntity<Lift> getLiftById(@PathVariable("lift_id") int liftId) {
    Lift lift = liftRepository.findById(liftId);

    if (lift != null) {
      return new ResponseEntity<>(lift, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  //get all lifts API
  @GetMapping("/lift")
  public ResponseEntity<List<Lift>> getAllLifts(@RequestParam(required=false) String lift){
    try {
      List<Lift> lifts = new ArrayList<Lift>();

      if (lift == null)
        liftRepository.findAll().forEach(lifts::add);
      else
        liftRepository.findByName(lift).forEach(lifts::add);

      if (lifts.isEmpty()) {
        return new ResponseEntity<>(lifts,HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(lifts,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
