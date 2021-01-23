package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation {
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private Pattern pattern;
	  private Matcher matcher1,matcher2;
	  
	  
	public boolean checkUserDetails(String email,String password,String confirmPassword) {
		if (email == null || password == null || confirmPassword == null || email.length() == 0 || confirmPassword.length()==0 || password.length() == 0)
			return false;
		System.out.println("Enter check your details");
		if(validEmail(email) && validPassword(password,confirmPassword))
			return true;
		else
			return false;
	}

	private boolean validPassword(String password, String confirmPassword) {
		if (confirmPassword == null || password == null || password.length() == 0 || confirmPassword.length() == 0)
			return false;
		
		 pattern = Pattern.compile(PASSWORD_PATTERN);
		 if(password.equals(confirmPassword)) {
		 
		 matcher1 = pattern.matcher(password);
		 matcher2 = pattern.matcher(confirmPassword);
		 System.out.println(matcher1);
		 System.out.println(matcher2);
		  return (matcher2.matches() && matcher1.matches());
		 }
		return false;
		 
	}

	private boolean validEmail(String email) {
		if(email.length() == 0 || email == null)
			return false;
		
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 System.out.println("Enter email validation");
		 return email.matches(regex);
	}
	
	
}
