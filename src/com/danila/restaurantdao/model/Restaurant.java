package com.danila.restaurantdao.model;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {
    private Integer id;
    private String name;
    private Set<String> review = new HashSet<>();
    private Set<String> dish = new HashSet<>();


    public Restaurant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", review=" + review +
                ", dish=" + dish +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getReview() {
        return review;
    }

    public void setReview(Set<String> review) {
        this.review = review;
    }

    public Set<String> getDish() {
        return dish;
    }

    public void setDish(Set<String> dish) {
        this.dish = dish;
    }
}
