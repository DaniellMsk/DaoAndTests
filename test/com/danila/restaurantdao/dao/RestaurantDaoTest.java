package com.danila.restaurantdao.dao;

import com.danila.restaurantdao.model.Restaurant;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantDaoTest {
    RestaurantDao restaurantDao = RestaurantDao.getInstance();

    @Test
    public void checkRestaurantSaving() {
        assertNotNull(restaurantDao.saveRestaurant(new Restaurant("Грабли")));
    }
}
