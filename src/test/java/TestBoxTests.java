import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Torneyd Boom";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("somemail@gmail.com");
        $("#currentAddress").setValue("Some Address");
        $("permanentAddress").setValue("Second Address");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text("somemail@gmail.com")));
    }
}
