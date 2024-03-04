package main.java.com.bs.model;

/**
 *
 * @author Group4 - chathumi
 */

public class Chef extends Person {

    private int chefId;
    private String specialiation;
    private String shift;
    private boolean isActive;
    

    // Default constructor
    public Chef() {
    }

    // Parametric constructor
    public Chef(int chefId,String firstName, String lastName,String email, String telNo,String specialiation, String shift, boolean isActive) {
        super(firstName, lastName, email, telNo);
        this.chefId = chefId;
        this.specialiation = specialiation;
        this.shift = shift;
        this.isActive = isActive;
        }

    
    // Getter and Setter for chefId
    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    // Getter and Setter for specialiation
    public String getspecialiation() {
        return specialiation;
    }

    public void setspecialiation(String specialiation) {
        this.specialiation = specialiation;
    }

    // Getter and Setter for shift
    public String getshift() {
        return shift;
    }

    public void setshift(String shift) {
        this.shift = shift;
    }

    // Getter and Setter for isActive
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    @Override
    public String toString() {
        return "Chef{" +
            "chefId=" + chefId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", telNo='" + telNo + '\'' +
            ", specialiation='" + specialiation + '\'' +
            ", shift='" + shift + '\'' +
            ", isActive=" + isActive +
             '}';
    }

    @Override
    public void myTask() {
        System.out.println("The chef is responsible for preparing dishes according to the menu provided by the customer.");
    }
    
}