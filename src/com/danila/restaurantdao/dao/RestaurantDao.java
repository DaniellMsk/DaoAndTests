package com.danila.restaurantdao.dao;

import com.danila.restaurantdao.model.Restaurant;
import com.danila.restaurantdao.util.ConnectionManager;

import java.sql.*;

public class RestaurantDao {

    private static final RestaurantDao restaurantDao = new RestaurantDao();

    private static final String SAVE = "INSERT INTO restaurant.restaurant.restaurant (name) VALUES (?)";
    public Integer saveRestaurant(Restaurant restaurant){
        Integer id = null;

        try(Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                restaurant.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }


    public static RestaurantDao getInstance(){
        return restaurantDao;
    }
}
