package client.access.rest.template.crudl.RestTemplateClientCrudl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ForEntityCrudlDemo 
{
	private static RestTemplate template=new RestTemplate();
	private static String url="http://localhost:8080";
	
	public void listAll()
	{
		ResponseEntity<List> entity=template.getForEntity(url+"/", List.class);
		System.out.println("Object request status: "+entity.getStatusCode());
    	System.out.println("Received Objects: "+entity.getBody());
    	System.out.println("Object response header: "+entity.getHeaders());
	}
	public void listOne()
	{
		ResponseEntity<Hub> entity=template.getForEntity(url+"/11", Hub.class);
		System.out.println("Object request status: "+entity.getStatusCode());
    	System.out.println("Received after Reading one: "+entity.getBody());
    	System.out.println("Object response header: "+entity.getHeaders());
	}
	public void add()
	{
		Hub hub=new Hub("Maheshwaran", 100, 200);
		ResponseEntity<Hub> entity=template.postForEntity(url+"/pass",hub ,Hub.class);
		System.out.println("Object request status: "+entity.getStatusCode());
    	System.out.println("Received after adding one: "+entity.getBody());
    	System.out.println("Object response header: "+entity.getHeaders());
	}
	public void update()
	{
		Hub hub=new Hub(12,"Maheshwaran", 40, 20);
		template.put(url+"/update",hub);
		System.out.println(" Updated ");
		
	}
	public void remove()
	{
		template.delete(url+"/delete/11");
		System.out.println(" Deleted ");
	}
}