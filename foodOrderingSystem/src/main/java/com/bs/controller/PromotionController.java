/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.PromotionDAO;
import main.java.com.bs.interfaces.IPromotionDAO;
import main.java.com.bs.model.Promotion;

/**
 *
 * @author Group4 Imesh
 */
public class PromotionController {
    
    private final IPromotionDAO promotionDAO;
    
    public PromotionController(){
        
        this.promotionDAO = new PromotionDAO();
        
    }
    
    public void addPromotion(int itemId, String discountPercentage, String description, String pPeriod, String termsAndConditions){
        Promotion promotion = new Promotion();
        promotion.setItem_Id(itemId);
        promotion.setDiscount_percentage(discountPercentage);
        promotion.setDescription(description);
        promotion.setPromotion_period(pPeriod);
        promotion.setTerms_and_conditions(termsAndConditions);
       
        promotionDAO.insertPromotion(promotion);
    }
    
    public void updatePromotion(int promotionId, int itemId, String discountPercentage, String description, String promotionPeriod , String termsAndConditions){
        Promotion promotion = new Promotion();
        promotion.setItem_Id(itemId);
        promotion.setDiscount_percentage(discountPercentage);
        promotion.setDescription(description);
        promotion.setPromotion_period(promotionPeriod);
        promotion.setTerms_and_conditions(termsAndConditions);
      
        promotionDAO.updatePromotion(promotion);
    }
    
    public void deletePromotion(int id){
        promotionDAO.deletePromotion(id);
    }
    
    public void selectPromotion(int id){
        promotionDAO.selectPromotion(id);
    }
  
    
}
