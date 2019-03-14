package com.hackerrankTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiRestController  {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping("weather")
	public ResponseEntity<List<Weather>> getAllWeathers() {
		List<Weather> list = weatherService.getAllData();
		return new ResponseEntity<List<Weather>>(list, HttpStatus.OK);
	}
	@PostMapping("weather")
	public ResponseEntity<Void> addWeather(@RequestBody Weather Weather) {
                //boolean flag = 
                	weatherService.addData(Weather);
               /* if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/Weather/{id}").buildAndExpand(Weather.getId()).toUri());*/
                return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/erase")
	public ResponseEntity<Void> deleteWeather() {
		weatherService.earase();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	

}
