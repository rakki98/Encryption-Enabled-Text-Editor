package project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.io.*;

public class Database {
	        private static final int BUFFER_SIZE = 4096;
               
                private static   int count=1;
        public static Connection connection() throws Exception
        {       String db="jdbc:mysql://localhost:3306/DataFiles";
		String username="root";
		String password="rakki";
                Connection con=DriverManager.getConnection(db,username,password);
                return  con;
        }
        public static void output(String file,int pass) 
        {   try{ 
             Connection con=connection();
            String query="select file from datafiles1 where filename="+"'"+file + "'";
                    System.out.println(query);
          //  String query="select file from datafiles1 where filename=;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            String filepath="/home/rakshith/NetBeansProjects/Project/src/project/temp";
		
            while(rs.next())
	    {  Blob  bl=rs.getBlob("file");
	       InputStream inputStream = bl.getBinaryStream();  
	       OutputStream outputStream = new FileOutputStream(filepath);
	       int bytesRead = -1;
           byte[] buffer = new byte[BUFFER_SIZE];
           while ((bytesRead = inputStream.read(buffer)) != -1) {
               outputStream.write(buffer, 0, bytesRead);
	    
	    }
           
           inputStream.close();
           outputStream.close();
                    InputStream inStr=new FileInputStream("/home/rakshith/NetBeansProjects/Project/src/project/temp");
                    OutputStream outStr=new FileOutputStream("/home/rakshith/NetBeansProjects/Project/src/project/temp1",true);
	            encryption en;
                    en = new encryption(-pass);
	            en.encrypt(inStr,outStr);
                     
           inputStream.close();
           outputStream.close();
           System.out.println("File saved");
	    	 
           
        }
          
        }
        catch(Exception e){}
        }
        public static ArrayList filename() 
        {  
            ArrayList<String> files=new ArrayList<>(50);
        try
        {    Connection con=connection(); 
           
           String query="select filename from datafiles1";
           Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
	    {
	    	
	    	files.add(rs.getString("filename"));
	    }
        }
          catch(Exception e)
          {
          }
        
        return files;
        }
                
        public static void input(String filena,int password) 
        {      try
        {        Connection con=connection();
                String filename="/home/rakshith/NetBeansProjects/Project/"+filena+".enc";
		File file=new File(filename);
		FileInputStream fis=new FileInputStream(file);
                PreparedStatement ps=con.prepareStatement("insert into datafiles1 (id,password,filename,file) values(?,?,?,?)");
	       //  PreparedStatement ps=con.prepareStatement("insert into data (password,filename,file) values(?,?,?,?)");
	       
                ps.setInt(1,105); 
	   	ps.setInt(2,password);
	        ps.setString(3, filena);
		ps.setAsciiStream(4, fis);
		ps.executeUpdate();
        }
        catch(Exception e)
        {}
        
        }
	public static void main(String args[]) throws Exception{
		
		
		 
              // output("rakki",123);
               // input("raone",1234);
	    

	  /*  ArrayList<String> arrayList=new ArrayList<String>();
	    while(rs.next())
	    {
	    	
	    	arrayList.add(rs.getString("filename"));
	    }
	    for(String a:arrayList)
	    {
	    	System.out.println(a);
	    }
	}
	*/
	
	

	}
}


