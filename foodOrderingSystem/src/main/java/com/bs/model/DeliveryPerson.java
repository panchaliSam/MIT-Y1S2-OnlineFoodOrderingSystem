package main.java.com.bs.model;

/**
 *
 * @author Group4 - Nisala
 */

public class DeliveryPerson extends Person {
    
    private int DeliveryPersonId;
    private boolean isActive;
    


    //Default Constructor
    public DeliveryPerson () {

    }

    //Parametric Constructor
    public DeliveryPerson(int DeliveryPersonId, String firstName, String lastName, String email, String telNo, boolean isActive){
        super(firstName, lastName, email, telNo);
        this.DeliveryPersonId = DeliveryPersonId;
        this.isActive = isActive;
    
    }

    // Getter and Setter for DeliveryPersonID
    public int getDeliveryPersonId() {
        return DeliveryPersonId;
    }

    public void setDeliveryPersonId(int DeliveryPersonId) {
        this.DeliveryPersonId = DeliveryPersonId;
    }
    
    // Getter and Setter for isActive
    public boolean getisActive() {
        return isActive;
    }
    
    public void setisActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "DeliveryPersonId=" + DeliveryPersonId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telNo='" + telNo + '\'' +
                ", isActive=" + isActive +
                
                '}';
    }
    
    @Override
    public void myTask() {
        System.out.println("Delivery Person can select a vehicle and deliver the order.");
    }
}