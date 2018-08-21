package storefront_jdbc.pojos;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class TopCategories {
    private String name;
    private int noOfSubCategories;
    
    public TopCategories(String name, int noOfSubCategories) {
        this.name = name;
        this.noOfSubCategories = noOfSubCategories;
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
     * @return the noOfSubCategories
     */
    public int getNoOfSubCategories() {
        return noOfSubCategories;
    }

    /**
     * @param noOfSubCategories the noOfSubCategories to set
     */
    public void setNoOfSubCategories(int noOfSubCategories) {
        this.noOfSubCategories = noOfSubCategories;
    }

    @Override
    public String toString() {
        return "TopCategories [name=" + name + ", noOfSubCategories=" + noOfSubCategories + "]\n";
    }
}
