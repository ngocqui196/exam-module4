package exam.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCity;
    private String nameCountry;
    private double area;
    private Long population;
    private Long GDP;
    private String cityDetail;

    public City() {
    }

    public City(Long id, String nameCity, String nameCountry, Long area, Long population, Long GDP, String cityDetail) {
        this.id = id;
        this.nameCity = nameCity;
        this.nameCountry = nameCountry;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.cityDetail = cityDetail;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d,nameCity='%s',nameCountry='%s',Area='%d',Population='%d',GDP='%d',CityDetail='%s']"
                ,id,nameCity,nameCountry, area,population,GDP, cityDetail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public double getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getCityDetail() {
        return cityDetail;
    }

    public void setCityDetail(String cityDetail) {
        this.cityDetail = cityDetail;
    }
}
