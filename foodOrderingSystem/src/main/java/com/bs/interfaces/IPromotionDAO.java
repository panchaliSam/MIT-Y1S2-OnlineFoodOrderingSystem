package main.java.com.bs.interfaces;

/**
 *
 * @author Group4 - Imesh
 */
import java.util.ArrayList;
import main.java.com.bs.model.Promotion;

public interface IPromotionDAO {

    ArrayList<Promotion> selectAllPromotion(int promotion_Id);

    ArrayList<Promotion> selectPromotion(int promotion_Id);

    public boolean insertPromotion(Promotion promotion);

    public boolean updatePromotion(Promotion promotion);

    public boolean deletePromotion(int promotion_Id);

}
