package trip.cafe.tripcafebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.cafe.tripcafebackend.domain.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
