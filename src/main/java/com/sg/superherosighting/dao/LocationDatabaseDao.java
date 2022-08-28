/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Location;
import com.sg.superherosighting.dto.Superperson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author crouton
 */
@Repository
public class LocationDatabaseDao implements LocationDao{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Location getLocationById(int locationId) {
        try{
            final String SELECT_LOCATION_BY_ID = "SELECT * FROM location WHERE location_id = ?";
            return jdbc.queryForObject(SELECT_LOCATION_BY_ID, new LocationMapper(), locationId);
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Location> reportHeroLocations() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static final class LocationMapper implements RowMapper<Location> {
        
        @Override
        public Location mapRow(ResultSet rs, int index) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("location_id"));
            location.setLocationName(rs.getString("location_name"));
            location.setLocationDescription(rs.getString("location_description"));
            location.setLocationAddress(rs.getString("address"));
            location.setLongitude(rs.getDouble("longitude"));
            location.setLatitude(rs.getDouble("latitude"));
            return location;
        }
    }
}
