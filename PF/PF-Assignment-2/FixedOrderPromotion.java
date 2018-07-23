package shopping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FixedOrderPromotion implements Promotion {		// class implementing interface Promotion
	double minimumPrice;
	double fixedDiscount;
	
	public FixedOrderPromotion(double minBill, int discount) {
		setMinimumPrice(minBill);					// setting up minimum price limit to avail discount
		setFixedDiscount(discount);							// also declaring discount percent
	}
	
	public double getMinQuantity() {  
		return 0;
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
		fixedDiscount = discount;						// 5% discount is given 
	}
	
	public boolean isPromotionApplicable(int products, double billAmount, String userCode) { 			// @params total amount, promo code entered
		if (billAmount >= getMinimumPrice()) {												// @return boolean variable to show discount availability
			Calendar cal = Calendar.getInstance();
			final Date date = cal.getTime();
			String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(date);		// @return boolean variable to show discount availability
				for (PromotionEnum promo : PromotionEnum.values())
				if (userCode.equals(promo.getPromoCode())) {
					if(currentDate.compareTo(promo.getStartDate())>=0 && currentDate.compareTo(promo.getEndDate())<=0) {
						return true;
					} else {
						System.out.println("SORRY!!! This promo-code is not active now.");
						return false;
					}
				}
				System.out.println("SORRY!!! This promo-code doesn't exist.");
		}
		return false;
	}

}