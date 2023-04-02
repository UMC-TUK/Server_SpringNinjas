package umc.firstmission.umc1stweekmission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.firstmission.umc1stweekmission.domain.Recommend;
import umc.firstmission.umc1stweekmission.dto.RecommendResponseDTO;
import umc.firstmission.umc1stweekmission.dto.RecommendSaveRequestDTO;
import umc.firstmission.umc1stweekmission.repository.LocationRepository;
import umc.firstmission.umc1stweekmission.repository.RecommendRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendService {
    private final RecommendRepository recommendRepository;
    private final LocationRepository locationRepository;

    /**
     * 예약 생성
     */
    @Transactional
    public Long save(final RecommendSaveRequestDTO requestDTO) {
        return recommendRepository.save(requestDTO.toEntity()).getId();
    }

    /**
     * 예약 정보 조회
     */
    public RecommendResponseDTO findById(Long id) {
        Recommend entity = recommendRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 예약 정보가 존재하지 않습니다. id= " + id));
        return new RecommendResponseDTO(entity);
    }

    /**
     * 예약 정보 전체 조회
     */
    public List<RecommendResponseDTO> findAll() {
        List<Recommend> list = recommendRepository.findAll();
        return list.stream().map(RecommendResponseDTO::new).collect(Collectors.toList());
    }

}
