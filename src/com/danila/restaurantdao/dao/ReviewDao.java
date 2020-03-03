package com.danila.restaurantdao.dao;

import com.danila.restaurantdao.model.Restaurant;
import com.danila.restaurantdao.model.Review;
import com.danila.restaurantdao.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDao {
    private static ReviewDao reviewDao = new ReviewDao();
    private static final String SAVE = "INSERT INTO restaurant.restaurant.review (text, restaurant_id) VALUES (?, ?)";

    public Integer saveReview(Review review){
        Integer id = null;

        try(Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, review.getText());
            preparedStatement.setInt(2, review.getRestaurant().getId());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                review.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        review.getRestaurant().getReview().add(review.getText());
        return id;
    }

    public static ReviewDao getInstance(){
        return reviewDao;
    }
}
