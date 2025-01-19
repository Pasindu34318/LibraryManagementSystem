import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nList of Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.print("Enter new Title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new Author: ");
                String newAuthor = scanner.nextLine();

                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
}