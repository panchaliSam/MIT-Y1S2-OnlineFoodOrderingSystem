
package main.java.com.bs.model;

/**
 *
 * @author Group4 - Chathumi
 */
public class Vehicle {
     //Attributes of Vehicle class
    private int delpID;
    private int vehicleId;
    private String type;
    private String registrationNumber;
    private String model;
    private boolean isActive;

    
    // Default constructor
    public Vehicle() {
    }

    // parameteric constructor
    public Vehicle(int vehicleId,int delpID,String type, String registrationNumber,String model,boolean isActive) {
        
        this.vehicleId = vehicleId;
        this.delpID=delpID;
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.isActive = isActive;
        
    }


    // Getter and Setter for vehicleId
    public int getvehicleId() {
        return vehicleId;
    }

    public void setvehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
     public int getdelpID() {
        return delpID;
    }

   public void setdelpID(int delpID) {
        this.delpID = delpID;
    }

    // Getter and Setter for type
    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    // Getter and Setter for regnumber
    public String getregistrationNumber() {
        return registrationNumber;
    }
    public void setregistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
     public String getmodel() {
        return model;
    }
    public void setmodel(String model) {
        this.model = model;
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
        return "vehicletest{" +
            "vehicleId=" + vehicleId +
            "delpID=" + delpID +    
            ", type='" + type + '\'' +
            ", registrationNumber='" + registrationNumber + '\'' +
            ", model='" + model + '\'' +
            ", isActive=" + isActive +
            
            '}';
    }

    
}


