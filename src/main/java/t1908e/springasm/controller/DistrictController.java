package t1908e.springasm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import t1908e.springasm.dto.DistrictDTO;
import t1908e.springasm.service.DistrictService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/districts")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DistrictDTO> list() {
        return districtService.list().stream().map(x -> x.toDistrictDTO()).collect(Collectors.toList());
    }
}
