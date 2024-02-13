package com.modelexample.model_demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.modelexample.model_demo.model.*;//importing addressModel

import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

// //task 4
// @RestController
// public class AddressController {
//     @GetMapping("/path")
//     public AddressModel getMethodName() {
//         return new AddressModel("Pavithran", 07, "north", 05, "kuniyamuthur", "Coimbatore", "TN", "INDIA");
//     } 
// }

//task 5
@RestController
public class AddressController{
    @GetMapping("/path")
    public List<AddressModel> getMethodName() {
        List<AddressModel> addressList = new ArrayList<>();

        addressList.add(new AddressModel("Pavithran", 01, "north", 064, "skcet", "Coimbatore", "TN", "INDIA"));
        addressList.add(new AddressModel("Pavithran", 01, "north", 064, "skcet", "Coimbatore", "TN", "INDIA"));
        addressList.add(new AddressModel("Pavithran", 01, "north", 064, "skcet", "Coimbatore", "TN", "INDIA"));
        addressList.add(new AddressModel("Pavithran", 01, "north", 064, "skcet", "Coimbatore", "TN", "INDIA"));
        
        return addressList;
    }
    
}
