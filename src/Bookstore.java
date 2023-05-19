import com.books.Book;
import com.membercard.DiscountEligible;
import com.membercard.MembershipCard;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Bookstore {

    public static void main(String[] args) {

        List<Book> bookstore = new ArrayList();
        List<MembershipCard> members = new ArrayList();

//        System.out.println(Book.getId());

        // Books that will be in the inventory when program starts
        bookstore.add(new Book());
        bookstore.add(new Book());
        bookstore.add(new Book("Hello World", "John", "Fantasy", 59.99));

        // Members that are allowed to access the bookstore service if they enter their PIN number
        members.add(new MembershipCard(123456, 1234, "Tom", "08/26"));
        members.add(new MembershipCard(456789, 5678, "Bob", "05/24"));

//        System.out.println(Book.getId());
//        bookstore.forEach(book -> System.out.println(book));

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the bookstore");
        System.out.print("Are you a member? Enter your PIN: ");
        int pin = -1;

        while (pin < 0) {
            try {
                Scanner scan2 = new Scanner(System.in); // Have to use a second Scanner object so there won't be an infinite loop
                pin = scan2.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input is not a number. Try again: ");
            }
            if (pin < 0) System.out.println("Input can't be a negative number. Try again: ");
        }

        boolean checkPIN = false;
        String customer = "";

        // If the input matches a PIN number from the members list than set the check to true
        // Also record the name of the member who's PIN number matches the input
        for (MembershipCard member : members) {
            if (pin == member.getPin()) {
                checkPIN = true;
                customer = member.getCardHolderName();
                break;
            }
        }

        if (checkPIN) { // Customer can only have access to the service if a PIN number is provided
            boolean cycle = true;
            int counter2 = 1;

            while (cycle) { // Cycle through the menu until the customer chooses to exit

                if (counter2 == 1) System.out.println("Hello " + customer + "! Choose an option:");
                else System.out.println("Is there anything else you need " + customer + "? Choose an option:");

                System.out.println("1 - See our list of books \n" +
                        "2 - Buy a book \n" +
                        "3 - Recommend a book to add to our inventory \n" +
                        "4 - Exit");


                // Check the input to make sure it is a number
                int input = 0;
                Scanner scan3 = new Scanner(System.in);

                try {
                    input = scan3.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please provide a number that matches the options");
                }

                switch (input) { //
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

                        if (purchasedBook) {
                            bookstore.remove(counter);

                            System.out.println("Remaining books in the bookstore: ");
                            bookstore.forEach(System.out::println);
                        } else
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
                    default ->
                            System.out.println("Sorry. The input you provided cannot be matched to an option. Try again");
                }

                counter2++;
            }

        } else System.out.println("Sorry. You need to be a member.");

    }

}
