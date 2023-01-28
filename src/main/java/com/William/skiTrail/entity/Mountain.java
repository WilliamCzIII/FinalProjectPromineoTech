package com.William.skiTrail.entity;

public class Mountain {

  private int mountain_face_id;
  
  private String mountain_face;
  
  public Mountain() {
    
  }
  
  public Mountain(int mountain_face_id, String mountain_face) {
    this.mountain_face=mountain_face;
    this.mountain_face_id=mountain_face_id;
  }
  
  public Mountain(String mountain_face) {
    this.mountain_face=mountain_face;
  }

  public int getMountain_face_id() {
    return mountain_face_id;
  }

  public void setMountain_face_id(int mountain_face_id) {
    this.mountain_face_id = mountain_face_id;
  }

  public String getMountain_face() {
    return mountain_face;
  }

  public void setMountain_face(String mountain_face) {
    this.mountain_face = mountain_face;
  }

  @Override
  public String toString() {
    return "Mountain [mountain_face_id=" + mountain_face_id + ", mountain_face=" + mountain_face
        + "]";
  }
}

