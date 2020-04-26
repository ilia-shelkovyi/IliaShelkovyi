package hw7.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import hw7.enities.User;
import hw7.forms.LoginForm;

@Url("/index.html")
public class HomePage extends WebPage {

    @Css("#user-icon")
    private Button userIcon;

    @Css("#user-name")
    private Text userFullName;

    @Css(".m-l8 > li")
    private Menu headerMenu;

    private LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void checkLogged(User user) {
    	userFullName.is().text(user.getFullName());
    }

    public void select(String item) {
    	headerMenu.select(item);
    }

}