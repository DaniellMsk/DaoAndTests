package com.danila.restaurantdao.dao;

import com.danila.restaurantdao.exception.DaoException;
import com.danila.restaurantdao.model.Dish;
import com.danila.restaurantdao.model.Restaurant;
import com.danila.restaurantdao.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDao {
    private static final DishDao dishDao = new DishDao();

    private static final String SAVE = "INSERT INTO restaurant.restaurant.dish (name) VALUES (?)";
    private static final String SAVE_RELATIONS = "INSERT INTO restaurant.restaurant.restaurant_dish (restaurant_id, dish_id) VALUES (?, ?)";

    public boolean saveDish(Dish dish, Restaurant restaurant) {
        Integer id = null;
        boolean result = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementRelations = null;

        try {
            connection = ConnectionManager.getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SAVE, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, dish.getName());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                dish.setId(id);
            }

            preparedStatementRelations = connection.prepareStatement(SAVE_RELATIONS);
            preparedStatementRelations.setInt(1, restaurant.getId());
            preparedStatementRelations.setInt(2, dish.getId());

            result = true;

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new DaoException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (preparedStatementRelations != null) {
                    preparedStatementRelations.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        restaurant.getDish().add(dish.getName());

        return result;
    }

    public static DishDao getInstance() {
        return dishDao;
    }
}
