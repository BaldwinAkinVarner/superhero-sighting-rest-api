/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.TestApplicationConfiguration;
import com.sg.superherosighting.dto.Sighting;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author crouton
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class SightingDatabaseDaoTest {
    
    @Autowired
    SightingDatabaseDao sightingDao;
    
    public SightingDatabaseDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSighting and getSightingById methods, of class SightingDatabaseDao.
     */
    @Test
    public void testCreateGetSighting() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sightingDate = dateFormat.parse("2020-06-09");
        Sighting createdSighting = new Sighting(1, sightingDate, 1);
        int sightingId = sightingDao.createSighting(createdSighting);
        createdSighting.setSightingId(sightingId);
        
        Sighting retrievedSighting = sightingDao.getSightingById(sightingId);
        
        assertEquals(retrievedSighting.getLocationId(), createdSighting.getLocationId());
        //assertEquals(retrievedSighting.getSightingDate(), sightingDate);
        assertEquals(retrievedSighting.getSightingId(), createdSighting.getSightingId());
        assertEquals(retrievedSighting.getSuperId(), createdSighting.getSuperId());
        
    }

    /**
     * Test of getSightingByDate method, of class SightingDatabaseDao.
     */
    @Test
    public void testGetSightingByDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sightingDate = dateFormat.parse("2020-06-09");
        
        Sighting firstSighting = new Sighting(1, sightingDate, 1);
        int firstSightingId = sightingDao.createSighting(firstSighting);
        Sighting firstRetrievedSighting = sightingDao.getSightingById(firstSightingId);
        
        Sighting secondSighting = new Sighting(1, sightingDate, 1);
        int secondSightingId = sightingDao.createSighting(secondSighting);
        firstSighting.setSightingId(secondSightingId);
        Sighting secondRetrievedSighting = sightingDao.getSightingById(secondSightingId);
        
        List<Sighting> sightingList = sightingDao.getSightingByDate("2020-06-09");
        
        assertTrue(sightingList != null);
//        assertTrue(sightingList.contains(firstRetrievedSighting));
//        assertTrue(sightingList.contains(secondRetrievedSighting));
        
    }

    /**
     * Test of getSightingBySuperId method, of class SightingDatabaseDao.
     */
    @Test
    public void testGetSightingBySuperId() {
    }

    /**
     * Test of getSightingByLocationId method, of class SightingDatabaseDao.
     */
    @Test
    public void testGetSightingByLocationId() {
    }
    
}
