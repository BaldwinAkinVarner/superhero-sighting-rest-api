/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Org;
import com.sg.superherosighting.dto.Superperson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class SuperpersonDatabaseDao implements SuperpersonDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Superperson getSuperById(int superId) {
        try{
            final String SELECT_SUPER_BY_ID = "SELECT * FROM superperson WHERE super_id = ?";
            return jdbc.queryForObject(SELECT_SUPER_BY_ID, new SuperMapper(), superId);
        } catch(DataAccessException ex){
            return null;
        }
    }

    public static final class SuperMapper implements RowMapper<Superperson> {
        
        @Override
        public Superperson mapRow(ResultSet rs, int index) throws SQLException {
            Superperson superperson = new Superperson();
            superperson.setIsEvil(rs.getBoolean("isevil"));
            superperson.setPower(rs.getString("power"));
            superperson.setSuperDescription(rs.getString("super_description"));
            superperson.setSuperId(rs.getInt("super_id"));
            superperson.setSuperName(rs.getString("super_name"));
            return superperson;
        }
    }
}
