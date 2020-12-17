package exam.codegym.repository;

import exam.codegym.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long>   {
}
