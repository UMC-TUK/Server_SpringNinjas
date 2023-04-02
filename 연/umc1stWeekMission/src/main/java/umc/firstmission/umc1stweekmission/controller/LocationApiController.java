package umc.firstmission.umc1stweekmission.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import umc.firstmission.umc1stweekmission.dto.LocationSaveRequestDTO;
import umc.firstmission.umc1stweekmission.service.LocationService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class LocationApiController {

    private final LocationService locationService;

    @PostMapping("/locations/{id}")
    public Long save(@PathVariable Long id, @RequestBody final LocationSaveRequestDTO requestDTO) {
        return locationService.save(id, requestDTO);
    }
}
