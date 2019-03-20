package com.hibernate.oneToMany.practice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="team_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
	//@SequenceGenerator(name = "team_generator", sequenceName = "TEAM_SEQ")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
	private List<Player> players;

	public Long getId() {
		return id;
	}

	public Team(String name) {
		super();
		this.name = name;
	}

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
