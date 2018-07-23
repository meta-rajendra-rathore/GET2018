package shopping;

public interface Promotion {
	enum PromotionEnum {
		get5("GET05", "2018-05-10", "2018-05-21"), free5("FREE05", "2018-07-10", "2018-07-25"), less5("LESS05", "2018-08-10", "2018-08-30");  // @params promotion code,start and end date of in a month 
		String promoCode;
		double discount;
		String startDate,endDate;
		
		private PromotionEnum(String code, String start, String end) {	// enum constructor
		promoCode = code;
		startDate = start;
		endDate	= end;
		}
		
		public String getPromoCode() {
			return promoCode;
		}
		
		public String getStartDate() {
			return startDate;
		}
		
		public String getEndDate() {
			return endDate;
		}
	}
		
	public double getMinimumPrice();
	
	public void setMinimumPrice(double price);
	
	public double getFixedDiscount();
	
	public void setFixedDiscount(int discount);
	
	public boolean isPromotionApplicable(int productInBill, double billAmount, String userCode);
	
}