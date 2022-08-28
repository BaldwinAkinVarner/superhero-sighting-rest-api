/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author crouton
 */
public class Sighting {
    
    private int sightingId;
    private int locationId;
    private Date sightingDate;
    private int superId;

    public Sighting(int sightingId, int locationId, Date sightingDate, int superId) {
        this.sightingId = sightingId;
        this.locationId = locationId;
        this.sightingDate = sightingDate;
        this.superId = superId;
    }
    
    public Sighting(int locationId, Date sightingDate, int superId) {
        this.locationId = locationId;
        this.sightingDate = sightingDate;
        this.superId = superId;
    }

    public Sighting() {
    }

    public Sighting(int sightingId) {
        this.sightingId = sightingId;
    }
    
    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Date getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(Date sightingDate) {
        this.sightingDate = sightingDate;
    }

    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }

    @Override
    public String toString() {
        return "Sighting{" + "sightingId=" + sightingId + ", locationId=" + locationId + ", sightingDate=" + sightingDate + ", superId=" + superId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.sightingId;
        hash = 61 * hash + this.locationId;
        hash = 61 * hash + Objects.hashCode(this.sightingDate);
        hash = 61 * hash + this.superId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        if (this.superId != other.superId) {
            return false;
        }
        return Objects.equals(this.sightingDate, other.sightingDate);
    }
    
    
    
    
}
