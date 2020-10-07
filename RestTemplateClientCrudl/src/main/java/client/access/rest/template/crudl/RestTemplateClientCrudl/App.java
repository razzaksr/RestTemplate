package client.access.rest.template.crudl.RestTemplateClientCrudl;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App {
	private static RestTemplate restTemplate = new RestTemplate();
	private static String url = "http://localhost:8080";

	public static void main(String[] args) {
		System.out.println("Welcome to Zealous Rest Template Crudl Illustration!");
		//App.demoExchange();// crudl via exchange
		//App.demoForEntity();// crudl via forEntity
		//App.demoForObject();// crudl via forObject
	}
	
	public static void demoForObject()
	{
		ForObjectCrudlDemo objectDemo=new ForObjectCrudlDemo();
		objectDemo.listAllByObjects();//list
		objectDemo.insert();//create
		objectDemo.read();//read
	}
	
	public static void demoForEntity()
	{
		// ForEntity Call demo
		ForEntityCrudlDemo entityDemo = new ForEntityCrudlDemo();
		entityDemo.listAll();
		entityDemo.listOne();
		entityDemo.add();
		entityDemo.update();
		entityDemo.remove();
	}

	public static void demoExchange() {
		HttpHeaders reqHead = new HttpHeaders();
		reqHead.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> reqEntity = new HttpEntity<Object>(reqHead);

		// App.getOneHubViaExchange(reqEntity);
		App.getAllHubViaExchange(reqEntity);

		
		 // For adding new one 
		//Hub hub1=new Hub("SabariRazak", 10, 20);
		//reqEntity=new HttpEntity<Object>(hub1,reqHead);
		//App.insertNewHubViaExchange(reqEntity);

		
		 // For update existing one 
		 //Hub hub1=new Hub(13,"Sheik", 11, 12);
		 //reqEntity=new HttpEntity<Object>(hub1,reqHead);
		 //App.updateExistingHubViaExchange(reqEntity);
		 

		
		 //delete hub object via Delete 
		//reqEntity=new HttpEntity<Object>(reqHead);
		//App.deleteHubViaExchange(reqEntity); App.getAllHubViaExchange(reqEntity);
	}

	public static void deleteHubViaExchange(HttpEntity<Object> entity) {
		// getting user number 5 as Object
		ResponseEntity<String> resEntity = restTemplate.exchange(url + "/delete/12", HttpMethod.DELETE, entity,
				String.class);
		System.out.println("Object request status: " + resEntity.getStatusCode());
		System.out.println("Received Name after Deletion: " + resEntity.getBody());
		System.out.println("Object response header: " + resEntity.getHeaders());
	}

	public static void updateExistingHubViaExchange(HttpEntity<Object> entity) {
		// getting user number 5 as Object
		ResponseEntity<Hub> resEntity = restTemplate.exchange(url + "/update", HttpMethod.PUT, entity, Hub.class);
		System.out.println("Object request status: " + resEntity.getStatusCode());
		System.out.println("Received object after Update: " + resEntity.getBody());
		System.out.println("Object response header: " + resEntity.getHeaders());
	}

	public static void insertNewHubViaExchange(HttpEntity<Object> entity) {
		// getting user number 5 as Object
		ResponseEntity<Hub> resEntity = restTemplate.exchange(url + "/pass", HttpMethod.POST, entity, Hub.class);
		System.out.println("Object request status: " + resEntity.getStatusCode());
		System.out.println("Received object after insertion: " + resEntity.getBody());
		System.out.println("Object response header: " + resEntity.getHeaders());
	}

	public static void getOneHubViaExchange(HttpEntity<Object> entity) {
		// getting user number 5 as Object
		ResponseEntity<Hub> resEntity = restTemplate.exchange(url + "/5", HttpMethod.GET, entity, Hub.class);
		System.out.println("Object request status: " + resEntity.getStatusCode());
		System.out.println("Received object: " + (Hub) resEntity.getBody());
		System.out.println("Object response header: " + resEntity.getHeaders());
	}

	public static void getAllHubViaExchange(HttpEntity<Object> entity) {
		// getting user number 5 as Object
		ResponseEntity<List> resEntity = restTemplate.exchange(url + "/", HttpMethod.GET, entity, List.class);
		System.out.println("Object request status: " + resEntity.getStatusCode());
		System.out.println("Received object: " + resEntity.getBody());
		System.out.println("Object response header: " + resEntity.getHeaders());
	}
}
