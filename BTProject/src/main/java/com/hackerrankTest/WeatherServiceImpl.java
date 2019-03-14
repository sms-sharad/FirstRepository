package com.hackerrankTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	WeatherRepository wrepository;
	
	
	@Override
	public void earase() {
		wrepository.deleteAll();
	}

	@Override
	public Weather earaseByParam(Date startDate, Date endDate, float lati, float longi) {
		return null;
	}

	@Override
	public Weather addData(Weather weather) {
		return wrepository.save(weather);
	}

	@Override
	public List<Weather> getData(float lati, float longi) {
		return null;
	}

	@Override
	public List<Weather> getAllData() {
		List<Weather> list=new ArrayList<>();
		wrepository.findAll().forEach(e -> list.add(e));
		return list;
	}

}
