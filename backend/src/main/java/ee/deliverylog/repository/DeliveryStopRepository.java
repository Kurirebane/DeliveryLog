package ee.deliverylog.repository;

import ee.deliverylog.entity.DeliveryStop;
import ee.deliverylog.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryStopRepository extends JpaRepository <DeliveryStop, Long> {
}
