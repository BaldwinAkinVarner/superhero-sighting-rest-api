/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.service;


import com.sg.superherosighting.dao.AffiliationDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sg.superherosighting.dao.LocationDao;
import com.sg.superherosighting.dao.OrgDao;
import com.sg.superherosighting.dao.SightingDao;
import com.sg.superherosighting.dao.SuperpersonDao;
import com.sg.superherosighting.dto.Affiliation;
import com.sg.superherosighting.dto.Location;
import com.sg.superherosighting.dto.Org;
import com.sg.superherosighting.dto.Sighting;
import com.sg.superherosighting.dto.Superperson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author crouton
 */
@Service
public class ServiceLayer {
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrgDao orgDao;
    
    @Autowired
    SightingDao sightingDao;
    
    @Autowired
    SuperpersonDao superPersonDao;
    
    @Autowired
    AffiliationDao affiliationDao;


    public int createSighting(Sighting newSighting) {
        return sightingDao.createSighting(newSighting);
    }

    public List<Sighting> getSightingsByDate(String sightingDateStr) throws ParseException {
        List<Sighting> listOfSightings = sightingDao.getSightingByDate(sightingDateStr);
        return listOfSightings;
    }

    public List<Location> getLocationsSuperSighted(int superId) {
        List<Sighting> listOfSightings = sightingDao.getSightingBySuperId(superId);
        List<Location> listOfLocations = new ArrayList<>();
//        Location nullAvoider = new Location(0);
//        listOfLocations.add(nullAvoider);
        for (Sighting sighting : listOfSightings){
            if (!listOfLocations.contains(locationDao.getLocationById(sighting.getLocationId()))){
                listOfLocations.add(locationDao.getLocationById(sighting.getLocationId()));
            }
        }
        return listOfLocations;
    }

    public List<Superperson> getSupersAtLocation(int locationId) {
        List<Sighting> listOfSightings = sightingDao.getSightingByLocationId(locationId);
        List<Superperson> listOfSupers = new ArrayList<>();
//        Superperson nullAvoider = new Superperson(0);
//        listOfSupers.add(nullAvoider);
        for (Sighting sighting : listOfSightings){
            if (!listOfSupers.contains(superPersonDao.getSuperById(sighting.getSuperId()))){
                listOfSupers.add(superPersonDao.getSuperById(sighting.getSuperId()));
            }
        }
        return listOfSupers;
    }

    public List<Superperson> getOrgMembers(int orgId) {
        List<Affiliation> affiliationsList = affiliationDao.getAffiliationByOrgId(orgId);
        List<Superperson> listOfSupers = new ArrayList<>();
//        Superperson nullAvoider = new Superperson(0);
//        listOfSupers.add(nullAvoider);
        for (Affiliation affiliation : affiliationsList){
            if (!listOfSupers.contains(superPersonDao.getSuperById(affiliation.getSuperId()))){
                listOfSupers.add(superPersonDao.getSuperById(affiliation.getSuperId()));
            }
        }
        
        return listOfSupers;
    }

    public List<Org> getOrgsBySuperId(int superId) {
        List<Affiliation> affiliationsList = affiliationDao.getAffiliationBySuperId(superId);
        List<Org> listOfOrgs = new ArrayList<>();
//        Org nullAvoider = new Org(0);
//        listOfOrgs.add(nullAvoider);
        for (Affiliation affiliation : affiliationsList){
            if (!listOfOrgs.contains(orgDao.getOrgById(affiliation.getOrgId()))){
                listOfOrgs.add(orgDao.getOrgById(affiliation.getOrgId()));
            }
        }
        
        return listOfOrgs;
    }
    


}
