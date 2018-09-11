package storefront_jdbc.pojos;

import java.sql.Date;

/**
 * @author Rajendra Singh Rathore
 * This bean class wraps the data to/from Orders table
 */
public class Order {
    private int id;
    private Date orderDate;
    private int orderAmount;
    
    public Order(int id, Date orderDate, int orderAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the orderAmount
     */
    public int getOrderAmount() {
        return orderAmount;
    }

    /**
     * @param orderAmount the orderAmount to set
     */
    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Order :\nOrder ID = " + id + "\nOrder Date = " + orderDate + "\nOrder Amount = " + orderAmount + "\n";
    }
}
