package utilities;

import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig  {

    Properties pro;

    public ReadConfig(){
        File src= new File("src/main/resources/prepod.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro=new Properties();
            pro.load(fis);

        }
        catch (Exception e){
         System.out.println(e.getMessage());
        }

    }
    public String getApplicationURL(){
        String url= pro.getProperty("url");
        return url;
    }
    public String getUserName(){
        String username=pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String password = pro.getProperty("password");
        return password;
    }
    public String getGooglepath(){
        String googlepath=pro.getProperty("googlepath");
        return googlepath;
    }
    public String getfireFoxpath(){
        String firefoxpath=pro.getProperty("firefoxpath");
        return firefoxpath;

    }
    public String getName(){
        String name=pro.getProperty("name");
        return name;
    }
    public String getAddress(){
        String Address=pro.getProperty("address");
        return Address;
    }
    public String getCity(){
        String city=pro.getProperty("city");
        return city;
    }
    public String getState(){
        String State=pro.getProperty("state");
        return State;
    }
    public String getPincode(){
        String Pincode=pro.getProperty("pincode");
        return Pincode;
    }
    public String getTelephone(){
        String Telephone=pro.getProperty("telephone");
        return Telephone;
    }
    public String getEmail(){
        String Email=pro.getProperty("email");
        return Email;
    }


}
