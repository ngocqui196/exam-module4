package exam.codegym.service;

import exam.codegym.model.City;

import java.util.List;

public interface ICityService {
   List<City> findAll();
   City findById(Long id);
   void  save(City city);
   City remove(Long id);
}
