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
public class Superperson {
    
    private int superId;
    private String superName;
    private String superDescription;
    private String power;
    private boolean isEvil;

    public Superperson(int superId, String superName, String superDescription, String power, boolean isEvil) {
        this.superId = superId;
        this.superName = superName;
        this.superDescription = superDescription;
        this.power = power;
        this.isEvil = isEvil;
    }

    public Superperson() {
    }

    public Superperson(int superId) {
        this.superId = superId;
    }
    
    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getSuperDescription() {
        return superDescription;
    }

    public void setSuperDescription(String superDescription) {
        this.superDescription = superDescription;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean isIsEvil() {
        return isEvil;
    }

    public void setIsEvil(boolean isEvil) {
        this.isEvil = isEvil;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.superId;
        hash = 67 * hash + Objects.hashCode(this.superName);
        hash = 67 * hash + Objects.hashCode(this.superDescription);
        hash = 67 * hash + Objects.hashCode(this.power);
        hash = 67 * hash + (this.isEvil ? 1 : 0);
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
        final Superperson other = (Superperson) obj;
        if (this.superId != other.superId) {
            return false;
        }
        if (this.isEvil != other.isEvil) {
            return false;
        }
        if (!Objects.equals(this.superName, other.superName)) {
            return false;
        }
        if (!Objects.equals(this.superDescription, other.superDescription)) {
            return false;
        }
        return Objects.equals(this.power, other.power);
    }

    @Override
    public String toString() {
        return "Superperson{" + "superId=" + superId + ", superName=" + superName + ", superDescription=" + superDescription + ", power=" + power + ", isEvil=" + isEvil + '}';
    }
    
    
}
