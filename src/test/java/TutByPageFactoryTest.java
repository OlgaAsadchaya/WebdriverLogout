import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TutByPageFactoryTest {
    @Test
    public void testTutByPageLogin(){
        String login = "seleniumtests@tut.by";
        String password = "123456789zxcvbn";

        TutByPage tutByPage = new TutByPage();
        tutByPage.login(login, password);

        String val = tutByPage.getExitPopupValue();
        assertEquals("Selenium Test", val);
    }

    @Test
    public void testTutByPageLoout() {
        String login = "seleniumtests@tut.by";
        String password = "123456789zxcvbn";

        TutByPage tutByPage = new TutByPage();
        tutByPage.login(login, password);

        HomePage homePage = new HomePage();
        homePage.logout();
        assertTrue(homePage.isEnterPopupExists(), "Login failure: login popup doesn't appear");
    }
}
