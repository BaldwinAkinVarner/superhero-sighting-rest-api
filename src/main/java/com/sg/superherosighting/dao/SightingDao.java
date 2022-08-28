/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Sighting;
import java.util.Date;
import java.util.List;

/**
 *
 * @author crouton
 */
public interface SightingDao {
    Sighting getSightingById(int sightingId);
    List<Sighting> getSightingByDate(String sightingDate);
    int createSighting(Sighting newSighting);
    List<Sighting> getSightingBySuperId(int superId);
    List<Sighting> getSightingByLocationId(int locationId);
}
