/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crouton
 */
@Repository
public class SightingDatabaseDao implements SightingDao{
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Sighting getSightingById(int sightingId) {
        try{
            final String SELECT_SIGHTING_BY_ID = "SELECT * FROM sighting WHERE sighting_id = ?";
            return jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new SightingMapper(), sightingId);
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Sighting> getSightingByDate(String sightingDate) {
        try{
            final String SELECT_SIGHTINGS_BY_DATE = "SELECT * FROM sighting WHERE sighting_date = ? ORDER BY sighting_id";
            List<Sighting> retrievedSightings = jdbc.query(SELECT_SIGHTINGS_BY_DATE, new SightingMapper(), sightingDate);
            return retrievedSightings;
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public int createSighting(Sighting newSighting) {
        final String INSERT_SIGHTING = "INSERT INTO sighting(location_id, sighting_date, super_id) VALUES (?,?,?)";
        jdbc.update(INSERT_SIGHTING, newSighting.getLocationId(), newSighting.getSightingDate(), newSighting.getSuperId());
        int newSightingId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newSighting.setSightingId(newSightingId);
        return newSighting.getSightingId();
    }

    @Override
    public List<Sighting> getSightingBySuperId(int superId) {
        try{
            final String SELECT_SIGHTING_BY_SUPER_ID = "SELECT * FROM sighting WHERE super_id = ?";
            List<Sighting> retrievedSightings = jdbc.query(SELECT_SIGHTING_BY_SUPER_ID, new SightingMapper(), superId);
            return retrievedSightings;
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Sighting> getSightingByLocationId(int locationId) {
        try{
            final String SELECT_SIGHTING_BY_LOCATION_ID = "SELECT * FROM sighting WHERE location_id = ?";
            List<Sighting> retrievedSightings = jdbc.query(SELECT_SIGHTING_BY_LOCATION_ID, new SightingMapper(), locationId);
            return retrievedSightings;
        } catch(DataAccessException ex){
            return null;
        }
    }
    
    public static final class SightingMapper implements RowMapper<Sighting> {
        
        @Override
        public Sighting mapRow(ResultSet rs, int index) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("sighting_id"));
            sighting.setLocationId(rs.getInt("location_id"));
            sighting.setSightingDate(rs.getDate("sighting_date"));
            sighting.setSuperId(rs.getInt("super_id"));
            return sighting;
        }
    }
    
}
