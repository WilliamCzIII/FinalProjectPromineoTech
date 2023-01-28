package com.William.skiTrail.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.William.skiTrail.entity.Trail;

@Repository
public class JdbcTrailRepository implements TrailRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Override
  public int save(Trail trail) {
    return jdbcTemplate.update("INSERT INTO trail (trail_name, trail_features, trail_difficulty) VALUES(?,?,?)",
        new Object[] { trail.getTrail_name(), trail.getTrail_features(), trail.getTrail_difficulty() });}
  
  

  @Override
  public int update(Trail trail) {
    return jdbcTemplate.update("UPDATE trail SET trail_name=?, trail_features=?, trail_difficulty=? WHERE trail_id=?",
        new Object[] { trail.getTrail_name(), trail.getTrail_features(), trail.getTrail_difficulty(), trail.getTrail_id() });
  };
  

  @Override
  public Trail findById(int Id) {
    try {
      Trail trail = jdbcTemplate.queryForObject("SELECT * FROM trail WHERE trail_id=?",
          BeanPropertyRowMapper.newInstance(Trail.class), Id);

      return trail;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(int Id) {
    return jdbcTemplate.update("DELETE FROM trail WHERE trail_id=?", Id);
  }

  @Override
  public List<Trail> findAll() {
    return jdbcTemplate.query("SELECT * from trail", BeanPropertyRowMapper.newInstance(Trail.class));
  }



  @Override
  public List<Trail> findByDifficulty(boolean difficulty) {
    return jdbcTemplate.query("SELECT * from trail WHERE trail_difficulty=?",
        BeanPropertyRowMapper.newInstance(Trail.class), difficulty);
  }



  @Override
  public List<Trail> findByFeature(String trail) {
    String q = "SELECT * from trail WHERE trail_features LIKE '%" + trail + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Trail.class));

  }



  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from trail");
  }

}
