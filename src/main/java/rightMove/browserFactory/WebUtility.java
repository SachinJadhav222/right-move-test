package rightMove.browserFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility Calls fo Reusable Methods
 */
public class WebUtility extends RM_DriverBase {
    public static void select_dropdown_by_visible_text(WebElement element, String visible_text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visible_text);
    }
}
