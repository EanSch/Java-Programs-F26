package Assignments.Assignment7;

/* A Book object represents one title in a library catalog: how many copies the library owns and how
   many of those copies are checked out right now.

   TODO: rename this file and class (to Book), then replace this comment with your own header
   describing the purpose of the class and the techniques you applied from Lecture 8.

   Write this class first. The client program (LibraryMain) cannot compile until the constructor and
   the methods described below exist, and they must have exactly these names.
   Class invariant: 0 <= checkedOut <= totalCopies. */

public class Book {

    // TODO 1: Fields (reference lecture 8, section 8.4).
    // Declare three private fields: the title (a String), the number of copies the library owns
    // (an int), and the number of those copies that are checked out (an int).
    // Do not store the number of available copies. It can always be computed from the other two
    // values, so a stored value could become out of date.

    private String title;
    private int totalCopies;
    private int checkedOut;


    // TODO 2: Constructor (reference lecture 8, sections 8.3 and 8.4).
    // Header:  public Book(String title, int totalCopies, int checkedOut)
    // The constructor runs each time the client writes new Book(title, totalCopies, checkedOut), once
    // for every row of the file. Store the three values in the fields (use this.title and so on,
    // because the parameters have the same names as the fields).
    // Protect the class invariant: throw a NullPointerException if the title is null, and an
    // IllegalArgumentException if checkedOut is negative or larger than totalCopies. A bad row in
    // the file should never become a Book object.

    public Book(String title, int totalCopies, int checkedOut) {
        if (title == null) {
            throw new NullPointerException("Title cannot be null");
        }
        if (checkedOut < 0 || checkedOut > totalCopies) {
            throw new IllegalArgumentException("Checked out copies must be between 0 and total copies");
        }
        this.title = title;
        this.totalCopies = totalCopies;
        this.checkedOut = checkedOut;
    }

    // TODO 3: Accessors (reference lecture 8, section 8.2).
    // Header:  public String getTitle()
    // Returns the title of the book.
    //
    // Header:  public int getAvailable()
    // Returns the number of copies on the shelf that can be checked out: the total copies minus the
    // checked-out copies. Return the answer; do not print it.

    public String getTitle() {
        return title;
    }

    public int getAvailable() {
        return totalCopies - checkedOut;
    }

    // TODO 4: toString (reference lecture 8, section 8.2).
    // Header:  public String toString()
    // Returns one line of text that describes the book, for example:
    //     Clean Code: 0 of 3 copies available
    // Return the text; do not print it. Java calls toString automatically when a Book is printed
    // or joined to a String.

    public String toString() {
        return title + ": " + getAvailable() + " of " + totalCopies + " copies available";
    }

}
