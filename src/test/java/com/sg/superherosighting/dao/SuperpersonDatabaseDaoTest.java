/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.sg.superherosighting.dao;

import com.sg.superherosighting.TestApplicationConfiguration;
import com.sg.superherosighting.dto.Superperson;
import com.sg.superherosighting.dao.SuperpersonDatabaseDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author crouton
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class SuperpersonDatabaseDaoTest {
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Autowired
    SuperpersonDatabaseDao superDao;
    
    public SuperpersonDatabaseDaoTest() {
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
     * Test of getSuperById method, of class SuperpersonDatabaseDao.
     */
    @Test
    public void testGetSuperById() {
        Superperson testSuper = new Superperson(1, "Batman", "No parents = spite", "Privelege", false);
        
        Superperson retrievedSuper = superDao.getSuperById(1);
        
        assertEquals(testSuper, retrievedSuper);
    }

    
}
