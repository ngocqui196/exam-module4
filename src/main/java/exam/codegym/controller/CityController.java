package exam.codegym.controller;

import exam.codegym.model.City;
import exam.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private ICityService  iCityService;

    @GetMapping(value = "/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city) {
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message","New city created successfully");
        return modelAndView;
    }

    @GetMapping("/city")
    public ModelAndView listCity(){
        List<City> citys = iCityService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("city", citys);
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable(value = "id") Long id){
        City city = iCityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        return modelAndView;


//        if(city != null) {
//            ModelAndView modelAndView = new ModelAndView("edit");
//            modelAndView.addObject("city", city);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("customer") City city){
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        City city = iCityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("city",city);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city) {
        iCityService.remove(city.getId());
        return "redirect:city";
    }

}
