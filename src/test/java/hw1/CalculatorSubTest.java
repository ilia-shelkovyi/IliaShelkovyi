package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest extends CalculatorBase {

    @DataProvider
    public Object[][] subDataProvider() {
        return new Object[][]{
                {1, 999, -998},
                {4, 2, 2},
                {2, -8, 10},
                {33, 4, 29}
        };
    }

    @Test(dataProvider = "subDataProvider")
    public void subTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

}
