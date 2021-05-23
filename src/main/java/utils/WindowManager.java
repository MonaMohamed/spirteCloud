package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchToTab(String tabTitle){
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Number of tabes: "+windows.size());

        System.out.println("Window Handles: ");
        windows.forEach(System.out::println);

        for (String window : windows){
            driver.switchTo().window(window);

            System.out.println("Current Window Title is: "+ driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    public void switchToNewTab(){
        Set<String> windows = driver.getWindowHandles();

        windows.forEach(driver.switchTo()::window);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
}
