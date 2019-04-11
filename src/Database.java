import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.io.*;

public class Database {
	 private static final int BUFFER_SIZE = 4096;


	public static void main(String args[]) throws Exception{
		String db="jdbc:mysql://localhost:3306/DataFiles";
		String username="root";
		String password="rakki";
		String filepath="/home/rakshith/eclipse-workspace/OOADPJAVA/src/a.txt2";
		Connection con=DriverManager.getConnection(db,username,password);
		String filename="/home/rakshith/eclipse-workspace/OOADPJAVA/src/a.txt";
		File file=new File(filename);
		FileInputStream fis=new FileInputStream(file);
		PreparedStatement ps=con.prepareStatement("insert into datafiles1 (id,password,filename,file) values(?,?,?,?)");
	    ps.setInt(1,35);
	   	ps.setInt(2, 12);
	    ps.setString(3, "Nande");
		ps.setAsciiStream(4, fis);
		ps.executeUpdate();
		Statement st=con.createStatement();
	    String query="select filename from datafiles1 ";
	    ResultSet rs=st.executeQuery(query);
	    /* while(rs.next())
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
           System.out.println("File saved");
	    	
	    
		*/
	    ArrayList<String> arrayList=new ArrayList<String>();
	    while(rs.next())
	    {
	    	
	    	arrayList.add(rs.getString("filename"));
	    }
	    for(String a:arrayList)
	    {
	    	System.out.println(a);
	    }
	}
	
	
	

	}


