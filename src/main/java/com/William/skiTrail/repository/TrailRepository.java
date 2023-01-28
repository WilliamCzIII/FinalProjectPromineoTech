package com.William.skiTrail.repository;

import java.util.List;
import com.William.skiTrail.entity.Trail;


public interface TrailRepository {
  
  int save(Trail trail);
  
  int update(Trail trail);
  
  Trail findById(int Id);
  
  int deleteById( int Id);
  
  List<Trail> findAll();
  
  List<Trail> findByDifficulty(boolean difficulty);
  
  List<Trail> findByFeature (String trail);
  
  int deleteAll();
  
  

}
