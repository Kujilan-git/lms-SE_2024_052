package lms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Member;

public class Library {
    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    // Overloads: the compiler picks one from the DECLARED type (static binding).
    public void addItem(LibraryItem item) {
        System.out.println("Added via addItem(LibraryItem): " + item.getTitle());
        store(item);
    }

    public void addItem(Book book) {
        System.out.println("Added via addItem(Book): " + book.getTitle());
        store(book);
    }

    public void addItem(DVD dvd) {
        System.out.println("Added via addItem(DVD): " + dvd.getTitle());
        store(dvd);
    }

    // Shared by all overloads so each one prints exactly once.
    private void store(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        members.add(member);
    }

    public void listItems() {
        System.out.println("--- Items in the library ---");
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void listMembers() {
        System.out.println("--- Registered members ---");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // One loop, no if/instanceof: the JVM picks the fee rule (dynamic binding).
    public void printAllLateFees(int daysLate) {
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateLateFee(daysLate));
        }
    }

    public void streamIfPossible(LibraryItem item) {
        if (item instanceof DVD dvd) {
            System.out.println("Streaming \"" + dvd.getTitle() + "\" ("
                    + dvd.getDurationMinutes() + " min)...");
        } else {
            System.out.println(item.getTitle() + " cannot be streamed - it isn't a DVD.");
        }
    }

    public List<LibraryItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }
}