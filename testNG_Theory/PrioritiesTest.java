package testNG_Theory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PrioritiesTest extends Assert {
    private boolean firstTestExecuted;

    @BeforeClass
    public void setUp() throws Exception {
        firstTestExecuted = false;
    }

    @Test(priority = 0)
    public void first() {
        assertFalse(firstTestExecuted);
        firstTestExecuted = true;
    }

    @Test(priority = 1)
    public void second() {
        assertTrue(firstTestExecuted);
    }

    @Test(dependsOnMethods = {"first"})
    public void third() {
        assertTrue(firstTestExecuted);
    }
}