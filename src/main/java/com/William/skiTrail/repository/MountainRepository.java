package com.William.skiTrail.repository;

import java.util.List;
import com.William.skiTrail.entity.Mountain;

public interface MountainRepository {
  
  List<Mountain> findAll();
  
  Mountain findById( int Id);
  
  List<Mountain> findByFace (String face);

}
