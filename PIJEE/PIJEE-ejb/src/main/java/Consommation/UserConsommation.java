package Consommation;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;

import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import tn.esprit.imputation.entity.User; 



/**
 * Session Bean implementation class DemandeurConsom
 * @param <Meeting>
 */
@Stateless
@LocalBean
public class UserConsommation  implements UserConsommationRemote, UserConsommationLocal {

    /**
     * Default constructor. 
     */
    public UserConsommation() {
        // TODO Auto-generated constructor stub
    }

    public List<User> consomation()
    {
    	List<User>  lasp = new ArrayList<User>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6795/api/UserWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	System.out.println("erreuuur");
   
    	
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		User u = new User();
    	 
    	 u.setEmail(object.getJsonObject(i).get("Email").toString()); 
    	 u.setFirstName(object.getJsonObject(i).get("FirstName").toString());
    	 
    	 u.setLastName(object.getJsonObject(i).get("LastName").toString());

    	 u.setStatus(Integer.parseInt(object.getJsonObject(i).get("status").toString()));
    	
    	 lasp.add(u);
    	 
    	}
    	

    		return lasp;    	
    }
}



