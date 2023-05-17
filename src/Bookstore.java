import com.books.Book;
import com.membercard.DiscountEligible;
import com.membercard.MembershipCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Bookstore {

    public static void main(String[] args) {

        List<Book> bookstore = new ArrayList();
        List<MembershipCard> members = new ArrayList();

//        System.out.println(Book.getId());

        bookstore.add(new Book());
        bookstore.add(new Book());
        bookstore.add(new Book("Hello World", "John", "Fantasy", 59.99));

        members.add(new MembershipCard(123456, 1234, "Tom", "08/26"));
        members.add(new MembershipCard(456789, 5678,"Bob", "05/24"));

//        System.out.println(Book.getId());
//        bookstore.forEach(book -> System.out.println(book));

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the bookstore");
        System.out.print("Are you a member? Enter your PIN: ");
        int pin = scan.nextInt();

        boolean checkPIN = false;
        String customer = "";

        for (MembershipCard member : members) {
            if (pin == member.getPin()) {
                checkPIN = true;
                customer = member.getCardHolderName();
                break;
            }
        }

        if (checkPIN) {
            System.out.println("Hello " + customer + "! Choose an option: \n"+
                                "1 - See our list of books \n" +
                                "2 - Buy a book \n" +
                                "3 - Recommend a book to add to our inventory \n" +
                                "4 - Exit");

            int input = scan.nextInt();
            scan.nextLine();

            switch (input) {
                case 1 -> bookstore.forEach(book -> System.out.println(book));
                case 2 -> {
                    System.out.print("Enter the title of the book you want to purchase: ");
                    String title = scan.nextLine();
                    int counter = 0;
                    boolean purchasedBook = false;

                    for (Book book : bookstore) {
                        if (book.getTitle().equals(title)) {
                            String discount = DiscountEligible.discount(book.getPrice()) ? "qualifies" : "doesn't qualify";
                            System.out.println("This book " + discount + " for a 10% discount");
                            System.out.println("The book \"" + book.getTitle() + "\" has been purchased. Thank you for shopping.");

                            purchasedBook = true;
                            break;
                        }
                        counter++;
                    }

                    if (purchasedBook)
                        bookstore.remove(counter);
                    else
                        System.out.println("Sorry, no book has been found with that title.");
                }
                case 3 -> {
                    System.out.println("What book would you like to recommend for us to add? Enter title," +
                                        "author, genre, and the price in different lines: ");

                    String title = scan.nextLine();
                    String author = scan.nextLine();
                    String genre = scan.nextLine();
                    double price = scan.nextDouble();

                    bookstore.add(new Book(title, author, genre, price));
                    System.out.println("Thank you for your recommendation. We added the book to our inventory. Here is the list: ");
                    bookstore.forEach(book -> System.out.println(book));
                }
                case 4 -> System.exit(0);
            }

        } else System.out.println("Sorry. You need to be a member.");

//        System.out.println("Remaining books in the bookstore: ");
//        bookstore.forEach(book -> System.out.println(book));
    }

}
