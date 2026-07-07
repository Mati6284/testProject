package pages;

import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class Registration {
    private Page page;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String country;

    private final static String firstNameField = "input[id='first_name']";
    private final static String lastNameField = "input[id='last_name']";
    private final static String birthDateField = "input[id='dob']";
    private final static String countryField = "select[id='country']";

    public void fillCustomerRegistrationData(){
        page.click(firstNameField);
        page.fill(firstNameField, firstName);
        page.click(lastNameField);
        page.fill(lastNameField, lastName);
        page.click(birthDateField);
        page.fill(birthDateField, birthDate);
    }
}
