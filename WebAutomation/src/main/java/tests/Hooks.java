package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTestClass{
	
	@Before
    public void setUp() {
        initializeDriver();
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}