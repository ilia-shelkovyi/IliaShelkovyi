package hw1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.epam.tat.module4.Calculator;

public class CalculatorBase {

    protected Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

}
