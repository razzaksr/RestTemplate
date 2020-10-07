package client.access.rest.template.crudl.RestTemplateClientCrudl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class ForObjectCrudlDemo 
{
	private static RestTemplate template=new RestTemplate();
	private static String url="http://localhost:8080";
	private Logger logger = LoggerFactory.getLogger(ForObjectCrudlDemo.class);
	
	public void listAllByObjects()
	{
		List got = template.getForObject(url+"/", List.class);
		logger.info("Repsonse from list all call - "+got);
	}
	public void removeByObject()
	{
		// which is same as forEntitycrudlDemo deletion
	}
	public void updateByObject()
	{
		// which is same as forEntitycrudlDemo update
	}
	public void insert()
	{
		Hub hub=new Hub("Annamalai", 10, 40);
		Hub got=template.postForObject(url+"/pass", hub,Hub.class);
		logger.info("Repsonse from insert call - "+got);
	}
	public void read()
	{
		Hub got=template.getForObject(url+"/9",Hub.class);
		logger.info("Repsonse from read call - "+got);
	}
}
