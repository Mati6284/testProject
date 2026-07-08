package testPackage;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import pages.Registration;

import java.nio.file.Paths;


public class RegistrationTest {

    @Test
    public void main() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setRecordVideoDir(Paths.get("videos/"))
            );
            context.tracing().start(
                    new Tracing.StartOptions()
                            .setScreenshots(true)
                            .setSnapshots(true)
            );
            Page page = context.newPage();
            page.navigate("https://practicesoftwaretesting.com/auth/register");

            Registration registration = Registration.builder()
                    .page(page)
                    .firstName("User")
                    .lastName("Test")
                    .birthDate("1990-01-01")
                    .build();
            registration.fillCustomerRegistrationData();
            System.out.println("Koniec testu");

            context.tracing().stop(
                    new Tracing.StopOptions()
                            .setPath(Paths.get("trace.zip"))
            );

            context.close();
            browser.close();
        }
    }
}
