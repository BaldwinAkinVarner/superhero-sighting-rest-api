/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.dto.Affiliation;
import java.util.List;

/**
 *
 * @author crouton
 */
public interface AffiliationDao {
    Affiliation getAffiliationById(int affiliationId);
    List<Affiliation> getAffiliationBySuperId(int superId);
    List<Affiliation> getAffiliationByOrgId(int orgId);
}
