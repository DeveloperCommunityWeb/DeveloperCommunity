package configuration;

import java.util.regex.Pattern;

public class Validation {
	public static boolean isTextOnly(String str){
		String pattern="^[a-zA-Z]{1,50}$";
		if(Pattern.matches(pattern,str))return true;
		return false;
	}
	
	public static boolean isNumberOnly(String str){
		String pattern="^[0-9 ]{1,}$";
		if(Pattern.matches(pattern, str))return true;
		return false;
	}
	
	public static boolean isPassword(String str){
		String pattern="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
		if(Pattern.matches(pattern, str))return true;
		return false;
	}
	
	public static boolean isPhoneNumber(String str){
		String pattern="0[1-9]{1}[0-9]{7,8}";
		if(Pattern.matches(pattern, str))return true;
		return false;
	}
	
	public static boolean isDate(String str){
		String pattern="^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
		if(Pattern.matches(pattern, str))return true;
		return false;
	}
	
	public static boolean isEmail(String str){
		String pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(Pattern.matches(pattern, str))return true;
		return false;
	}
}
