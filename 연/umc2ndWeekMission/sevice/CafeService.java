package trip.cafe.tripcafebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.cafe.tripcafebackend.dto.CafeSaveRequestDTO;
import trip.cafe.tripcafebackend.repository.CafeRepository;

@RequiredArgsConstructor
@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    @Transactional
    public Long save(final CafeSaveRequestDTO requestDTO) {
        return cafeRepository.save(requestDTO.toEntity()).getId();
    }
}
