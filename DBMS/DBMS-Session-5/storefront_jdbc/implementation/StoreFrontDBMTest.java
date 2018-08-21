package storefront_jdbc.implementation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import storefront_jdbc.databasehelper.DatabaseHelper;
import storefront_jdbc.pojos.Image;

public class StoreFrontDBMTest {

    @Test
    public void test() {
        StoreFrontDBM.createConnection();
        Connection connection = StoreFrontDBM.getConnection();
        
        DatabaseHelper.getShippedOrdersOfUser(connection, 2);
        
        List<Image> listOfImages = new ArrayList<>();
        listOfImages.add(new Image(5, "Front", "www.mystorage.come/project1/product5/Front"));
        listOfImages.add(new Image(5, "Side1", "www.mystorage.come/project1/product5/Side1"));
        listOfImages.add(new Image(5, "Side2", "www.mystorage.come/project1/product5/Side2"));
        listOfImages.add(new Image(5, "Behind", "www.mystorage.come/project1/product5/Behind"));
        DatabaseHelper.insertNEwImages(connection, listOfImages);
        
        DatabaseHelper.disableInactiveProducts(connection);
        
        DatabaseHelper.showTopCategories(connection);
    }

}
