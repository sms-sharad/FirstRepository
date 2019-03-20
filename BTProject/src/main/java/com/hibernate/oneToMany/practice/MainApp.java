package com.hibernate.oneToMany.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication
//@EnableJpaAuditing
public class MainApp implements CommandLineRunner{

	@Autowired
	TeamPlayerServiceImpl teamPlayerServiceImpl;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	
	@Override
    public void run(String... arg0) throws Exception {
		
		Student stud=new Student("Kiran");
		studentRepository.save(stud);
		Team t=new Team("India");
		teamRepository.save(t);
		
		Long id=teamRepository.findByPlayers(1);
		System.out.println(":::"+id);
		Team t1=new Team();
		t1.setId(id);
		Player p=new Player("KiranKawade", 10, "MidFielder",t1);
		playerRepository.save(p);
		
		/*teamPlayerServiceImpl.addPlayer("Kiran Kawade", "Midfielder", 6,t);
        List<String> players = teamPlayerServiceImpl.getAllTeamPlayers(1l);
        for(String player : players)
        {
            System.out.println("Introducing Barca player => " + player);
        }*/
    }
}
