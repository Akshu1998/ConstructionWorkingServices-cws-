package study.springboot.cws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.springboot.cws.Entity.CustomerEntity;
import study.springboot.cws.repository.CustomerRepository;

@RestController
@RequestMapping("/cws1")
public class CustomerController {
	
	@Autowired
	CustomerRepository cus;
	
	@GetMapping("/getAllCustomers")
	public List<CustomerEntity> getAllServiceProviders()
	{
		return cus.findAll();
		
	}
	
	@PostMapping("/registerCustomer")
	public String register(@RequestBody CustomerEntity c)
	{
		CustomerEntity c1=new CustomerEntity (c.getId(),c.getFirstName(),c.getLastName(),c.getMobile(),c.getEmailId(),c.getUserName(),c.getPassword(),c.getAddress());
		cus.save(c1);
		return "customer inserted";
		
	}
	
	@PostMapping("/login/{eid}/{pwd}")
	public CustomerEntity Login(@PathVariable String eid, @PathVariable String pwd)
	{
		CustomerEntity sp1 = cus.checkLogin(eid,pwd);
		if(sp1!= null)
		{
			return sp1;
		}
		return null;	
	}
	
	@PutMapping("/changePass/{email}/{oldpwd}/{newpwd}")
	public String changePassword(@PathVariable String email,@PathVariable String oldpwd,@PathVariable String newpwd)
	{
		CustomerEntity u=cus.findByEmailId(email);
		if(u!=null)
		{
			if(u.getPassword().equals(oldpwd))
			{
				u.setPassword(newpwd);
				System.out.println(u.getFirstName());
				cus.save(u);
				return "Password changed";
			}
		}
		return "Incorrect Credentials";
		
	}
	
	 @DeleteMapping("/delete/{id}")
     public String deleteCustomer(@PathVariable int id)
     {
		  cus.deleteById(id);
		  return "Deleted Customer";
     }	
	
	

}
