package com.William.skiTrail.repository;

import java.util.List;
import com.William.skiTrail.entity.Lift;

public interface LiftRepository {
  
  List<Lift> findAll();
  
  Lift findById(int Id);
  
  List<Lift> findByName(String lift);

}
