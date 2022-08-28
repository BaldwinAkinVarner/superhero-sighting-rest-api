/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dto;

import java.util.Objects;

/**
 *
 * @author crouton
 */
public class Location {
    
    private int locationId;
    private String locationName;
    private String locationDescription;
    private String locationAddress;
    private double longitude;
    private double latitude;

    public Location(int locationId, String locationName, String locationDescription, String locationAddress, double longitude, double latitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationAddress = locationAddress;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location() {
    }

    public Location(int locationId) {
        this.locationId = locationId;
    }
    
    
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.locationId;
        hash = 23 * hash + Objects.hashCode(this.locationName);
        hash = 23 * hash + Objects.hashCode(this.locationDescription);
        hash = 23 * hash + Objects.hashCode(this.locationAddress);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
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
        final Location other = (Location) obj;
        if (this.locationId != other.locationId) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        return Objects.equals(this.locationAddress, other.locationAddress);
    }

    @Override
    public String toString() {
        return "Location{" + "locationId=" + locationId + ", locationName=" + locationName + ", locationDescription=" + locationDescription + ", locationAddress=" + locationAddress + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    
    
    
}
