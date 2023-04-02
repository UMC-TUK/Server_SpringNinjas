package umc.firstmission.umc1stweekmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.firstmission.umc1stweekmission.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    //find by recommendId
    Location findByRecommendId(Long id);
}
