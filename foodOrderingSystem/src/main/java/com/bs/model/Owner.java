package main.java.com.bs.model;

/**
 *
 * @author Group4 - Imesh
 */
public class Owner extends Person {

    private int owner_Id;
    private String position;
    private String password;

    public Owner() {

    }

    public Owner(int owner_Id, String firstName, String lastName, String email, String telNo, String position, String password) {
        super(firstName, lastName, email, telNo);
        this.owner_Id = owner_Id;
        this.position = position;
        this.password = password;

    }

    // Getter and Setter for ownerId
    public int getOwner_Id() {
        return owner_Id;
    }

    public void setOwner_Id(int owner_Id) {
        this.owner_Id = owner_Id;
    }

    // Getter and Setter for position
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setFirstName(String firstName) {
        // Add custom logic if needed
        super.setFirstName(firstName); // Call the superclass method if you want to retain its functionality
    }

    @Override
    public String toString() {
        return "Owner{"
                + "ownerId=" + owner_Id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", telNo='" + telNo + '\''
                + ", position='" + position + '\''
                + ", password='" + password + '\''
                + '}';
    }

    @Override
    public void myTask() {
        System.out.println("Owner can see the menu");
    }

}
