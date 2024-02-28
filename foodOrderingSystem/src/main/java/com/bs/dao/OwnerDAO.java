package main.java.com.bs.dao;

/**
 *
 * @author CYBORG
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IOwnerDAO;
import main.java.com.bs.model.Owner;
import main.java.com.bs.utility.DBConnectionPanchali;

public class OwnerDAO implements IOwnerDAO {

    private static final String SELECT_ALL_OWNERS = "SELECT owner_id ,first_name ,last_name ,email,tel_no,position,password,is_active"
            + "FROM owner";

    private static final String SELECT_OWNER_BY_ID = "SELECT owner_id ,first_name ,last_name ,email,tel_no,position,password,is_active"
            + "FROM owner"
            + "WHERE owner_id = ?";

    private static final String INSERT_OWNER = "INSERT INTO owner(first_name ,last_name ,email,tel_no,position,password)"
            + "VALUES(?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_OWNER = "UPDATE owner SET first_name = ?, last_name = ?, email = ?, tel_no = ?, position = ?, password = ? WHERE owner_id = ?";

    private static final String DELETE_OWNER = "DELETE FROM owner WHERE owner_id = ?";

    @Override
    public ArrayList<Owner> selectAllOwner(int owner_Id) {
        //Cretaing owner arraylist
        ArrayList<Owner> owners = new ArrayList<>();

        try {
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_OWNERS);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int returnOwnerId = rs.getInt("owner_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String position = rs.getString("position");
                String password = rs.getString("password");

                Owner owner = new Owner(returnOwnerId, firstName, lastName, email, telNo, position, password);

                owners.add(owner);

                //Polymorphism for owner myTask();
                owner.myTask();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return owners;

    }

    @Override
    public ArrayList<Owner> selectOwner(int owner_Id) {

        //Cretaing customer arraylist
        ArrayList<Owner> owners = new ArrayList<>();

        try {
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_OWNER_BY_ID);
            stmt.setInt(1, owner_Id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int returnOwnerId = rs.getInt("owner_Id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String position = rs.getString("position");
                String password = rs.getString("password");

                //Owner owner = new Owner(return OwnerId, firstName, lastName, email, telNo, position, password);
                Owner owner = new Owner();

                owner.setOwner_Id(returnOwnerId);
                owner.setFirstName(firstName);
                owner.setLastName(lastName);
                owner.setEmail(email);
                owner.setTelNo(telNo);
                owner.setPosition(position);
                owner.setPassword(password);

                owners.add(owner);

                //Polymorphism for owner myTask();
                owner.myTask();

                System.out.println("\nSelected Owner: " + owner.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return owners;

    }

    @Override
    public boolean insertOwner(Owner owner) {

        System.out.println(INSERT_OWNER);
        boolean rowInserted = false;

        try {

            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_OWNER);

            stmt.setString(1, owner.getFirstName());
            stmt.setString(2, owner.getLastName());
            stmt.setString(3, owner.getEmail());
            stmt.setString(4, owner.getTelNo());
            stmt.setString(5, owner.getPosition());
            stmt.setString(6, owner.getPassword());

            stmt.executeUpdate();

            //Polymorphism for owner myTask();
            owner.myTask();

            rowInserted = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    @Override
    public boolean updateOwner(Owner owner) {

        System.out.println(UPDATE_OWNER);
        boolean rowUpdate = false;

        try {

            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_OWNER);

            stmt.setString(1, owner.getFirstName());
            stmt.setString(2, owner.getLastName());
            stmt.setString(3, owner.getEmail());
            stmt.setString(4, owner.getTelNo());
            stmt.setString(5, owner.getPosition());
            stmt.setString(6, owner.getPassword());

            stmt.setInt(7, owner.getOwner_Id());

            rowUpdate = stmt.executeUpdate() > 0;

            //Polymorphism for owner myTask();
            owner.myTask();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdate;

    }

    @Override
    public boolean deleteOwner(int owner_Id) {

        System.out.println(DELETE_OWNER);
        boolean rowDelete = false;

        try {

            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_OWNER);

            stmt.setInt(1, owner_Id);

            rowDelete = stmt.executeUpdate() > 0;

            Owner owner = new Owner();

            //Polymorphism for owner myTask();
            owner.myTask();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowDelete;

    }

}
