package com.William.skiTrail.entity;

public class Lift {

  private int lift_id;
  
  private String lift_name;
  
  private int lift_chair_size;
  
  private int mountain_face_id;

  public Lift() {
    
  }
  
  public Lift(int lift_id, String lift_name, int lift_chair_size) {
    this.lift_id=lift_id;
    this.lift_name=lift_name;
    this.lift_chair_size=lift_chair_size;
  }
  public Lift( String lift_name, int lift_chair_size) {
    this.lift_name=lift_name;
    this.lift_chair_size=lift_chair_size;
  }
  
  public int getLift_id() {
    return lift_id;
  }

  public void setLift_id(int lift_id) {
    this.lift_id = lift_id;
  }

  public String getLift_name() {
    return lift_name;
  }

  public void setLift_name(String lift_name) {
    this.lift_name = lift_name;
  }

  public int getLift_chair_size() {
    return lift_chair_size;
  }

  public void setLift_chair_size(int lift_chair_size) {
    this.lift_chair_size = lift_chair_size;
  }
  
  public int getMountain_face_id() {
    return mountain_face_id;
  }

  public void setMountain_face_id(int mountain_face_id) {
    this.mountain_face_id = mountain_face_id;
  }

  @Override
  public String toString() {
    return "Lift [lift_id=" + lift_id + ", lift_name=" + lift_name + ", lift_chair_size="
        + lift_chair_size + ", mountain_face_id=" + mountain_face_id + "]";
  }


   
  
}
