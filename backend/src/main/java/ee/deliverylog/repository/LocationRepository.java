package ee.deliverylog.repository;

import ee.deliverylog.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository <Location,Long> {

    List<Location> findByParentLocationId(Long parentId);

}
