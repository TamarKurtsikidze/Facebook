package HomeW;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FacebookTest {
    @Test
    public void Register() {

        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";

        open("https://www.facebook.com/");
        //xpathის მეტი ვერაფერი გამოვიყენე რომ accept all cookiesზე დამეკლიკებინა, ბევრი ვეძებე და ყველანაირად ვცადე, მაგრამ არაფერმა იმუშავა ამის გარდა
        $(byXpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]/div")).click();
        $(byText("Create new account")).click();
        $(byXpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]/div")).click();
        $(byName("firstname")).setValue("Tako").pressEnter();
        $(byName("lastname")).setValue("Berzina").pressEnter();
        $("._8g_s").click();
        $(byName("birthday_month")).selectOption("Mar");
        $(byName("birthday_day")).selectOptionByValue("8");
        $(byName("birthday_year")).selectOptionByValue("2001");
        $(byId("sex")).selectRadio("-1");
        $(byName("preferred_pronoun")).shouldBe(Condition.visible);
        $(byName("custom_gender")).shouldBe(Condition.visible);
        $(byName("preferred_pronoun")).selectOption("She: \"Wish her a happy birthday!\"");
        $(byId("sex")).selectRadio("1");
        $(byName("preferred_pronoun")).shouldBe(Condition.hidden);
        $(byName("custom_gender")).shouldBe(Condition.hidden);
        $(byName("reg_email__")).setValue("Tkurtsikidzework@gmail.com").pressEnter();
        $(byName("reg_passwd__")).setValue("Tako.b08").pressEnter();

        sleep(5000);
    }
}
