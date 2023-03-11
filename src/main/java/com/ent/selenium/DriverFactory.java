/*package com.ent.selenium;

import com.ent.config.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    private WebDriver driver;
    public WebDriver getDriver() {
        ResourceBundle config = ResourceBundle.getBundle("testconfig");
        _setDriver(DriverTypes.valueOf(config.getString("browser").toUpperCase()));
        return driver;
    }
    public WebDriver getDriver(DriverTypes browser) {
        _setDriver(browser);
        return driver;
    }
    private void _setDriver(DriverTypes browser) {
        switch (browser) {
            case CHROME:
                //System.setProperty("webdriver.chrome.driver", Parameters.get("chrome.driver.path"));
                System.setProperty("webdriver.chrome.driver", "C:/Entyle_video/Automation_web/chromedriver_win32/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", Parameters.get("gecko.driver.path"));
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", false);
                //    System.setProperty("webdriver.gecko.driver","C:/SelDrivers/geckodriver.exe");
                driver = new FirefoxDriver(capabilities);
                break;
            case INTERNETEXPLORER:
                System.setProperty("webdriver.ie.driver", Parameters.get("ie.driver.path"));
                //System.setProperty("webdriver.ie.driver", "C:/SelDrivers/New folder/IEDriverServer.exe");
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
                dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
                dc.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
                dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                dc.setJavascriptEnabled(true);
                driver = new InternetExplorerDriver();
                break;
            case MODEINTERNETEXPLORER:
                System.setProperty("webdriver.ie.driver", Parameters.get("ie.driver.path"));
                //System.setProperty("webdriver.ie.driver", "C:/SelDrivers/New folder/IEDriverServer.exe");
                //            DesiredCapabilities dcp = new DesiredCapabilities();
            /*    dcp.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
                dcp.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
                dcp.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
                dcp.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                dcp.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                dcp.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                dcp.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
           */
//      dcp.setJavascriptEnabled(true);
            /*    driver = new InternetExplorerDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", Parameters.get("edge.driver.path"));
                //System.setProperty("webdriver.ie.driver", "C:/SelDrivers/New folder/IEDriverServer.exe");
                DesiredCapabilities dc1 = new DesiredCapabilities();
                dc1.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
                dc1.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
                dc1.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
                dc1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                dc1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                dc1.setJavascriptEnabled(true);
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", Parameters.get("chrome.driver.path"));
                //System.setProperty("webdriver.chrome.driver", "C:/SelDrivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}*/

package com.ent.selenium;

import com.ent.config.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(DriverTypes browser) throws MalformedURLException {
        _setDriver(browser);
        return driver;
    }

    private void _setDriver(DriverTypes browser) throws MalformedURLException {
        DesiredCapabilities capabilities =   new DesiredCapabilities();;


        switch (browser) {
            case CHROME: {
                capabilities.setCapability("browserName", "chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("disable-infobars"); // disabling infobars
                options.addArguments("disable-extensions"); // disabling extensions
                options.addArguments("disable-gpu"); // applicable to windows os only
                options.addArguments("disable-dev-shm-usage"); // overcome limited resource problems
                options.addArguments("no-sandbox"); // Bypass OS security model
                System.out.println("I have setCapability for the driver" + browser);
            }
            break;
            case FIREFOX: {
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "firefox");
                System.out.println("I have setCapability for the driver @@@@@@@" + browser);

            }
            break;

            default: {
                System.setProperty("webdriver.chrome.driver", Parameters.get("chrome.driver.path"));
                //System.setProperty("webdriver.chrome.driver", "C:/SelDrivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            break;
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}


