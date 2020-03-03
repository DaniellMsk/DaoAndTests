package com.danila.restaurantdao.dao;

import com.danila.restaurantdao.model.Restaurant;
import com.danila.restaurantdao.model.Review;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class ReviewDaoTest {
    private ReviewDao reviewDao = ReviewDao.getInstance();
    private RestaurantDao restaurantDao = RestaurantDao.getInstance();

    @Test
    public void checkReviewSaving() {
        Restaurant restaurant = new Restaurant("Заря");
        restaurantDao.saveRestaurant(restaurant);
        assertNotNull(reviewDao.saveReview(new Review("Тут круто!", restaurant)));
    }

}
