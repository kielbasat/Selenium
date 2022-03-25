import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.BaseTest;

import java.util.List;

public class HomeWorkBasicActionsTest extends BaseTest {

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
