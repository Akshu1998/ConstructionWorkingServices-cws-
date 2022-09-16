package study.springboot.cws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.springboot.cws.Entity.DisputeEntity;
import study.springboot.cws.repository.DisputeRepository;

@RestController
@RequestMapping("/csw/Dispute")
public class DisputeController {
	
	@Autowired
	DisputeRepository dispute;

	
	@GetMapping("/getAllDisputes")
	public List<DisputeEntity> getDispute()
	{
		return dispute.findAll();
	}
	
	@PutMapping("/updateDispute/{id}/{dispute_status}")
	public String updateStatus(@PathVariable int id , @PathVariable String dispute_status )
	{
		List<DisputeEntity> list= dispute.findAll();
		for(DisputeEntity d:list)
		{
			if(d.getId()==id)
			{
				d.setDispute_status(dispute_status);
			}
		}
		dispute.saveAll(list);
		return "Status Updated";
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteDispute(@PathVariable int id)
	{
		dispute.deleteById(id);
		return "dispute Deleted";
	}
	
	
	
}
