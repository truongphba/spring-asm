package t1908e.springasm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import t1908e.springasm.entity.Street;
import t1908e.springasm.repository.StreetRepository;

import java.util.List;

@Service
@Configurable
public class StreetService {

    @Autowired
    StreetRepository streetRepository;
    public Street create(Street street){
        return streetRepository.save(street);
    }

    public List<Street> list() {
        return streetRepository.findAll();
    }

    public List<Street> findStreetByNameContainsAndDistrictId( String streetName,int districtId){
        return streetRepository.findStreetByNameContainsAndDistrictId(streetName,districtId);
    }

    public List<Street> findStreetByNameContains( String streetName){
        return streetRepository.findStreetByNameContains(streetName);
    }
    
    public List<Street> findStreetByDistrictId(int districtId){
        return streetRepository.findStreetByDistrictId(districtId);
    }
}
