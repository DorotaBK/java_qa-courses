package dbk.qacourse.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

    //copy of an existing object
    private Set<ContactData> delegate;

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    //constructors
    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactData>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactData>();
    }

    // new objects
    public Contacts withAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);   //create a copy of an existing collection
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(ContactData contact) {
        Contacts contacts = new Contacts(this);   //create a copy of an existing collection
        contacts.remove(contact);
        return contacts;
    }
}