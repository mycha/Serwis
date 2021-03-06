
import java.sql.*;
import java.util.*;
public class MySQL{
	
	private Statement stmt = null;
	private Connection conn = null;
	private String user = null;
	private int ID = 0;
	public MySQL(String name){
		user = name;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "serwis";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);	
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResultSet rs;
			//pobranie ID Klienta kt�ry aktualnie si� zalogowa� OK
		try {
				System.out.println(name);
				rs = stmt.executeQuery("Select * from client where client_name = '"+name+"'");
				
				while(rs.next())
					ID = rs.getInt("client_id");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

		
		
}
public String getPassword(){//Pobranie has�a dla klienta OK
	ResultSet rs;
	String password = null;
	try {
		rs = stmt.executeQuery("Select * from client_password where client_id = '"+ID + "'");
		while(rs.next())
			password = rs.getString("password");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return password;
}
public List<String> Command(String command) throws SQLException{
	//W tej klasie s� wykonywane wszystkie zapytania do bazy MySQL
	
	List<String> Wynik = new Vector<String>();
	
			ResultSet rs = stmt.executeQuery(command);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			
			Wynik.add(Integer.toString(columnNumber));
			//wyswietlanie nazw kolumn:
            for (int i = 1; i <= columnNumber; i++) { 
            	Wynik.add(rsmd.getColumnLabel(i)) ;
            	 ;
             System.out.print(rsmd.getColumnLabel(i) +"  |  "); 
             
            }
            System.out.print("\n------------------------------------\n");

            //wyswietlanie kolejnych rekordow:
            while (rs.next()) {
                for (int i = 1; i <= columnNumber; i++) {
               	   	 Object obj = rs.getObject(i);
                     if (obj != null){
                    	 System.out.print(obj.toString()+ " | ");
                    	 Wynik.add(obj.toString());
                     }
                     else  System.out.print(" ");
                   }
        
                System.out.println();
            }
			System.out.println(Wynik);
	
	return Wynik;
 	}
	
public void Close() throws SQLException{
	conn.close();
}



}