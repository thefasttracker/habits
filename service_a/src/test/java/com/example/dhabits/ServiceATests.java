package com.example.dhabits;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServiceATests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testOne() {
        assertEquals(4, "Duke".length());
    }

}
