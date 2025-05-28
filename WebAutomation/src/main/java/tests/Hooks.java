package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTestClass{
	
	@Before
    public void setUp() {
        initializeDriver();
        System.out.println("Driver initialized in @Before: " + driver);
    }

    @After
    public void tearDown() {
        quitDriver();
        System.out.println("Driver quit in @After");
    }
}