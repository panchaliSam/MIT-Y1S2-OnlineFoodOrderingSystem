package main.java.com.bs.dao;

/**
 *
 * @author CYBORG
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IPromotionDAO;
import main.java.com.bs.model.Promotion;
import main.java.com.bs.utility.DBConnectionManditha;

public class PromotionDAO implements IPromotionDAO {

    private static final String SELECT_ALL_PROMOTIONS = "SELECT promotion_id, item_id, owner_id, discount_percentage, description, "
            + "promotion_period, terms_and_conditions, is_active  "
            + "FROM promotion";

    private static final String SELECT_PROMOTION_BY_ID = "SELECT promotion_id, item_id, owner_id, discount_percentage, description, "
            + "promotion_period, terms_and_conditions, is_active  "
            + "FROM promotion "
            + "WHERE promotion_id = ?";

    private static final String INSERT_PROMOTION = "INSERT INTO promotion(item_id, owner_id, discount_percentage, description, promotion_period, "
            + "terms_and_conditions )"
            + "VALUES(?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_PROMOTION = "UPDATE promotion SET item_id = ?, owner_id = ?, discount_percentage = ?, description = ?, promotion_period = ?, terms_and_conditions = ? WHERE promotion_id = ?";

    private static final String DELETE_PROMOTION = "DELETE FROM promotion WHERE promotion_id = ?";

    @Override
    public ArrayList<Promotion> selectAllPromotion(int promotionId) {
        //Cretaing promotion arraylist
        ArrayList<Promotion> promotions = new ArrayList<>();

        try {
            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_PROMOTIONS);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int returnPromotionId = rs.getInt("promotion_id");
                int itemId = rs.getInt("item_id");
                int ownerId = rs.getInt("owner_id");
                String discountPercentage = rs.getString("discount_percentage");
                String description = rs.getString("description");
                String promotionPeriod = rs.getString("promotion_period");
                String termsAndConditions = rs.getString("terms_and_conditions");
                boolean isActive = rs.getBoolean("is_active");

                Promotion promotion = new Promotion(returnPromotionId, itemId, ownerId, discountPercentage, description, promotionPeriod, termsAndConditions, isActive);

                promotions.add(promotion);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotions;

    }

    @Override
    public ArrayList<Promotion> selectPromotion(int promotionId) {

        //Cretaing customer arraylist
        ArrayList<Promotion> promotions = new ArrayList<>();

        try {
            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_PROMOTION_BY_ID);
            stmt.setInt(1, promotionId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int returnPromotionId = rs.getInt("promotion_id");
                int itemId = rs.getInt("item_id");
                int ownerId = rs.getInt("owner_id");
                String discountPercentage = rs.getString("discount_percentage");
                String description = rs.getString("description");
                String promotionPeriod = rs.getString("promotion_period");
                String termsAndConditions = rs.getString("terms_and_conditions");
                boolean isActive = rs.getBoolean("is_active");

                //Promotion promotion = new Promotion(returnPromotionId, ownerId, itemId, discountPercentage, description, promotionPeriod, termsAndConditions, isActive );
                Promotion promotion = new Promotion();

                promotion.setPromotion_Id(returnPromotionId);
                promotion.setItem_Id(itemId);
                promotion.setOwner_Id(ownerId);
                promotion.setDiscount_percentage(discountPercentage);
                promotion.setDescription(description);
                promotion.setPromotion_period(promotionPeriod);
                promotion.setTerms_and_conditions(termsAndConditions);

                promotions.add(promotion);

                System.out.println("\nSelected Customer: " + promotion.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotions;

    }

    @Override
    public boolean insertPromotion(Promotion promotion) {

        System.out.println(INSERT_PROMOTION);
        boolean rowInserted = false;

        try {

            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_PROMOTION);

            
            stmt.setInt(1, promotion.getItem_Id());
            stmt.setInt(2, promotion.getOwner_Id());
            stmt.setString(3, promotion.getDiscount_percentage());
            stmt.setString(4, promotion.getDescription());
            stmt.setString(5, promotion.getPromotion_period());
            stmt.setString(6, promotion.getTerms_and_conditions());

            stmt.executeUpdate();

            rowInserted = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    @Override
    public boolean updatePromotion(Promotion promotion) {

        System.out.println(UPDATE_PROMOTION);
        boolean rowUpdate = false;

        try {

            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_PROMOTION);

            stmt.setInt(1, promotion.getItem_Id());
            stmt.setInt(2, promotion.getOwner_Id());
            stmt.setString(3, promotion.getDiscount_percentage());
            stmt.setString(4, promotion.getDescription());
            stmt.setString(5, promotion.getPromotion_period());
            stmt.setString(6, promotion.getTerms_and_conditions());

            stmt.setInt(7, promotion.getPromotion_Id());

            rowUpdate = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowUpdate;

    }

    @Override
    public boolean deletePromotion(int promotionId) {

        System.out.println(DELETE_PROMOTION);
        boolean rowDelete = false;

        try {

            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_PROMOTION);

            stmt.setInt(1, promotionId);

            rowDelete = stmt.executeUpdate() > 0;

            Promotion promotion = new Promotion();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowDelete;

    }

}
