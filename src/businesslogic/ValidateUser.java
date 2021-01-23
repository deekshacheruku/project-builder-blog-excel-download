package businesslogic;



public class ValidateUser {


	public boolean validate(String email, String password) {
		if (email == null || password == null)
			return false;
	
		if(email.equals("admin") && password.equals("admin"))
			return true;
		else 
			return false;
	}

}
