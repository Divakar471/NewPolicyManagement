package com.order.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.model.Underwritter;

public interface UnderWritterRepository extends JpaRepository<Underwritter, Integer> {
	
	@Query("from Underwritter where user_email=?1")
	public List<Underwritter> findByEMAIL(String email);
	
	
	@Query("from Underwritter where user_email=?1 and user_pass=?2")
	public Underwritter findByUsernamePassword(String username,String password);

}
