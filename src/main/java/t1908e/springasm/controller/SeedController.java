package t1908e.springasm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import t1908e.springasm.entity.District;
import t1908e.springasm.entity.Street;
import t1908e.springasm.service.DistrictService;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "/seed/generate")
public class SeedController {
    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.GET)
    public String seed(){
        District district1 = new District("Bắc Từ Liêm");
        district1.addStreet(new Street("Phú Đô", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Dân cư đông đúc, ồn ào", (int) random(0, 2),district1));
        district1.addStreet(new Street("Hồ Tùng Mậu", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Dân cư đông đúc, ồn ào", (int) random(0, 2),district1));
        District district2 = new District("Hoàn Kiếm");
        district2.addStreet(new Street("Hàng Ngang", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Dân cư đông đúc, ồn ào", (int) random(0, 2),district2));
        district2.addStreet(new Street("Hàng đào", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Dân cư đông đúc, ồn ào",(int) random(0, 2),district2));
        District district3 = new District("Ba Đình");
        district3.addStreet(new Street("Hoàng Diệu", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Dân cư đông đúc, ồn ào", (int) random(0,2),district3));
        district3.addStreet(new Street("Liễu Giai", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Dân cư đông đúc, ồn ào",(int) random(0,2),district3));
        District district4 = new District("Cầu Giấy");
        district4.addStreet(new Street("Quan Hoa", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Con đường mang tên 1 quận",(int) random(0,2),district4));
        district4.addStreet(new Street("Nguyễn Khánh Toàn", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Ở đây có 2 cái Circle K",(int) random(0,2),district4));
        District district5 = new District("Đống Đa");
        district5.addStreet(new Street("Đường Láng", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Con đường kéo dài hơn 1000 số nhà",(int) random(0,2),district5));
        district5.addStreet(new Street("Chùa Bộc", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Thiên đường thời trang",(int) random(0,2),district5));
        List<District> districts = Arrays.asList(district1, district2, district3, district4,district5);
        districtService.saveAll(districts);
        return "done";
    }

    public long random(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
