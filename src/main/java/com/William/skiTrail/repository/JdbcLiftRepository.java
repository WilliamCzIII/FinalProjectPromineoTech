package com.William.skiTrail.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.William.skiTrail.entity.Lift;

@Repository
public class JdbcLiftRepository implements LiftRepository{

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public List<Lift> findAll() {
    return jdbcTemplate.query("SELECT * from lift", BeanPropertyRowMapper.newInstance(Lift.class));
  }

  @Override
  public Lift findById(int Id) {
    try {
      Lift lift = jdbcTemplate.queryForObject("SELECT * FROM lift WHERE lift_id=?",
          BeanPropertyRowMapper.newInstance(Lift.class), Id);

      return lift;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public List<Lift> findByName(String lift) {
    String q = "SELECT * from lift WHERE lift_name LIKE '%" + lift + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Lift.class));


  }

}
