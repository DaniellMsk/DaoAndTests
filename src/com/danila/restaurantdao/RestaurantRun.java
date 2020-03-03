package com.danila.restaurantdao;

import com.danila.restaurantdao.dao.DishDao;
import com.danila.restaurantdao.dao.RestaurantDao;
import com.danila.restaurantdao.dao.ReviewDao;
import com.danila.restaurantdao.model.Dish;
import com.danila.restaurantdao.model.Restaurant;
import com.danila.restaurantdao.model.Review;
import com.danila.restaurantdao.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class RestaurantRun {
    public static void main(String[] args) {
        RestaurantDao restaurantDao = RestaurantDao.getInstance();
        ReviewDao reviewDao = ReviewDao.getInstance();
        DishDao dishDao = DishDao.getInstance();

        Restaurant restaurant = new Restaurant("Шоколадница");
        Review review = new Review("Кофе топчик", restaurant);
        Dish dish = new Dish("Гречка", restaurant);
        Dish dish1 = new Dish("Кофе", restaurant);

        restaurantDao.saveRestaurant(restaurant);
        reviewDao.saveReview(review);
        dishDao.saveDish(dish, restaurant);
        dishDao.saveDish(dish1, restaurant);

        System.out.println(restaurant.toString());
    }
}
