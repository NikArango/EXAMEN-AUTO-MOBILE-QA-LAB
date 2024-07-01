package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginScreen extends PageObject {

/*    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
    private WebElement btnClose;*/

        @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement btnClose;
    @AndroidFindBy(id = "com.airbnb.android:id/start_button")
    private WebElement btnBuscar;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.airbnb.android:id/stays_where_panel_compose\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")
    private WebElement btnBoxBuscar;
    @AndroidFindBy(id = "com.airbnb.android:id/input_bar_input")
    private WebElement inputBusqueda;
    @AndroidFindBy(id = "com.airbnb.android:id/n2_simple_search_footer_link")
    private WebElement btnSkip;
    @AndroidFindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    private WebElement btnSearch;
/*    @AndroidFindBy(id = "com.airbnb.android:id/n2_bottom_sheet_title_title")
    private WebElement ltext;*/
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Over 1,000 places\")")
    private WebElement ltext;

    @AndroidFindBy(id = "com.airbnb.android:id/map_pill")
    private WebElement btnMap;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Google map Showing 16 stays.']/android.view.View")
    private List<WebElement> allresults;

    @AndroidFindBy(xpath ="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    private WebElement btnNoAllow;

    @AndroidFindBy(xpath = "//android.widget.GridView[@content-desc=\"Explore Airbnb\"]/android.widget.FrameLayout/android.view.ViewGroup")
    private WebElement ltext1;

    public void  cerrarVentana(){
       WebDriverWait wait = new WebDriverWait(getDriver(), 60);

        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        btnNoAllow.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnClose));
      //  getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        btnClose.click();
   };
    public void  buscarTexto(String textbuscar){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(btnBuscar));
        btnBuscar.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnBoxBuscar));
        btnBoxBuscar.click();
        inputBusqueda.sendKeys(textbuscar);
        String cmd = "adb shell input keyevent 66";
        try {
            Runtime.getRuntime().exec(cmd);
        }catch(Exception e) {
        }



    };
    public void   seleccionarOpcionSkip(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(btnSkip));
        btnSkip.click();
    };
    public void presionarBotnBuscar(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(btnSearch));
        btnSearch.click();
    };
    public void  validar(int nresults,String textvalidar){
        WebDriverWait wait = new WebDriverWait(getDriver(), 65);
        wait.until(ExpectedConditions.visibilityOf(ltext1));
        wait.until(ExpectedConditions.visibilityOf(ltext));
        System.out.println("el valor es: "+ltext.getText());

        Assert.assertEquals(textvalidar,ltext.getText());
        wait.until(ExpectedConditions.visibilityOf(btnMap));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        btnMap.click();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("el tamaño  es: "+allresults.size());
        assertTrue(allresults.size()>nresults);



    };

}
