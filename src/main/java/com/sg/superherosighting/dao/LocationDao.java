/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Location;
import java.util.List;

/**
 *
 * @author crouton
 */
public interface LocationDao {
    Location getLocationById(int locationId);
    List<Location> reportHeroLocations();
}
