package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends CalculatorBase {

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][]{
                {1, 2, 3},
                {3, -3, 0},
                {12, 12, 24},
                {6, -8, -2}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void sumTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

}
