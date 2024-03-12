package edu.jsp.taskmanager.Connectionpool;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Connectionpool {
	
       private static final int POOL_SIZE=10;
       private static List<Connection> connections = new ArrayList<>();
       
       static {
    	   try {
    		   for(int i=0;i<POOL_SIZE;i++) {
    			   if(connections.size() <= POOL_SIZE) {
    				   Connection connection = createConnection();
    				   if(connection !=null) {
    					   connections.add(connection);
    				   }
    			   }
    		   }
    		   System.out.println("POOL INITIALIZED CURRENT POOL SIZE : "+ connections.size());
    	   }catch (Exception exception) {
    		   System.out.println("INTERNAL POOL ERROR");
    	   }
       }
       
       
       private static Connection createConnection() throws Exception{
    	   FileInputStream stream = new FileInputStream("src/config.properties");
    	   
    	   Properties properties = new Properties();
    	   
    	   properties.load(stream);
    	   
    	   Class.forName(properties.getProperty("driverpath"));
    	   return DriverManager.getConnection(properties.getProperty("dburl"),properties);
       }
       
       public static void receiveConnection(Connection connection) throws Exception{
    	   if(connections.size()>=POOL_SIZE) {
    		   connection.close();
    		   System.out.println("CONNECTION RECEIVED CURRENT POOL SIZE : "+ connections.size());
    	   } else {
    		   connections.add(connection);
    		   System.out.println("CONEECTION RECEIVED CURRENT POOL SIZE :"+connections.size());
    	   }
       }
       
       public static Connection getConnection() throws Exception{
    	   if(connections.isEmpty()) {
    		   System.out.println("POOL IS EMPTY CREATING CONNECTION....PLEASE WAIT..");
    		   return createConnection();
    	   }
    	   else {
    		   System.out.println("CURRENT POOL SIZE :"+ (connections.size()-1));
    		   return connections.remove(0);
    	   }
       }
	  
}
