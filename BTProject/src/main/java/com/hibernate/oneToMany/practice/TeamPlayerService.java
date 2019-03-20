package com.hibernate.oneToMany.practice;

import java.util.List;

public interface TeamPlayerService {
	
	public List<String> getAllTeamPlayers(Long teamId);
	public void addPlayer(String name,String position,int num,Team t);
}
