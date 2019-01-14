//package Factory;

import Factory.FactoryDrawArray;
import Screen.DrawArray.DrawArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryDrawArrayTest {
    private FactoryDrawArray factoryDrawArray;

    @Before
    public void setUp() {
        this.factoryDrawArray = new FactoryDrawArray();
    }

    @Test
    public void ITestFactoryDrawArray() {
        DrawArray drawArray = (DrawArray) this.factoryDrawArray.create();

        Assert.assertNotNull(drawArray);
    }

}