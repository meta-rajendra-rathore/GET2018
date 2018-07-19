/*
 * This class is used to provide used to provide promotion discount on the basis of products
 * @authore Rajendra Singh Rathore
 *
 */
import java.util.Calendar;

public class FixedOrderPromotion implements Promotion {		// class implementing interface Promotion
	double minimumPrice;
	double fixedDiscount;
	
	public FixedOrderPromotion(double minBill) {
		setMinimumPrice(minBill);					// setting up minimum price limit to avail discount
		setFixedDiscount();							// also declaring discount percent
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
	
	public void setFixedDiscount() {
		fixedDiscount = 0.05;						// 5% discount is given 
	}
	
	public boolean isPromotionApplicable(double billAmount, String userCode) { 			// @params total amount, promo code entered
		if(billAmount >= getMinimumPrice()) {												// @return boolean variable to show discount availability
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			
			for (PromotionEnum promo : PromotionEnum.values())
				if (userCode.equals(promo.getPromoCode())) {
					if(dayOfMonth >= promo.getStartDate() && dayOfMonth<=promo.getEndDate())
						return true;
					else {
						System.out.println("SORRY!!! This promo-code is not active now.");
						return false;
					}
				}
				System.out.println("SORRY!!! This promo-code doesn't exist.");
		}
		return false;
	}

}
