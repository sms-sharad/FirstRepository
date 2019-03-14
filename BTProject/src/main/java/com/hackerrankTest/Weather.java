package com.hackerrankTest;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="weather")
public class Weather {
	
		@Id
    	@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
		@Temporal(TemporalType.DATE)
	    @Column(name = "dateRecorded", nullable = false)
	    private Date dateRecorded;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "location_id", referencedColumnName = "id")
	    private Location location;
	    
	    @Column(name = "temperature", length = 100)
	    private Float[] temperature;

	    public Weather() {
	    }

	    public Weather(Long id, Date dateRecorded, Location location, Float[] temperature) {
	        this.id = id;
	        this.dateRecorded = dateRecorded;
	        this.location = location;
	        this.temperature = temperature;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Date getDateRecorded() {
	        return dateRecorded;
	    }

	    public void setDateRecorded(Date dateRecorded) {
	        this.dateRecorded = dateRecorded;
	    }

	    public Location getLocation() {
	        return location;
	    }

	    public void setLocation(Location location) {
	        this.location = location;
	    }

	    public Float[] getTemperature() {
	        return temperature;
	    }

	    public void setTemperature(Float[] temperature) {
	        this.temperature = temperature;
	    }
}
