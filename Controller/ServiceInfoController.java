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

import study.springboot.cws.Entity.ServiceInfoEntity;
import study.springboot.cws.repository.ServiceInfoRepository;

@RestController
@RequestMapping("/cws3")
public class ServiceInfoController {

	@Autowired
	ServiceInfoRepository serrp;
	
	
	@GetMapping("/getServices")
	public List<ServiceInfoEntity> getService()
	{
		return serrp.findAll();
		
	}
	
	
	@PostMapping("/addService")
	public String addService(@RequestBody ServiceInfoEntity ser1 )
	{
		ServiceInfoEntity ser= new ServiceInfoEntity(ser1.getId(),ser1.getProvider_id(),ser1.getService_name(),ser1.getService_charges(),ser1.getProvider_time(),ser1.getNumberof_service_perday());
		serrp.save(ser);
		return "ServiceAdded";
		
	}
	
	@DeleteMapping("/deleteById/{serviceId}")
	public String deleteService (@PathVariable int serviceId)
	{
		serrp.deleteById(serviceId);
		return "deleted";
		
	}
	

	@PutMapping("/updateService/{id}/{serviceName}")
	  public String updateService(@PathVariable int id ,@PathVariable String serviceName )
	  {
		  List<ServiceInfoEntity> list = serrp.findAll();
		 for(ServiceInfoEntity service :list)
		 {
		  if(service.getId()==id)
		  {
			  service.setService_name(serviceName);
		  }
		 }
	    serrp.saveAll(list);
	    return "change done";	 
	  }
	
	
}
