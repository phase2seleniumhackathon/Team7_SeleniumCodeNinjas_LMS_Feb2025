package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // Define the path to the config.properties file
    private static String propertyFilePath = "src/test/resources/TestData/config.properties";

    // Properties object to store the configuration
    private static Properties properties;

    // Static initializer to load the config.properties file
    static {
        properties = new Properties();
        try {
            // Create a FileInputStream to read the config.properties file
            FileInputStream fis = new FileInputStream(new File(propertyFilePath));
            // Load the properties from the file into the Properties object
            properties.load(fis);
            // Close the FileInputStream
            fis.close();
        } catch (IOException e) {
            // Handle any errors that occur while loading the properties
            System.err.println("Error reading config.properties file: " + e.getMessage());
        }
    }

    //Method to retrieve dsalgo base url
	public static String getApplicationUrl(String key) {
		String url = properties.getProperty(key);
		System.out.println(url);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	// UserName
    public static String userName()
    {    	
    	 String loginUserName=properties.getProperty("username");
    	 if (loginUserName != null)
		    return loginUserName;
    	 else 
    		 throw new RuntimeException("Username not specified in the Config.properties file");
    }
    
    // Password
    public static String passWord()
    {    	
    	 String loginPassword=properties.getProperty("password");
    	 if (loginPassword != null)
		    return loginPassword;
    	 else 
    		 throw new RuntimeException("Password not specified in the Config.properties file");
    }
    public static String getProgName() {
    	String prgName = properties.getProperty("programName");
		return prgName;
    	
    }
    public static String getBatchName() {
    	String batchName = properties.getProperty("batchName");
		return batchName;    	
    }
    public static  String getBatchDesc() {
    	String bDesc = properties.getProperty("batchDesc");
		return bDesc;    	
    }
    public static String getNoOfClasses() {
    	String noOfClasses = properties.getProperty("NoOfClasses");
    	return noOfClasses;
    }
    public static String getBatchStatus() {
    	String status = properties.getProperty("batchStatus");
    	return status;
    }
    public static String getEditBatchDesc() {
    	String desc = properties.getProperty("editBatchDescription");
    	return desc;
    }
    public static String getEditBatchClasses() {
    	String classes = properties.getProperty("editBatchNoOfClasses");
    	return classes;
    }
	public static String getBrowserType() {
		String browser = properties.getProperty("browser");
		System.out.println("Get property BrowserType");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}
	public static String getexcelfilepath() {
        String excelfilelpath = properties.getProperty("excelFilePath");
        if (excelfilelpath != null)
            return excelfilelpath;
        else
            throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
    }
	public static String geturl(String pagename) {
		
        String url = properties.getProperty(pagename);
        System.out.println(url);
        if (url != null)
            return url;
        else
            throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
    }
 //HomePageURL
    
    public static String HomePageURL()
    {    	
    	 String HomePageURL=properties.getProperty("homepageurl");
    	 if (HomePageURL != null)
		    return HomePageURL;
    	 else 
    		 throw new RuntimeException("Username not specified in the Config.properties file");
    }
	

}



















	

