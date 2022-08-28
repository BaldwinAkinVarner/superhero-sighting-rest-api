/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.controller;

import com.sg.superherosighting.dto.Location;
import com.sg.superherosighting.dto.Org;
import com.sg.superherosighting.dto.Sighting;
import com.sg.superherosighting.dto.Superperson;
import com.sg.superherosighting.service.ServiceLayer;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author crouton
 */
@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    ServiceLayer service;
    
    @PostMapping("/sighting")
    @ResponseStatus(HttpStatus.CREATED)
    public int createSighting(@RequestBody Sighting newSighting){
        return service.createSighting(newSighting);
    }
    
    @GetMapping("/super/location/{locationId}")
    public List<Superperson> getSupersAtLocation(@PathVariable int locationId){
        return service.getSupersAtLocation(locationId);
    }
    
    @GetMapping("/location/super/{superId}")
    public List<Location> getLocationsSuperSighted(@PathVariable int superId){
        return service.getLocationsSuperSighted(superId);
    }
    
    @GetMapping("/sighting/{sightingDateStr}")
    public List<Sighting> getSightingsByDate(@PathVariable String sightingDateStr) throws ParseException{
        return service.getSightingsByDate(sightingDateStr);
    }
    
    @GetMapping("/super/org/{orgId}")
    public List<Superperson> getOrgMembers(@PathVariable int orgId){
        return service.getOrgMembers(orgId);
    }
    
    @GetMapping("org/super/{superId}")
    public List<Org> getOrgsBySuperId(@PathVariable int superId){
        return service.getOrgsBySuperId(superId);
    }
}
