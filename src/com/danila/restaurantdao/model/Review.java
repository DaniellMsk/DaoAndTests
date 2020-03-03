package com.danila.restaurantdao.model;

public class Review {
    private Integer id;
    private String text;
    private Restaurant restaurant;

    public Review(String text, Restaurant restaurant) {
        this.text = text;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurantName(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
