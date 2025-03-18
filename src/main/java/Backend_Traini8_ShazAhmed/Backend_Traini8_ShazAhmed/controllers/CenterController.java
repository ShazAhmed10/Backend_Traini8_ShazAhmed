package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.controllers;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos.CenterRequestDto;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.dtos.CenterResponseDto;
import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.services.CenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class CenterController {
    private final CenterService centerService;

    @Autowired
    public CenterController(CenterService centerService){
        this.centerService = centerService;
    }

    //REST API to add a new training center
    @PostMapping("/addCenter")
    public ResponseEntity<CenterResponseDto> createCenter(@Valid @RequestBody CenterRequestDto requestDto){
        CenterResponseDto responseDto = centerService.createCenter(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    //REST API to find filtered or all training centers
    @GetMapping("/getCenters")
    public ResponseEntity<List<CenterResponseDto>> findAllCenters(@RequestParam(required = false) String centerName,
                                                                  @RequestParam(required = false) Long studentCapacity,
                                                                  @RequestParam(required = false) List<String> courses,
                                                                  @RequestParam(required = false) String state){
        List<CenterResponseDto> centerResponseDtoList = centerService.findAllCenters(centerName, studentCapacity, courses, state);
        return new ResponseEntity<>(centerResponseDtoList, HttpStatus.OK);
    }
}
