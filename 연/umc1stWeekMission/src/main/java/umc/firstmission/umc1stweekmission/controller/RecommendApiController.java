package umc.firstmission.umc1stweekmission.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import umc.firstmission.umc1stweekmission.domain.Location;
import umc.firstmission.umc1stweekmission.domain.Recommend;
import umc.firstmission.umc1stweekmission.dto.LocationResponseDTO;
import umc.firstmission.umc1stweekmission.dto.RecommendResponseDTO;
import umc.firstmission.umc1stweekmission.dto.RecommendSaveRequestDTO;
import umc.firstmission.umc1stweekmission.repository.RecommendRepository;
import umc.firstmission.umc1stweekmission.service.LocationService;
import umc.firstmission.umc1stweekmission.service.RecommendService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class RecommendApiController {
    private final RecommendService recommendService;
    private final RecommendRepository recommendRepository;

    @PostMapping("/recommends")
    public Long save(@RequestBody final RecommendSaveRequestDTO requestDTO) {
        return recommendService.save(requestDTO);
    }

    @GetMapping("/bookings/{id}")
    public RecommendResponseDTO findById(@PathVariable Long id) {
        return recommendService.findById(id);
    }


    @GetMapping("/bookings")
    public List<Recommend> findAll() {
        return recommendRepository.findAll();
    }

}
