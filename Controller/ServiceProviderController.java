package study.springboot.cws.controller;
import study.springboot.cws.Entity.ServiceProviderEntity;
import study.springboot.cws.repository.ServiceProviderRepository;

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



@RestController
@RequestMapping("/cws")
public class ServiceProviderController {
	
	@Autowired
	ServiceProviderRepository ser;
	
	@GetMapping("/getAll")
	public List<ServiceProviderEntity> getAllServiceProviders()
	{
		return ser.findAll();

	}
	
	@GetMapping("/getElectricians/{role}")
	public List<ServiceProviderEntity> getElectricians(@PathVariable String role)
	{
		return ser.findByRole(role);
	}
	//problem in register
	@PostMapping("/register") 
	public String register(@RequestBody ServiceProviderEntity sp1)
	{
		ServiceProviderEntity sp=new ServiceProviderEntity(sp1.getId(),sp1.getFirstName(),sp1.getLastName(),sp1.getRole(),sp1.
				  getMobile(),sp1.getUserName(),sp1.getPassword(),sp1.getEmailId(),sp1.getCity(
						  ),sp1.getIsVerified());
		ser.save(sp);
		return "inserted";
		
	}
	
	@PostMapping("/login/{eid}/{pwd}")
	public ServiceProviderEntity Loging(@PathVariable String eid,@PathVariable String pwd)
	{
		ServiceProviderEntity sp1 = ser.checkLogin(eid, pwd);
		if (sp1!=null)
		{
			return sp1;
		}
		return null;
	}
	
	@PutMapping("/update/{id}/{isVarified}")
	public String updateVerification(@PathVariable int id,@PathVariable boolean isVerified)
	{
		List<ServiceProviderEntity> list=ser.findAll();
		
		for(ServiceProviderEntity service : list)
		{
			if(service.getId()==id)
			{ 
				service.setIsVerified(isVerified);
			}
			ser.saveAll(list);
		}
		return "chenges Succrssfull";
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeletebyId(@PathVariable int id)
	{
		ser.deleteById(id);
		return "deleted";
	}
	
	/*
	@PostMapping("/login/{email}/{pwd}")
	public ServiceProviderEntity checkLogin(@PathVariable String email,@PathVariable String pwd)
	{
		return ser.checkLogin(email, pwd);
	} 
	*/
	
	
	
	
}







