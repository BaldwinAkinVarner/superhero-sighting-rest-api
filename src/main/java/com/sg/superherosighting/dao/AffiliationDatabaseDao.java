/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Affiliation;
import com.sg.superherosighting.dto.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class AffiliationDatabaseDao implements AffiliationDao{

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Affiliation getAffiliationById(int affiliationId) {
        try{
            final String SELECT_AFFILIATION_BY_ID = "SELECT * FROM affiliation WHERE affiliation_id = ?";
            return jdbc.queryForObject(SELECT_AFFILIATION_BY_ID, new AffiliationMapper(), affiliationId);
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Affiliation> getAffiliationBySuperId(int superId) {
        try{
            final String SELECT_AFFILIATIONS_BY_SUPER_ID = "SELECT * FROM affiliation WHERE super_id = ? ORDER BY org_id";
            List<Affiliation> retrievedAffiliations = jdbc.query(SELECT_AFFILIATIONS_BY_SUPER_ID, new AffiliationMapper(), superId);
            return retrievedAffiliations;
        } catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Affiliation> getAffiliationByOrgId(int orgId) {
        try{
            final String SELECT_AFFILIATIONS_BY_ORG_ID = "SELECT * FROM affiliation WHERE org_id = ? ORDER BY super_id";
            List<Affiliation> retrievedAffiliations = jdbc.query(SELECT_AFFILIATIONS_BY_ORG_ID, new AffiliationMapper(), orgId);
            return retrievedAffiliations;
        } catch(DataAccessException ex){
            return null;
        }
    }
    
    public static final class AffiliationMapper implements RowMapper<Affiliation> {
        
        @Override
        public Affiliation mapRow(ResultSet rs, int index) throws SQLException {
            Affiliation affiliation = new Affiliation();
            affiliation.setAffiliationId(rs.getInt("affiliation_id"));
            affiliation.setOrgId(rs.getInt("org_id"));
            affiliation.setSuperId(rs.getInt("super_id"));
            return affiliation;
        }
    }
    
}
