package Bean;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Consommation.UserConsommation;
import tn.esprit.imputation.entity.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private List<User> users = new ArrayList<User>();
	
	@EJB
	private UserConsommation dcr;
	
	
	public List<User> getUsers() {

		return users;
	}	
	

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@PostConstruct
	public void init() {
		users = dcr.consomation();
	}
}
 
