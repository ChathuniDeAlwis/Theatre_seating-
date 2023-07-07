public class Person { //declaring variables
    private String name;
    private String surname;
    private String email;
    public Person(String name, String surname, String email) { //parameterized constructor.Constructor sets Person class's private variables with object creation arguments.
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public  String getName(){
        return name;
    } //gets the value of name in the Person class
    public void setName(String name){this.name =name;} //sets the name variable value of a Person object
    public  String getSurname(){
        return surname;
    } //gets the value of surname in the Person class
    public void setSurname(String surname){this.surname =surname;} //sets the surname variable value of a Person object
    public  String getEmail(){
        return email;
    } //gets the value of email in the Person class
    public void setEmail(String email){this.email =email;} //sets the email variable value of a Person object
}
