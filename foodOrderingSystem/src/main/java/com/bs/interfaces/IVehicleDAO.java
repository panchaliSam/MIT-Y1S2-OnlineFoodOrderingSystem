package main.java.com.bs.interfaces;

/**
 *
 * @author Group4 - Chathumi
 */

import java.util.ArrayList;
import main.java.com.bs.model.Vehicle;

public interface IVehicleDAO {
    
        ArrayList<Vehicle>selectAllVehicle(int vehicleId);
    	public Vehicle selectVehicle(int vehicleId);
	public boolean insertVehicle (Vehicle vehicle);
	public boolean updateVehicle (Vehicle vehicle);
	public boolean deleteVehicle (int vehicleId);
    
}