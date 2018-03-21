package dbk.qacourse.addressbook.tests;

import dbk.qacourse.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionOnHomeAbortTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contacts().contactList().size() == 0) {
            app.contacts().create(new ContactData("Edyta", "Klocek", "klocek",
                    null, "601601601", "eklocek@wp.pl", "[none]"));
        }
    }

    @Test
    public void testContactDeletionOnHomeAbort() {
        List<ContactData> before = app.contacts().contactList();
        System.out.println("number of contacts before test: " + before.size());

        int index = before.size() - 1;     //the element I want to delete
        app.contacts().selectContactToDelete(index);
        app.contacts().deleteOnHome();
        app.contacts().isAlertPresent();

        // comparing the size of collections
        List<ContactData> after = app.contacts().contactList();
        Assert.assertEquals(after.size(), before.size() );
        System.out.println("number of contacts at the end: " + after.size());

        // comparing of collections
        Assert.assertEquals(after, before);
    }
}
