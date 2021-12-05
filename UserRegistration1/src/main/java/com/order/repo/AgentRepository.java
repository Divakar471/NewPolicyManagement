package com.order.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.model.Agent;


public interface AgentRepository extends JpaRepository<Agent, Integer> {
	
	@Query("from Agent where agency_code=?1")
	public Agent findByToken(Integer agency_code);
	
	@Query("from Agent where user_email=?1")
	public List<Agent> findByEMAIL(String email);
	
	
	

}
