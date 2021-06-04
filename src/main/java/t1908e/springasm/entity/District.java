package t1908e.springasm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import t1908e.springasm.dto.DistrictDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Street> streets;
    public void addStreet(Street street) {
        if (this.streets == null) {
            this.streets = new HashSet<>();
        }
        this.streets.add(street);
    }
    public District(String name) {
        this.name = name;
    }
    public DistrictDTO toDistrictDTO(){
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(this.id);
        districtDTO.setName(this.name);
        districtDTO.setStreets(this.streets.stream().map(x->x.toStreetDTO()).collect(Collectors.toList()));
        return districtDTO;
    }
}
