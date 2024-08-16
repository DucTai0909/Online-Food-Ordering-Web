package com.dtfood.service;

import com.dtfood.model.Category;
import com.dtfood.model.Food;
import com.dtfood.model.Restaurant;
import com.dtfood.repository.FoodRepository;
import com.dtfood.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImp implements FoodService{

    @Autowired
    private FoodRepository foodRepository;



    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        Food food = new Food();
        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImgaes());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredients(req.getIngredients());
        food.setSeasonal(req.isSeasional());
        food.setIngredients(req.getIngredients());

        Food savedFood = foodRepository.save(food);
        restaurant.getFoods().add(savedFood);
        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.setRestaurant(null);
        foodRepository.save(food);
    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId,
                                        boolean isVegertarian,
                                        boolean isNonveg,
                                        boolean isSesional,
                                        String foodCategory) {
        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);

        if(isVegertarian){
            foods = filterByVegertarian(foods, isVegertarian);
        }
        if(isNonveg){
            foods = filterByNonVeg(foods, isNonveg);
        }
        if(isSesional){
            foods = filterBySeasonal(foods, isSesional);
        }
        if(foodCategory != null && !foodCategory.equals("")){
            foods = filterByCategory(foods, foodCategory);

        }

        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory() != null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSesional) {
        return foods.stream().filter(food -> food.isSeasonal() == isSesional).collect(Collectors.toList());
    }

    private List<Food> filterByNonVeg(List<Food> foods, boolean isNonveg) {
        return foods.stream().filter(food -> food.isVegetarian() == isNonveg).collect(Collectors.toList());
    }

    private List<Food> filterByVegertarian(List<Food> foods, boolean isVegertarian) {
        return foods.stream().filter(food -> food.isVegetarian() == isVegertarian).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        Optional<Food> optionalFood = foodRepository.findById(foodId);

        if(optionalFood.isEmpty()){
            throw new Exception("Food not found with id " + foodId);
        }
        return optionalFood.get();
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);
    }
}
