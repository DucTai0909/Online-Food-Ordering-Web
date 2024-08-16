package com.dtfood.request;

import com.dtfood.model.Category;
import com.dtfood.model.IngredientsItem;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateFoodRequest {

    String name;
    String description;
    Long price;

    Category category;
    List<String> imgaes;

    Long restaurantId;
    boolean vegertarian;
    boolean seasional;
    List<IngredientsItem> ingredients;
}
