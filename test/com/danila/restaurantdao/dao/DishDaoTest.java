package com.danila.restaurantdao.dao;

import com.danila.restaurantdao.model.Dish;
import com.danila.restaurantdao.model.Restaurant;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class DishDaoTest {
    private DishDao dishDao = DishDao.getInstance();
    private RestaurantDao restaurantDao = new RestaurantDao();

    @Test
    public void checkDishSaving() {
        Restaurant restaurant = new Restaurant("Грабли");
        Dish dish = new Dish("Гречка", restaurant);
        restaurantDao.saveRestaurant(restaurant);
        assertTrue(dishDao.saveDish(dish, restaurant));
    }

}