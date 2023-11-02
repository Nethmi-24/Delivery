package com.springbootExample1.productservice.controller;

import com.springbootExample1.productservice.dto.DeliveryRequest;
import com.springbootExample1.productservice.dto.DeliveryResponse;
import com.springbootExample1.productservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery") 
@RequiredArgsConstructor
public class DeliveryContoller {
    private final DeliveryService deliveryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public void createDelivery(@RequestBody DeliveryRequest deliveryRequest){
deliveryService.createDelivery(deliveryRequest);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryResponse>getAllDelivery(){
        return deliveryService.getAllDelivery();
    }
}
