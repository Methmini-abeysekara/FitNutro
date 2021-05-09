package com.example.fitnutro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private Protein_Calculator protein_Calculator;

    @Before
    public void setup2() {
        protein_Calculator = new Protein_Calculator();
    }

    @Test
    public void testProtein_Calculation() {
        float result =  protein_Calculator.calProtein(80,1);
        assertEquals(80.0, result,0.000001);
    }






    private BMICalculator BMICal;

    @Before
    public void setup() {
        BMICal = new BMICalculator();
    }


    @Test
    public void testBmiCalculation() {
        float result = BMICal.calBMI(80,150);
        assertEquals(35.555557, result,0.000001);
    }
}