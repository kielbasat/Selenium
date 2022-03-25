package pl.testeroprogramowania;

import org.testng.annotations.Test;

public class ThirdTest {

    @Test(priority = 2)
    public void firstTest() {
        System.out.println("Im first test");
    }

    @Test(priority = 1)
    public void secondTest() {
        System.out.println("Im second test");
    }

    @Test(priority = 0)
    public void thirdTest() {
        System.out.println("Im third test");
    }
}
