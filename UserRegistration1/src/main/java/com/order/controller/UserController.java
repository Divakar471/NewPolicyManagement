package com.order.controller;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.order.model.Agent;
import com.order.model.Underwritter;
import com.order.repo.AgentRepository;
import com.order.repo.UnderWritterRepository;
import com.order.service.Productimplementation;

@Controller
public class UserController 
{
	@Autowired
	UnderWritterRepository urepo;
	
	@Autowired
	AgentRepository arepo;
	
	@Autowired
	private Productimplementation productImplementation;
	
	@RequestMapping("/accept")
	public String homeworld()
	{
		return "accept";
	}
	
	@RequestMapping("/reject")
	public String reject()
	{
		return "reject";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/underwritter_registration")
	public String getSignupUnderwritter()
	{
		return "underwritter_registration";
	}
	
	@RequestMapping("/agent_registration")
	public String getSignupAgent()
	{
		return "agent_registration";
	}
	
	@RequestMapping("/dashboard")
	public String getDashboard() {
		return "dashboard";
	}
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	@RequestMapping("/agent_login")
	public String getAgentLogin()
	{
		return "agent_login";
	}
	
	
	@PostMapping("/addUnderwritter")
	public ModelAndView addUnderWritter(@RequestParam("user_email") String user_email, Underwritter user)
	{
		ModelAndView mv=new ModelAndView("success");
		List<Underwritter> list=urepo.findByEMAIL(user_email);
		
		if(list.size()!=0)
		{
		mv.addObject("message", "Oops!  There is already a user registered with the email provided.");
		
		}
		else
		{
		urepo.save(user);
		mv.addObject("message","UnderWritter has been successfully registered");
		}
		
		return mv;
	}
	
	@PostMapping("/addAgent")
	public ModelAndView addAgent(@RequestParam("user_email") String user_email, Agent user)
	{
		ModelAndView mv=new ModelAndView("success");
		List<Agent> list= arepo.findByEMAIL(user_email);
		
		if(list.size()!=0)
		{
		mv.addObject("message", "Oops!  There is already a user registered with the email provided.");
		
		}
		else
		{
		arepo.save(user);
		mv.addObject("message","Agent has been successfully registered ,Your agency_code is:"+user.getUser_id());
		}
		
		return mv;
	}
	
	
	@GetMapping("/dummy")
	public String dummy()
	{
		return "dummy";
	}
	
	@PostMapping("/login")
	public String login_user(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpSession session,ModelMap modelMap)
	{
		
	Underwritter auser=urepo.findByUsernamePassword(username, password);
	
	if(auser!=null)
	{
		String uname=auser.getUser_email();
		String upass=auser.getUser_pass();
	
		if(username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) 
		{
			session.setAttribute("username",username);
			return "underwritter_policy";
		}
		else 
		{
			modelMap.put("error", "Invalid Account");
			return "login";
		}
	}
	else
	{
		modelMap.put("error", "Invalid Account");
		return "login";
	}
	
	}
	
	@PostMapping("/agent_login")
	public String login_agent(@RequestParam("agency_code") Integer user_id,
			HttpSession session,ModelMap modelMap)
	{
		
		Agent auser=arepo.findByToken(user_id);
	
	if(auser!=null)
	{
		
			session.setAttribute("username",user_id.toString());
			return "agent_policy";
		
	}
	else
	{
		modelMap.put("error", "Invalid Account");
		return "agent_login";
	}
	}
	
	

	
	
	
	
	
	
	
	@GetMapping(value = "/logout")
	public String logout_user(HttpSession session)
	{
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/home";
	}
	
	
	
}
