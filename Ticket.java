public class Ticket { //declaring variables
    private int row;
    private int seat;
    private double price;
    Person person1;

    public Ticket(){
        //used to create objects of the Ticket class without initializing any of its fields
    }
    public Ticket(int row,int seat,double price,Person person){ //The constructor method with parameters initializes the Ticket object's instance variables with the given values
        this.row =row;
        this.seat =seat;
        this.price =price;
        this.person1=person;
    }

    public int getRow() {
        return row;
    } //The method "getRow()" in the "Ticket" class returns the value of the private variable "row".

    public int getSeat() {
        return seat;
    } //The method "getSeat()" in the "Ticket" class returns the value of the private variable "seat".
    public double getPrice() {
        return price;
    }//The method "getPrice()" in the "Ticket" class returns the value of the private variable "price".
    public Person getPerson() {
        return person1;
    } //The method getPerson() in the Ticket class returns the Person object associated with the ticket.
    public void print(Ticket ticket_obj) {
        System.out.print("Name : " + ticket_obj.getPerson().getName()+"    ");
        System.out.print("Surname : " + ticket_obj.getPerson().getSurname()+"    ");
        System.out.print("Email:  " + ticket_obj.getPerson().getEmail()+"    ");
        System.out.print("Row : " + ticket_obj.getRow() + "    ");
        System.out.print("Seat : " + ticket_obj.getSeat() + "    ");
        System.out.print("Price : " + ticket_obj.getPrice() + "$    ");
    }


}




