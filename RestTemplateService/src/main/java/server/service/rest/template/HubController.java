package server.service.rest.template;

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
public class HubController 
{
	@Autowired
	RepoHub rep;
	
	// Listing All
	@GetMapping("/")
	public List<Hub> doAll()
	{
		return rep.findAll();
	}
	
	// read by id
	@GetMapping("/{id}")
	public Hub one(@PathVariable("id") long id)
	{
		return rep.findById(id).orElse(new Hub());
	}
	
	// insertion/ create
	@PostMapping("/pass")
	public Hub insert(@RequestBody Hub hub)
	{
		return rep.save(hub);
	}
	
	// Update
	@PutMapping("/update")
	public Hub change(@RequestBody Hub hub)
	{
		return rep.save(hub);
	}
	
	// delete
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable("id") long id)
	{
		Hub hub=rep.findById(id).get();
		String name=hub.getHubName();
		rep.delete(hub);
		return name;
	}
}
