package com.example.mycalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathEvalTest {
    @Test
    public void eval_division() {
        assertEquals("2.5", MathEval.eval("5/2"));
    }

    @Test
    public void eval_multiplication() {
        assertEquals("15", MathEval.eval("3*5"));
    }

    @Test
    public void eval_multiplication_fail() {
        assertEquals("20", MathEval.eval("3*5"));
    }
}
