package main.java.com.bs.interfaces;

/**
 *
 * @author Group4 - Nisala
 */

import java.util.ArrayList;
import main.java.com.bs.model.DeliveryPerson;

public interface IDeliveryPersonDAO {
    
        ArrayList<DeliveryPerson>selectAllDeliveryPerson(int deliverypersonId);
    	ArrayList<DeliveryPerson>selectDeliveryPerson(int deliverypersonId);
	public boolean insertDeliveryPerson (DeliveryPerson deliveryperson);
	public boolean updateDeliveryPerson (DeliveryPerson deliveryperson);
	public boolean deleteDeliveryPerson (int deliverypersonId);
    
}
