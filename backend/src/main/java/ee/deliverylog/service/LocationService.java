package ee.deliverylog.service;

import ee.deliverylog.dto.LocationRequestDto;
import ee.deliverylog.entity.Location;
import ee.deliverylog.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public List<Location> getChildren(Long parentId) {
        return locationRepository.findByParentLocationId(parentId);
    }

    public Location saveLocation(LocationRequestDto request) {

        Location location = new Location();
        location.setName(request.getName());

        if (request.getParentLocationId() != null) {
            Location parentLocation = locationRepository
                    .findById(request.getParentLocationId())
                    .orElseThrow(() -> new RuntimeException("Parent location not found"));

            location.setParentLocation(parentLocation);
        }

        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, LocationRequestDto request) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        location.setName(request.getName());

        if (request.getParentLocationId() != null) {
            Location parentLocation = locationRepository
                    .findById(request.getParentLocationId())
                    .orElseThrow(() -> new RuntimeException("Parent location not found"));

            location.setParentLocation(parentLocation);
        } else {
            location.setParentLocation(null);
        }

        return locationRepository.save(location);
    }


}