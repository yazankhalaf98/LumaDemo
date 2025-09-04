package utils;

import java.util.Random;

public class TestData {
	
	
	
	 static Random rand = new Random();

	    public static String getRandomFirstName() {
	        String[] names = {"Yazan", "Ali", "Hasan", "mais", "dareen"};
	        return names[rand.nextInt(names.length)];
	    }

	    public static String getRandomLastName() {
	        String[] names = {"alaa", "saif", "abduallah", "hamzeh", "marwan", "abedalrahman", "omar","yazan"};
	        return names[rand.nextInt(names.length)];
	    }

	    public static String getEmail(String first, String last) {
	        return first + last + rand.nextInt(7000) + "@gmail.com";
	    }

	    public static String getRandomUsername(String first, String last) {
	        return first + last + rand.nextInt(7000);
	    }
	    public static String getRandomPass( ) {
	        String[] password = {"alaa@45", "saif1998", "abduallah09", "hamzeh66", "marwan666", "abedalrahman6544", "omar123","yazan98"};
	        return password[rand.nextInt(password.length)];
	    
	    }


}
