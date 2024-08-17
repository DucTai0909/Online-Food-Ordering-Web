package com.dtfood.request;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class IngredientRequest {
    String name;
    Long categoryId;
    Long restaurantId;
}
