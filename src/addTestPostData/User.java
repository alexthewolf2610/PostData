package addTestPostData;


public class User {
	
	//The attributes are defined as public so that they can be accessed from the manage_students view.
	public Long id;
	public Long roleID;
	public String email;
	
	
	public User(Long id, Long roleID, String email) {
		super();
		this.id = id;
		this.roleID = roleID;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getRoleID() {
		return roleID;
	}


	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
