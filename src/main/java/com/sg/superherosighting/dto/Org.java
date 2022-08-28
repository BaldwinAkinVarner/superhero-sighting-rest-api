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
public class Org {
    
    private int orgId;
    private String orgName;
    private String orgDescription;
    private String orgAddress;
    private String orgContactInfo;

    public Org(int orgId, String orgName, String orgDescription, String orgAddress, String orgContactInfo) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgDescription = orgDescription;
        this.orgAddress = orgAddress;
        this.orgContactInfo = orgContactInfo;
    }

    public Org() {
    }

    public Org(int orgId) {
        this.orgId = orgId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgContactInfo() {
        return orgContactInfo;
    }

    public void setOrgContactInfo(String orgContactInfo) {
        this.orgContactInfo = orgContactInfo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.orgId;
        hash = 13 * hash + Objects.hashCode(this.orgName);
        hash = 13 * hash + Objects.hashCode(this.orgDescription);
        hash = 13 * hash + Objects.hashCode(this.orgAddress);
        hash = 13 * hash + Objects.hashCode(this.orgContactInfo);
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
        final Org other = (Org) obj;
        if (this.orgId != other.orgId) {
            return false;
        }
        if (!Objects.equals(this.orgName, other.orgName)) {
            return false;
        }
        if (!Objects.equals(this.orgDescription, other.orgDescription)) {
            return false;
        }
        if (!Objects.equals(this.orgAddress, other.orgAddress)) {
            return false;
        }
        return Objects.equals(this.orgContactInfo, other.orgContactInfo);
    }

    @Override
    public String toString() {
        return "Org{" + "orgId=" + orgId + ", orgName=" + orgName + ", orgDescription=" + orgDescription + ", orgAddress=" + orgAddress + ", orgContactInfo=" + orgContactInfo + '}';
    }
    
    
    
}
