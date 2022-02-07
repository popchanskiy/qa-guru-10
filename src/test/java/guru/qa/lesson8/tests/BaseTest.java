package guru.qa.lesson8.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "http://users.bugred.ru/";
        Configuration.browser = "chrome";
    }
}

