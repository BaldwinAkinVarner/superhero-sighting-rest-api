/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.superherosighting.dto;

/**
 *
 * @author crouton
 */
public class Affiliation {
    
    private int affiliationId;
    private int superId;
    private int orgId;

    public Affiliation(int affiliationId, int superId, int orgId) {
        this.affiliationId = affiliationId;
        this.superId = superId;
        this.orgId = orgId;
    }

    public Affiliation() {
    }

    public Affiliation(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "Affiliation{" + "affiliationId=" + affiliationId + ", superId=" + superId + ", orgId=" + orgId + '}';
    }
    
}
