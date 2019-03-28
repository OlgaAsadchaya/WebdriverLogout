package com.lesson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TutByPageFactoryTest {
    @Test
    public void testTutByPage(){
        TutByPage2 tutByPage = new TutByPage2();
        tutByPage.load();
        tutByPage.login();

        String val = tutByPage.getContentValue();
        assertEquals("Selenium Test", val);
        tutByPage.close();
    }
}
