package com.hackerrankTest;

import java.util.Date;
import java.util.List;

public interface WeatherService {
	
	 	public void earase();
	 	//@Query("Delete from Weather where dateRecorded between :startDate and :endDate ")
	    public Weather earaseByParam(Date startDate,Date endDate,float lati,float longi);
	    public Weather addData(Weather weather);
	    public List<Weather> getData(float lati,float longi);
	    public List<Weather> getAllData();

}
