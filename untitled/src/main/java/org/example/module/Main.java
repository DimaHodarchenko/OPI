package org.example.module;

import java.util.ArrayList;
import java.util.List;


interface CloneableItem extends Cloneable {
    CloneableItem clone() throws CloneNotSupportedException;
}

class Book implements CloneableItem {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        return new Book(this.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}

class Library {
    private List<CloneableItem> items = new ArrayList<>();

    public void addItem(CloneableItem item) {
        items.add(item);
    }

    public CloneableItem getItem(int index) {
        if (index >= 0 && index < items.size()) {
            CloneableItem item = items.get(index);
            try {
                return item.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book("Design Patterns");
        library.addItem(book);

        CloneableItem clonedBook = library.getItem(0);

        if (clonedBook != null) {
            System.out.println("Original Book: " + book);
            System.out.println("Cloned Book: " + clonedBook);
        }
    }
}
