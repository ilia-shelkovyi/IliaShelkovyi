package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivTest extends CalculatorBase {

    @DataProvider
    public Object[][] divDataProvider() {
        return new Object[][]{
                {3, 2, 1.5},
                {77, 77, 1},
                {100, 10, 10},
                {6, -3, -2}
        };
    }

    @Test(dataProvider = "divDataProvider")
    public void divTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

}
