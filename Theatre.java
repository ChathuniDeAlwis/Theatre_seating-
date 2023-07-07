import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Theatre {
    static Scanner input = new Scanner(System.in);
    static int[] arr1 = new int[12]; //number of seats in first row
    static int[] arr2 = new int[16]; //number of seats in second row
    static int[] arr3 = new int[20]; //number of seats in third row
    static int count=0;
    static double totalPrice=0;

    public static void main(String[] args) {
         final ArrayList <Ticket> ticket_last= new ArrayList<>(); //creating arraylist

        System.out.println("Welcome to the New Theatre"); //At the start of the program all seats = 0 (free)
        for (int i = 0; i < 12; i++) {
            arr1[i] = 0;
        }
        for (int i = 0; i < 16; i++) {
            arr2[i] = 0;
        }
        for (int i = 0; i < 20; i++) {
            arr3[i] = 0;
        }
        display(ticket_last);
    }
    public static void display(ArrayList<Ticket> ticket_last) { //get all options into one method
        System.out.println("   *-* M E N U *-*");
        System.out.println("Please select an option : ");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("    0) Quit");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter Option : ");
        try {
            int option = input.nextInt();
            switch (option) {  //use switch statement to access each method
                case 1 -> {
                    System.out.println("1) Buy a ticket");
                    buy_ticket(ticket_last);
                }
                case 2 -> {
                    System.out.println("2) Print seating area");
                    print_seating_area(ticket_last);
                }
                case 3 -> {
                    System.out.println("3) Cancel ticket");
                    cancel_ticket(ticket_last);
                }
                case 4 -> {

                    System.out.println("4) List available seats");
                    show_available(ticket_last);
                }
                case 5 -> {
                    System.out.println("5) Save to file");
                    save(ticket_last);
                }
                case 6 -> {
                    System.out.println("6) Load from file");
                    load(ticket_last);
                }
                case 7 -> {
                    System.out.println("7) Print ticket information and total price");
                    show_tickets_info(ticket_last);
                }

                case 8 -> {
                    System.out.println("8) Sort tickets by price");
                    sort_tickets(ticket_last);
                }

                case 0 -> {
                    System.out.println("    0) Quit");
                    System.out.println("program will end");
                    System.exit(0);
                }
                default -> System.out.println("out of range");
            }
            display(ticket_last);
        } catch (Exception e) {
            System.out.println("enter an integer value please...");
            input.nextLine(); //fixes integer input by consuming newline character.
            display(ticket_last);
        }
    }
    public static void buy_ticket(ArrayList<Ticket> ticket_last) {
        try {
            System.out.print("Enter row number (1/2/3): "); //get row number
            int row = input.nextInt();
            System.out.print("Enter seat number: "); //get seat number
            int seat = input.nextInt();
            if (row == 1) {
                if (seat >= 1 && seat <= 12 && arr1[seat - 1] == 0) {
                    arr1[seat - 1] = 1; //place the ticket
                    System.out.println("your seat is booked");
                    count += 1;
                    System.out.println();
                } else {
                    System.out.println("already purchased or out of range...");
                    print_seating_area(ticket_last);
                    buy_ticket(ticket_last);
                }
            } else if (row == 2) {
                if (seat >= 1 && seat <= 16 && arr2[seat - 1] == 0) {
                    arr2[seat - 1] = 1; //place the ticket
                    System.out.println("your seat is booked");
                    count += 1;
                    System.out.println();
                } else {
                    System.out.println("already purchased or out of range...");
                    print_seating_area(ticket_last);
                    buy_ticket(ticket_last);
                }
            } else if (row == 3) {
                if (seat >= 1 && seat <= 20 && arr3[seat - 1] == 0) {
                    arr3[seat - 1] = 1;  //place the ticket
                    System.out.println("your seat is booked");
                    count += 1;
                    System.out.println();
                } else {
                    System.out.println("already purchased or out of range...");
                    print_seating_area(ticket_last);
                    buy_ticket(ticket_last);
                }
            } else {
                System.out.println("Error:This row number does not exist.Please select 1-3");
                buy_ticket(ticket_last);
            }

            String name, surname, email;
            double price = 0;
            System.out.print("enter your name : ");
            while (!input.hasNext("[A-Za-z]+")) { // validate input to only allow alphabetical characters
                System.out.print("Please enter a valid name (letters only): ");
                input.next();
            }
            name = input.next();

            System.out.print("enter your surname : ");
            while (!input.hasNext("[A-Za-z]+")) { // validate input to only allow alphabetical characters
                System.out.print("Please enter a valid surname (letters only): ");
                input.next();
            }
            surname = input.next();

            System.out.print("enter your email : ");
            while (!input.hasNext("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) { // validate input to match email format
                System.out.print("Please enter a valid email address: ");
                input.next();
            }
            email = input.next();

            System.out.println("PRICES :- full (f) = 100$   half (h)  = 50$");
            System.out.print("  what will be ur choice ( f or h ) :  ");
            String choice = input.next();

            if (Objects.equals(choice, "f")) {
                price=100;

            }else if (Objects.equals(choice, "h")) {
                price=50;

            } else {
                System.out.println("wrong choice...");
                buy_ticket(ticket_last);
            }
            ticket_last.add(new Ticket(row, seat, price, new Person(name, surname, email))); //Adding a new ticket to the ArrayList with the row, seat, price, and customer information.
            totalPrice+=price; //get the total price of the user
            System.out.println();
            System.out.println();
            display(ticket_last);
        } catch (Exception e) {
            System.out.println("enter an integer please");
            input.nextLine(); // clear input buffer
            buy_ticket(ticket_last);
        }
    }
    public static void print_seating_area(ArrayList<Ticket> ticket_last) {
        System.out.println("    *********** \n    *  STAGE  *\n    ***********  ");

        for (int i = 0; i < arr1.length; i++) {
            if(i == 0) {
                System.out.print("    ");
            }

            if (arr1[i] == 1) {
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }

            if(i==5){ //make the middle space
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            // Print one space at the beginning of the array
            if(i == 0) {
                System.out.print("  ");
            }

            if (arr2[i] == 1) {
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }

            if(i==7){
                System.out.print(" "); //make the middle space
            }
        }
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] == 1) {
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }
            if(i==9){
                System.out.print(" "); //make the middle space
            }
        }
        System.out.println();
        display(ticket_last);
    }
    public static void cancel_ticket(ArrayList<Ticket> ticket_last) {
        try{
            System.out.print("Enter row number (1/2/3): "); //get the row number
            int row1 = input.nextInt();
            System.out.print("Enter seat number: "); //get the seat number
            int seat1 = input.nextInt();
            if (row1 == 1) {
                if (seat1 > 0 && seat1 <= 12 && arr1[seat1 - 1] == 1) {
                    for(Ticket i:ticket_last){
                        if (i.getRow() ==row1 && i.getSeat()==seat1 ){
                            ticket_last.remove(i); //remove from arraylist
                            break;
                        }
                    }
                    System.out.println("seat will cancel");
                    arr1[seat1 - 1] = 0; //make (0)-free the seat
                    System.out.println();
                    print_seating_area(ticket_last);
                    System.out.println();
                    display(ticket_last);
                }
                else {
                    System.out.println("Wrong SEAT number");
                    cancel_ticket(ticket_last);
                }
            }

            else if (row1 == 2) {
                if (seat1 > 0 && seat1 <= 16 && arr2[seat1 - 1] == 1) {
                    for(Ticket i:ticket_last){
                        if (i.getRow() ==row1 && i.getSeat()==seat1 ){
                            ticket_last.remove(i); //remove from arraylist
                            break;
                        }
                    }
                    System.out.println("seat will cancel");
                    arr2[seat1 - 1] = 0; //make (0)-free the seat
                    System.out.println();
                    print_seating_area(ticket_last);
                    System.out.println();
                    display(ticket_last);
                }
                else {
                    System.out.println("Wrong SEAT number");
                    cancel_ticket(ticket_last);
                }
            }
            else if (row1 == 3) {
                if (seat1 > 0 && seat1 <= 20 && arr3[seat1 - 1] == 1) {
                    for(Ticket i:ticket_last){
                        if (i.getRow() ==row1 && i.getSeat()==seat1 ){
                            ticket_last.remove(i); //remove from arraylist
                            break;
                        }
                    }
                    System.out.println("seat will cancel");
                    arr3[seat1 - 1] = 0; //make (0)-free the seat
                    System.out.println();
                    print_seating_area(ticket_last);
                    System.out.println();
                    display(ticket_last);
                }
                else {
                    System.out.println("Wrong SEAT number");
                    cancel_ticket(ticket_last);
                }
            }
            else {
                System.out.println("enter correct row");
            }
        }
        catch (Exception e) {
            System.out.println("Value is invalid...re-enter an integer");
            input.nextLine();
            cancel_ticket(ticket_last);
        }
    }
    public static void show_available(ArrayList<Ticket> ticket_last) { // Display available seats with the character 'O' and the sold seats with 'X'
        System.out.print("Seats available in row 1:");
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==0){
                System.out.print((i+1)+", "); //(index+1) == seat number
            }
        }
        System.out.print(".");
        System.out.println();
        System.out.print("Seats available in row 2:");
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]==0){
                System.out.print((i+1)+", "); //(index+1) == seat number
            }
        }
        System.out.print(".");
        System.out.println();
        System.out.print("Seats available in row 3:");
        for(int i=0;i<arr3.length;i++){
            if(arr3[i]==0){
                System.out.print((i+1)+", "); //(index+1) == seat number
            }
        }
        System.out.print(".");
        System.out.println();
        display(ticket_last);
    }
    public static void save(ArrayList<Ticket> ticket_last) throws IOException {
        BufferedWriter outfile = new BufferedWriter(new FileWriter("myFile.txt")); //creating the file
        for (int i : arr1) {
            outfile.write(i+""); //write the values to the file
        }
        outfile.newLine();
        for (int i : arr2) {
            outfile.write(i+""); //write the values to the file
        }
        outfile.newLine();
        for (int i : arr3) {
            outfile.write(i+""); //write the values to the file
        }
        outfile.newLine();
        outfile.close(); //releases resources and terminates the file stream
        display(ticket_last);
    }
    public static void load(ArrayList<Ticket> ticket_last) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("myFile.txt")); //read data in file
            System.out.println("Your data will load from 'myFile.txt'");
            String data = reader.readLine(); //stores the first line of myFile.txt with arr1 values
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(String.valueOf(data.charAt(i))); //converts data characters to integers and saves them in arr1
            }
            data = reader.readLine(); //stores the first line of myFile.txt with arr2 value
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(String.valueOf(data.charAt(i))); //converts data characters to integers and saves them in arr2
            }
            data = reader.readLine(); //stores the first line of myFile.txt with arr3 values
            for (int i = 0; i < arr3.length; i++) {
                arr3[i] = Integer.parseInt(String.valueOf(data.charAt(i))); //converts data characters to integers and saves them in arr3
            }
            reader.close(); //closes the BufferedReader object after file reading
        } catch (Exception e) {
            System.out.println("not found");
        }
        display(ticket_last);
    }
    public static void show_tickets_info(ArrayList<Ticket> ticket_last) {
        int sum = 0;
        for (Ticket value : ticket_last) {
            Ticket ticket = new Ticket(); //creates a new Ticket object for displaying the details of each Ticket in ticket_last using the print() method
            ticket.print(value); //print the details of a Ticket object using the print() method of the Ticket class
            System.out.println();
            sum += value.getPrice(); //accumulate the total price of all tickets in the ticket_last list
        }
        System.out.println("Total Price: " + sum + "$");
        System.out.println();
        System.out.println();
        display(ticket_last);
    }
    public static void sort_tickets(ArrayList<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) { // checks if the input tickets list is null or empty, prints a message and returns if it is
            System.out.println("empty list.");
            return;
        }
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets); // make a copy of the input list
        int n = sortedTickets.size();
        Ticket temp; // temporarily hold a Ticket object during the swapping process
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(sortedTickets.get(j).getPrice() > sortedTickets.get(j+1).getPrice()){ // swap sortedTickets[j] and sortedTickets[j+1]
                    temp = sortedTickets.get(j); //assigns the value of sortedTickets.get(j) to the temporary variable temp
                    sortedTickets.set(j, sortedTickets.get(j+1)); //used to swap the values at indices j and j+1 in the sortedTickets ArrayList
                    sortedTickets.set(j+1, temp); //swaps the elements at indices j and j+1 in the sortedTickets ArrayList.
                }
            }
        }
        System.out.println("Half ticket - 50$    Full ticket - 100$");
        for (Ticket ticket : sortedTickets) { //iterate over the elements of the sortedTickets ArrayList
            System.out.println("Name: " + ticket.getPerson().getName() + " - Surname: " + ticket.getPerson().getSurname() + " - Email: " + ticket.getPerson().getEmail()+" - Price: " + ticket.getPrice() );
        }
        System.out.println();
        System.out.println();
    }
}


/*---references---
https://www.w3schools.com/
https://stackoverflow.com/
https://www.geeksforgeeks.org/
https://www.javatpoint.com/ */



