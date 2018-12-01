import java.sql.*;  
class InfoRetreval{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
//here AppInformation is database name, root is username and password
    try (Connection con = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/AppInformation","root","password")) {
        //here AppInformation is database name, root is username and password is password
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
    }
}catch(ClassNotFoundException | SQLException e){ System.out.println(e);}
}
}  