package fr.ubordeaux.ao;

import java.util.Set;
import java.util.HashSet;


public class SearchEngine {
    public Set<Contact> searchByName(String name, ContactSet contactSet) {
        Set<Contact> results = new HashSet<Contact>();
        final int STEP = 100;
        int start = 0;
        boolean hasMore = true;
        while (hasMore) {
            Set<Contact> contacts = contactSet.getContactSet(start, start+STEP);
            if (contacts.size()==0) {
                hasMore = false;
            } else {
                start = start + STEP;
                for (Contact contact : contacts) {
                    boolean filterIn = filterByName(contact, name);
                    if (filterIn) {
                        results.add(contact);
                    }
                }
            }
        }
        return results;
    }

    public boolean filterByName(Contact contact, String name) {
        boolean firstName = contact.getFirstName().startsWith(name);
        boolean secondName = contact.getSecondName().startsWith(name);
        return firstName || secondName;
    }
}