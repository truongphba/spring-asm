package t1908e.springasm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import t1908e.springasm.entity.District;
import t1908e.springasm.repository.DistrictRepository;

import java.util.List;

@Service
@Configurable
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public List<District> saveAll(List<District> list){
        return districtRepository.saveAll(list);
    }
    public List<District> list(){
        return districtRepository.findAll();
    }
}
