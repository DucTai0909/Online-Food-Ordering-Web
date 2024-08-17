package com.dtfood.request;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class AddCartItemRequest {
    Long foodId;

    int quantity;

    List<String> ingredients;
}
