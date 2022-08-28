/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Org;
import com.sg.superherosighting.dto.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class OrgDatabaseDao implements OrgDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Org getOrgById(int orgId) {
        try{
            final String SELECT_ORG_BY_ID = "SELECT * FROM org WHERE org_id = ?";
            return jdbc.queryForObject(SELECT_ORG_BY_ID, new OrgMapper(), orgId);
        } catch(DataAccessException ex){
            return null;
        }
    }
    
    public static final class OrgMapper implements RowMapper<Org> {
        
        @Override
        public Org mapRow(ResultSet rs, int index) throws SQLException {
            Org org = new Org();
            org.setOrgAddress(rs.getString("org_address"));
            org.setOrgContactInfo(rs.getString("contact_info"));
            org.setOrgDescription(rs.getString("org_description"));
            org.setOrgId(rs.getInt("org_id"));
            org.setOrgName(rs.getString("org_name"));
            return org;
        }
    }
    
}
