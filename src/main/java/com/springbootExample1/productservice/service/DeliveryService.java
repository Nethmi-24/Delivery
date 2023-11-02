package com.springbootExample1.productservice.service;

import com.springbootExample1.productservice.dto.DeliveryRequest;
import com.springbootExample1.productservice.dto.DeliveryResponse;
import com.springbootExample1.productservice.model.Delivery;
import com.springbootExample1.productservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public void createDelivery(DeliveryRequest deliveryRequest){
        Delivery delivery= Delivery.builder()
                .delivery_id(deliveryRequest.getDelivery_id())
                .delPerson_name(deliveryRequest.getDelPerson_name())
                .status(deliveryRequest.getStatus())
                .build();
        deliveryRepository.save(delivery);
        log.info("Delivery {} is saved",delivery.getDelivery_id());

    }

    public List<DeliveryResponse> getAllDelivery() {
        List<Delivery> deliveries=deliveryRepository.findAll();
        return deliveries.stream().map(this::mapToDeliveryResponse).toList();
    }
    private DeliveryResponse mapToDeliveryResponse (Delivery delivery){
        return DeliveryResponse.builder()
                .delivery_id(delivery.getDelivery_id())
                .delPerson_name(delivery.getDelPerson_name())
                .status(delivery.getStatus())
                .build();
    }
}
