package t1908e.springasm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t1908e.springasm.dto.StreetDTO;
import t1908e.springasm.service.DistrictService;
import t1908e.springasm.service.StreetService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/streets")
public class StreetController {

    @Autowired
    StreetService streetService;
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.POST)
    public StreetDTO create(@RequestBody StreetDTO streetDTO) {
        return streetService.create(streetDTO.toStreet()).toStreetDTO();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StreetDTO> findAllByDistrictIdAndName(@RequestParam(defaultValue = "") String streetName, @RequestParam(defaultValue = "0") int districtId) {
        List<StreetDTO> list;
        if (districtId != 0 && !streetName.equals("")) {
            list = streetService.findStreetByNameContainsAndDistrictId(streetName, districtId).stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        } else if (districtId == 0 && !streetName.equals("")) {
            list = streetService.findStreetByNameContains(streetName).stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        } else if (districtId != 0 && streetName.equals("")) {
            list = streetService.findStreetByDistrictId(districtId).stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        } else {
            list = streetService.list().stream().map(x -> x.toStreetDTO()).collect(Collectors.toList());
        }
        return list;
    }

}
