package t1908e.springasm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1908e.springasm.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {
}
