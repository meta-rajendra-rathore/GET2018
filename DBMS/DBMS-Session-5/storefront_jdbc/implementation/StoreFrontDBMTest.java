package storefront_jdbc.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class StoreFrontDBMTest {

    @Test
    public void test() {
        StoreFrontDBM.createConnection();
        DatabaseHelper.getShippedOrdersOfUser(StoreFrontDBM.getConnection(), 3);
    }

}
