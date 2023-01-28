package com.William.skiTrail.entity;


public class Trail {
  

  private int trail_id;
  

  private String trail_name;

  private String trail_difficulty;

  private String trail_features;

  public Trail() {

  }
  
  public Trail(int trail_id, String trail_name, String trail_features, String trail_difficulty) {
    this.trail_id = trail_id;
    this.trail_name = trail_name;
    this.trail_difficulty = trail_difficulty;
    this.trail_features = trail_features;
  }

  public Trail(String trail_name, String trail_difficulty, String trail_features) {
    this.trail_name = trail_name;
    this.trail_difficulty = trail_difficulty;
    this.trail_features = trail_features;
  }
  


  public int getTrail_id() {
    return trail_id;
  }

  public void setTrail_id(int trail_id) {
    this.trail_id = trail_id;
  }

  public String getTrail_name() {
    return trail_name;
  }

  public void setTrail_name(String trail_name) {
    this.trail_name = trail_name;
  }

  public String getTrail_difficulty() {
    return trail_difficulty;
  }

  public void setTrail_difficulty(String trail_difficulty) {
    this.trail_difficulty = trail_difficulty;
  }

  public String getTrail_features() {
    return trail_features;
  }

  public void setTrail_features(String trail_features) {
    this.trail_features = trail_features;
  }

  @Override
  public String toString() {
    return "Trail [id=" + trail_id + ", name=" + trail_name + ", difficulty=" + trail_difficulty + ", features="
  + trail_features + "]";
  }

}
