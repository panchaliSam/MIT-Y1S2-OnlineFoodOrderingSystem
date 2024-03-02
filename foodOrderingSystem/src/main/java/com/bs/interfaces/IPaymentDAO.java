/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.java.com.bs.interfaces;

import java.util.ArrayList;
import main.java.com.bs.model.Payment;

/**
 *
 * @author Group4 - Dulan
 */
public interface IPaymentDAO {
    
        ArrayList<Payment>selectAllPayment(int paymentId);
    	ArrayList<Payment>selectPayment(int paymentId);
	public boolean insertPayment (Payment payment);
	public boolean updatePayment (Payment payment);
	public boolean deletePayment (int paymentId);
}
