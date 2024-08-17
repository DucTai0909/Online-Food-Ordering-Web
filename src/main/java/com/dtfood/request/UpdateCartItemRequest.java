package com.dtfood.request;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UpdateCartItemRequest {
    Long cartItemId;
    int quantity;

}
