import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalogSystem {

    // Book class to store book details
    static class Book {
        private String title;
        private String author;
        private String isbn;
  
        // Constructor
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        // To String method to display the book details
        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
        }
    }

    // Library class to handle operations (adding, searching, listing books)
    static class Library {
        private List<Book> books;

        // Constructor
        public Library() {
            books = new ArrayList<>();
        }

        // Method to add a book
        public void addBook(Book book) {
            books.add(book);
        }

        // Method to search for books by title
        public List<Book> searchByTitle(String title) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    result.add(book);
                }
            }
            return result;
        }

        // Method to search for books by author
        public List<Book> searchByAuthor(String author) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    result.add(book);
                }
            }
            return result;
        }

        // Method to list all books
        public List<Book> listAllBooks() {
            return books;
        }
    }

    // Main method - User Interface and interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add a Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            boolean validChoice = false;

            // Loop to ensure valid input for menu choice
            while (!validChoice) {
                try {
                    choice = scanner.nextInt();  // Read user choice
                    scanner.nextLine();  // Clear the buffer (consuming newline)
                    validChoice = true;  // Exit the loop if valid input is provided
                } catch (Exception e) {
                    scanner.nextLine();  // Consume the invalid input
                    System.out.println("Invalid choice. Please enter a valid integer (1-5).");
                }
            }

            switch (choice) {
                case 1:
                    // Add a Book
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the ISBN of the book: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    // Search by Title
                    System.out.print("Enter the title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> foundByTitle = library.searchByTitle(searchTitle);
                    if (foundByTitle.isEmpty()) {
                        System.out.println("No books found with the title: " + searchTitle);
                    } else {
                        System.out.println("Books found:");
                        for (Book b : foundByTitle) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    // Search by Author
                    System.out.print("Enter the author to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> foundByAuthor = library.searchByAuthor(searchAuthor);
                    if (foundByAuthor.isEmpty()) {
                        System.out.println("No books found by author: " + searchAuthor);
                    } else {
                        System.out.println("Books found:");
                        for (Book b : foundByAuthor) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 4:
                    // List all Books
                    List<Book> allBooks = library.listAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("No books available in the catalog.");
                    } else {
                        System.out.println("List of all books:");
                        for (Book b : allBooks) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the Library Catalog System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
