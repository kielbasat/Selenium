import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeWorkBasicActionsTest extends TestBase {

    public boolean selectPicker(String car, WebElement selectLocator) {

        Select options = new Select(selectLocator);
        List<WebElement> selectList = options.getOptions();

        for (WebElement option : selectList) {
            if (option.getText().equals(car))
                return true;
        }
        return false;
    }
}
