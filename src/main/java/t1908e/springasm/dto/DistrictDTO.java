package t1908e.springasm.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictDTO {
    private int id;
    private String name;
    private List<StreetDTO> streets;
}
