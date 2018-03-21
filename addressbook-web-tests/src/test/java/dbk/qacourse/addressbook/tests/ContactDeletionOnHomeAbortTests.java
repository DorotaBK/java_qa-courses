package dbk.qacourse.addressbook.tests;

import dbk.qacourse.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionOnHomeAbortTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Edyta", "Klocek", "klocek",
                    null, "601601601", "eklocek@wp.pl", "[none]"));
        }
    }

    @Test
    public void testContactDeletionOnHomeAbort() {
        List<ContactData> before = app.getContactHelper().getContactList();
        System.out.println("number of contacts before test: " + before.size());

        int index = before.size() - 1;     //the element I want to delete
        app.getContactHelper().selectContactToDelete(index);
        app.getContactHelper().deleteOnHome();
        app.getContactHelper().isAlertPresent();

        // comparing the size of collections
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() );
        System.out.println("number of contacts at the end: " + after.size());

        // comparing of collections
        Assert.assertEquals(after, before);
    }
}
