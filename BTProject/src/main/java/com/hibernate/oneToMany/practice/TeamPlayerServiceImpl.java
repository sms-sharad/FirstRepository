package com.hibernate.oneToMany.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayerServiceImpl implements TeamPlayerService{
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public List<String> getAllTeamPlayers(Long teamId) {/*
		List<String> lst = new ArrayList<>();
		Team t = teamRepository.findByPlayers(teamId);
		List<Player> list = t.getPlayers();
		for (Player p : list) {
			lst.add(p.getName());
		}
		return lst;
	*/
		return null;}

	@Override
	public void addPlayer(String name, String position, int num,Team t) {
		
		
		/*Iterable<Team> itr= teamRepository.findAll();
		Long id = null;
		for(Team t:itr){
			id=t.getId();
		}*/
		/*Team t=new Team("India");
		teamRepository.save(t);*/
		
		//System.out.println("Team ID:: "+id);
		
		
		/*Player p=new Player();
		p.setName(name);
		p.setPosition(position);
		p.setNum(num);
		p.setTeam(t);
		playerRepository.save(p);*/
	}
}
