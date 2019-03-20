package com.hibernate.oneToMany.practice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

	@Query("from team t where t.team_id=:team_id")
	Long findByPlayers(@Param("team_id") long playerId);
}
