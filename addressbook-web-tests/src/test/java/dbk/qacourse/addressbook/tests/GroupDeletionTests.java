package dbk.qacourse.addressbook.tests;

import dbk.qacourse.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        int start = app.getGroupHelper().getGroupCount();
        System.out.println("number of groups at the beginning: " + start);

        //checking pre-conditions and providing them if necessary
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("nowa6!", null, null));
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();
        System.out.println("number of groups before test: " + before.size());

        int groupToDelete = before.size() - 1;       //the element I want to delete
        app.getGroupHelper().selectGroup(groupToDelete);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();

        // comparing the size of collections
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1 );
        System.out.println("number of groups at the end: " + after.size());

        // comparing of whole collections (requires conversion of the list into a set)
        before.remove(groupToDelete);
        Assert.assertEquals(after, before);

    }
}
