package com.dtfood.service;

import com.dtfood.model.Category;
import com.dtfood.model.Food;
import com.dtfood.model.Restaurant;
import com.dtfood.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    public void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantFood(Long restaurantId,
                                        boolean isVegertarian,
                                        boolean isNonveg,
                                        boolean isSesional,
                                        String foodCategory);

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;
}
