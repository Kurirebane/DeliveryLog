package ee.deliverylog.controller;

import ee.deliverylog.dto.DeliveryStopRequestDto;
import ee.deliverylog.entity.DeliveryStop;
import ee.deliverylog.service.DeliveryStopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-stops")
public class DeliveryStopController {

    private final DeliveryStopService deliveryStopService;

    public DeliveryStopController(DeliveryStopService deliveryStopService) {
        this.deliveryStopService = deliveryStopService;
    }

    @GetMapping
    public List<DeliveryStop> getAllDeliveryStops() {
        return deliveryStopService.getAllDeliveryStops();
    }

    @PostMapping
    public DeliveryStop confirmStop(@RequestBody DeliveryStopRequestDto request) {
        return deliveryStopService.confirmStop(request);
    }
}