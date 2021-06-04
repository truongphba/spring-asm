package t1908e.springasm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import t1908e.springasm.entity.District;
import t1908e.springasm.entity.Street;

import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StreetDTO {
    private int id;
    private String name;
    private long operationDate;
    private String description;
    private int status;

    private int districtId;
    private String districtName;
    public Street toStreet(){
        Street street = new Street();
        street.setId(this.id);
        street.setName(this.name);
        street.setOperationDate(this.operationDate);
        street.setDescription(this.description);
        street.setStatus(this.status);
        street.setDistrictId(this.districtId);
        street.setDistrict(new District(this.districtId,this.districtName, Collections.singleton(street)));
        return street;
    }
}
