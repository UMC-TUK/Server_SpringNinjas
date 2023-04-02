package umc.firstmission.umc1stweekmission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.firstmission.umc1stweekmission.domain.Recommend;
import umc.firstmission.umc1stweekmission.dto.LocationSaveRequestDTO;
import umc.firstmission.umc1stweekmission.repository.LocationRepository;
import umc.firstmission.umc1stweekmission.repository.RecommendRepository;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final RecommendRepository recommendRepository;

    /**
     * 관광지 예약
     */
    @Transactional
    public Long save(Long id, final LocationSaveRequestDTO requestDTO) {

        Optional<Recommend> recommend = recommendRepository.findById(id);
        requestDTO.setRecommend(recommend.get());

        return locationRepository.save(requestDTO.toEntity()).getId();
    }

}
