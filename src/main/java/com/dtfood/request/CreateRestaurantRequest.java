package com.dtfood.request;

import com.dtfood.model.Address;
import com.dtfood.model.ContactInfomation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInfomation contactInfomation;
    private String openHours;
    private List<String> images;

}
