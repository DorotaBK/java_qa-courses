package dbk.qacourse.addressbook.tests;

import dbk.qacourse.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionOnHomeAbortTests extends TestBase {

    @Test
    public void testContactDeletionOnHomeAbort() {
        app.getNavigationHelper().goToHomePage();
        int start = app.getContactHelper().getContactCount();
        System.out.println("number of contacts at the beginning: " + start);

        //checking pre-conditions and providing them if necessary
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Edyta", "Klocek", "klocek",
                    null, "601601601", "eklocek@wp.pl", "[none]"));
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        System.out.println("number of contacts before test: " + before.size());

        int contactToDelete = before.size() - 1;     //the element I want to delete
        app.getContactHelper().selectContactToDelete(contactToDelete);
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
