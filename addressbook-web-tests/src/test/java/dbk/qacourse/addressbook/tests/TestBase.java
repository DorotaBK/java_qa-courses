package dbk.qacourse.addressbook.tests;

import dbk.qacourse.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

 public class TestBase {

     protected final ApplicationManager app = new ApplicationManager();

     @BeforeMethod
    public void setUp() throws Exception {
        app.init(); // method from ApplicationManager class
    }

     @AfterMethod
    public void tearDown() {
        app.stop(); // method from ApplicationManager class
    }

 }
