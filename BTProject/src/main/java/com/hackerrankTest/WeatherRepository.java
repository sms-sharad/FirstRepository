package com.hackerrankTest;

import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Integer> 
{
   /* public Weather earase();
    public Weather earaseByParam(Date startDate,Date endDate,float lati,float longi);
    public Weather addData(Weather weather);
    public List<Weather> getData(float lati,float longi);*/

}
