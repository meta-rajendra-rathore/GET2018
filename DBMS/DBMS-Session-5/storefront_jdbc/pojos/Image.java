package storefront_jdbc.pojos;

/**
 * @author Rajendra Singh Rathore
 * This bean class wraps the data to/from Image table
 */
public class Image {
    private int id, product_ID;
    private String name, image_URL;
    
    public Image(int product_ID, String name, String image_URL) {
        this.product_ID = product_ID;
        this.name = name;
        this.image_URL = image_URL;
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
     * @return the product_ID
     */
    public int getProduct_ID() {
        return product_ID;
    }

    /**
     * @param product_ID the product_ID to set
     */
    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the image_URL
     */
    public String getImage_URL() {
        return image_URL;
    }

    /**
     * @param image_URL the image_URL to set
     */
    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    @Override
    public String toString() {
        return "Image : \nImage ID = " + id + "\nProduct ID = " + product_ID + "\nName = " + name + "\nImage URL=" + image_URL + "\n";
    }
}
