public interface Promotion{
	enum PromotionEnum{
		get5("GET05",1,5),free5("FREE05",10,15),less5("LESS05",25,28);  // @params promotion code,start and end date of in a month 
		String promoCode;
		double discount;
		int startDate,endDate;
		
		private PromotionEnum(String code,int start,int end){
			promoCode = code;
			start = startDate;
			end = endDate;
		}
		
		public String getPromoCode(){
			return promoCode;
		}
		
		public int getStartDate(){
			return startDate;
		}
		
		public int getendDate(){
			return endDate;
		}
	}
	
	public PromotionEnum getPromotionEnum();
}

public class FixedProductPromotion implement Promotion{
	int minQuantity;
	double minimumPrice;
	double fixedDiscount;
	
	public FixedProductPromotion(int minProducts, double minBill){
		setMinimumPrice(minProducts,minBill);
		setFixedDiscount();
	}
	
	public PromotionEnum getPromotionEnum(){
		return PromotionEnum;
	}
	
	public double getMinQuantity(){
		return minQuantity;
	}
	
	public double getMinimumPrice(){
		return minimumPrice;
	}
	
	public void setMinimumPrice(int quantity, double price){
		minQuantity = quantity;
		minimumPrice = price;
	}
	
	public double getFixedDiscount(){
		return fixedDiscount;
	}
	
	public void setFixedDiscount(){
		fixedDiscount = 0.05;	// 5% discount is given 
	}
	
	public boolean isPromotionApplicable(int productInBill,double billAmount, String userCode){
		for(PromotionEnum promo : getPromotionEnum().values()){
			if(userCode.equals(promo.getPromoCode()))
				if(billAmount>=getMinimumPrice())
					if(productInBill>=getMinQuantity())
						return true;
		}
		return false;
	}

}

/*class FixedOrderPromotion implement Promotion{
	public double getMinimumPrice(){
		
	}
	
	public void setMinimumPrice(double price){
		
	}
	
	public double getFixedDiscount(){
		
	}
	
	public void setFixedDiscount(double discount){
		
	}
	
	public boolean isPromotionApplicable(String userCode){
		
	}

}*/