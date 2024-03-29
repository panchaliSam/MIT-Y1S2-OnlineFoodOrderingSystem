package main.java.com.bs.model;

/**
 *
 * @author Group4 - Imesh
 */
public class Promotion {

    private int promotion_Id;
    private int item_Id;
    private int owner_Id;
    private String discount_percentage;
    private String description;
    private String promotion_period;
    private String terms_and_conditions;
    private boolean isActive;

    public Promotion() {

    }

    public Promotion(int promotion_Id, int item_Id,int owner_id, String discount_percentage, String description, String promotion_period, String terms_and_conditions,boolean isActive) {
        this.promotion_Id = promotion_Id;
        this.item_Id = item_Id;
        this.owner_Id=owner_id;
        this.discount_percentage = discount_percentage;
        this.description = description;
        this.promotion_period = promotion_period;
        this.terms_and_conditions = terms_and_conditions;
        this.isActive = isActive;
    }


    public Promotion(int returnPromotionId, int itemId, String discountPercentage, String description, String promotionPeriod, String termsAndConditions, boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getter and Setter for promotion_Id
    public int getPromotion_Id() {
        return promotion_Id;
    }

    public void setPromotion_Id(int promotion_Id) {
        this.promotion_Id = promotion_Id;
    }

    // Getter and Setter for admin_Id
    public int getItem_Id() {
        return item_Id;
    }

    public void setItem_Id(int item_Id) {
        this.item_Id = item_Id;
    }

    // Getter and Setter for Discount_percentage
    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(String discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for promotion_period
    public String getPromotion_period() {
        return promotion_period;
    }

    public void setPromotion_period(String promotion_period) {
        this.promotion_period = promotion_period;
    }

    // Getter and Setter for terms_and_conditions
    public String getTerms_and_conditions() {
        return terms_and_conditions;
    }

    public void setTerms_and_conditions(String terms_and_conditions) {
        this.terms_and_conditions = terms_and_conditions;
    }
    
    public boolean getIsActive(){
        return isActive;
    }
    
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    
    public int getOwner_Id() {
        return owner_Id;
    }

    public void setOwner_Id(int owner_Id) {
        this.owner_Id = owner_Id;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Owner{"
                + "promotion_Id=" + promotion_Id
                + ", item_Id='" + item_Id + '\''
                + ", owner_Id='" + owner_Id + '\''
                + ", discount_percentage='" + discount_percentage + '\''
                + ", description='" + description + '\''
                + ", promotion_period='" + promotion_period + '\''
                + ", terms_and_conditions='" + terms_and_conditions + '\''
                + ", isActive=" + isActive 
                + '}';
    }
}
