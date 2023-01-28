package com.William.skiTrail.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.William.skiTrail.entity.Mountain;

@Repository
public class JdbcMountainRepository implements MountainRepository{

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public List<Mountain> findAll() {
    return jdbcTemplate.query("SELECT * from mountain_face", BeanPropertyRowMapper.newInstance(Mountain.class));
  }

  @Override
  public Mountain findById(int Id) {
    try {
      Mountain mountain = jdbcTemplate.queryForObject("SELECT * FROM mountain_face WHERE mountain_face_id=?",
          BeanPropertyRowMapper.newInstance(Mountain.class), Id);

      return mountain;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public List<Mountain> findByFace(String face) {
    String q = "SELECT * from mountain_face WHERE mountain_face LIKE '%" + face + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Mountain.class));


  }

}
