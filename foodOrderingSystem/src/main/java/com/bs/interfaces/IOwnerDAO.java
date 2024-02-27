package main.java.com.bs.interfaces;

/**
 *
 * @author Group4 - Imesh
 */
import java.util.ArrayList;
import main.java.com.bs.model.Owner;

public interface IOwnerDAO {

    ArrayList<Owner> selectAllOwner(int owner_Id);

    ArrayList<Owner> selectOwner(int owner_Id);

    public boolean insertOwner(Owner owner);

    public boolean updateOwner(Owner owner);

    public boolean deleteOwner(int owner_Id);

}
