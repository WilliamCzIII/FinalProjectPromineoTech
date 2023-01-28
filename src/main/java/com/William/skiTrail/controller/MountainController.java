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
import com.William.skiTrail.entity.Mountain;
import com.William.skiTrail.repository.MountainRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/SKI_TRAILS")
public class MountainController {
  
  @Autowired
  MountainRepository mountainRepository;
  
//get lift by Id API
  @GetMapping("/mountain_face/{mountain_face_id}")
  public ResponseEntity<Mountain> getLiftById(@PathVariable("mountain_face_id") int mountainId) {
    Mountain mountain = mountainRepository.findById(mountainId);

    if (mountain != null) {
      return new ResponseEntity<>(mountain, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  //get all lifts API
  @GetMapping("/mountain_face")
  public ResponseEntity<List<Mountain>> getAllLifts(@RequestParam(required=false) String face){
    try {
      List<Mountain> mountains = new ArrayList<Mountain>();

      if (face == null)
        mountainRepository.findAll().forEach(mountains::add);
      else
        mountainRepository.findByFace(face).forEach(mountains::add);

      if (mountains.isEmpty()) {
        return new ResponseEntity<>(mountains,HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(mountains,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
