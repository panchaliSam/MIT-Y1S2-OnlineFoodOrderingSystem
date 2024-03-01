package main.java.com.bs.model;

/**
 *
 * @author Group4 - Nisala
 */

public class DeliveryPerson extends Person {
    
    private int DeliveryPersonId;
    private boolean isActive;
    


    //Default Constructor
    public DeliveryPerson (int returnDeliveryPersonId, String firstName1, String lastName1, String email1, String telNo1, boolean active, String activeStatus) {

    }

    //Parametric Constructor
    public DeliveryPerson(int DeliveryPersonId, String firstName, String lastName, String email, String telNo, boolean isActive){
        super(firstName, lastName, email, telNo);
        this.DeliveryPersonId = DeliveryPersonId;
        this.isActive = isActive;
    
    }

    public DeliveryPerson() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public void setIsActiveStatus(String activeStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIsActive(boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void add(DeliveryPerson deliveryperson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}