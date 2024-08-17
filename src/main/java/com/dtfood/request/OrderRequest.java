package com.dtfood.request;

import com.dtfood.model.Address;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class OrderRequest {
    Long restaurantId;
    Address deliveryAddress;

}
