package lms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lms.model.Book;
import lms.model.Member;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        members.add(member);
    }

    public void listBooks() {
        System.out.println("--- Books in the library ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listMembers() {
        System.out.println("--- Registered members ---");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }
}
