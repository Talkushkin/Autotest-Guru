package demoga.com.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SystemPropertiesTests {
    @Test
    void someTest1() {
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void someTest2() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
    }

    @Test
    void someTest3() {
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);
    }

    @Test
    @Tag("test4")
    void someTest4() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "101");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }

    @Test
    @Tag("systemProperties")
    void someTest5() {
        System.out.println(" i want to say: " + System.getProperty("anyText"));
    }
}
