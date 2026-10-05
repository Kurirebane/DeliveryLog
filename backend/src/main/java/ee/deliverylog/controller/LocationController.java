package ee.deliverylog.controller;

import ee.deliverylog.dto.LocationRequestDto;
import ee.deliverylog.entity.Location;
import ee.deliverylog.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}/children")
    public List<Location> getChildren(@PathVariable Long id) {
        return locationService.getChildren(id);
    }

    @PostMapping
    public Location createLocation(@Valid @RequestBody LocationRequestDto request) {
        return locationService.saveLocation(request);
    }

    @PutMapping("/{id}")
    public Location updateLocation(
            @PathVariable Long id,
            @Valid @RequestBody LocationRequestDto request) {

        return locationService.updateLocation(id, request);
    }

}