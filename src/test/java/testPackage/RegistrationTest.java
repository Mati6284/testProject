package testPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import pages.Registration;


public class RegistrationTest {

    @Test
    public void main() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );
            Page page = browser.newPage();
            page.navigate("https://practicesoftwaretesting.com/auth/register");

            Registration registration = Registration.builder()
                    .page(page)
                    .firstName("User")
                    .lastName("Test")
                    .birthDate("1990-01-01")
                    .build();
            registration.fillCustomerRegistrationData();
            System.out.println(page.title());
            browser.close();
        }
    }
}
