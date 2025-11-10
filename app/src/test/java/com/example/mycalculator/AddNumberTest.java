package com.example.mycalculator;

import org.junit.Test;
import org.mozilla.javascript.tools.jsc.Main;

import static org.junit.Assert.*;

public class AddNumberTest {
    @Test
    public void test_append() {
        String res = MainActivity.addNumber("3", "51+2");
        assertEquals("51+23", res);
    }

    @Test
    public void test_append_empty() {
        String res = MainActivity.addNumber("3", "");
        assertEquals("3", res);
    }

    @Test
    public void test_add_fail() {
        String res = MainActivity.addNumber("5", "3+");
        assertEquals("8", res);
    }
}
