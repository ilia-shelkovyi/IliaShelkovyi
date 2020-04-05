package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest extends CalculatorBase {

    @DataProvider
    public Object[][] multDataProvider() {
        return new Object[][]{
                {3, 4, 12},
                {4, -2, -8},
                {0, 987, 0},
                {-1, -54, 54}
        };
    }

    @Test(dataProvider = "multDataProvider")
    public void multTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

}
