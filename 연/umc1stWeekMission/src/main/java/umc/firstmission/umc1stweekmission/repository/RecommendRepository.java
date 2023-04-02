package umc.firstmission.umc1stweekmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.firstmission.umc1stweekmission.domain.Location;
import umc.firstmission.umc1stweekmission.domain.Recommend;

import java.util.List;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {

    //find recommend by name
    Recommend findByName(String name);
}
