package shopping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FixedProductPromotion implements Promotion {		// public class implementing interface Promotion
	double minimumPrice;
	double fixedDiscount;
	
	public FixedProductPromotion(double minBill, int discount) {
		setMinimumPrice(minBill);					// setting up minimum price and no of products limit to avail discount
		setFixedDiscount(discount);										// also declaring discount percent
	}
	
	public double getMinimumPrice() {
		return minimumPrice;
	}
	
	public void setMinimumPrice(double price) {
		minimumPrice = price;
	}
	
	public double getFixedDiscount() {
		return fixedDiscount;
	}
	
	public void setFixedDiscount(int discount) {
		fixedDiscount = discount;
	}
	
	public boolean isPromotionApplicable(int productInBill,double billAmount, String userCode) { // @params no of products in bill, total amount, promo code entered
		Calendar cal = Calendar.getInstance();
		final Date date = cal.getTime();
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(date);		// @return boolean variable to show discount availability
		
		if(billAmount >= getMinimumPrice()) {
			for(PromotionEnum promo : PromotionEnum.values()) {
					if(userCode.equals(promo.getPromoCode())) {
						System.out.println("Date : " + currentDate);
						if(currentDate.compareTo(promo.getStartDate())>=0 && currentDate.compareTo(promo.getEndDate())<=0) {
							return true;
						} else {
							System.out.println("SORRY!!! This promo-code is not active now.");
							return false;
						}
					}
			} 
			System.out.println("SORRY!!! This promo-code doesn't exist.");
		}
		else
			System.out.println("You don't reach minimum bill amount to avail any offers.");
		return false;
	}

}