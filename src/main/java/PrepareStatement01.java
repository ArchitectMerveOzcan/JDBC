import java.sql.*;

public class PrepareStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "merve2018");

        Statement st = con.createStatement();

        //1.Example: Update the number of employees to 9999 if the company name is IBM by using prepared statement
        //1. Step: Create Prepared Statement Query
        String sql1= "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        //2.Step: Create PreparedStatement Object
        PreparedStatement pst1 = con.prepareStatement(sql1);
        //3.Step: Set the values for ? marks
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        int numOfUpdateRecs = pst1.executeUpdate();
        System.out.println(numOfUpdateRecs + " rows updated");

        String sql2= "SELECT * FROM companies" ;
        ResultSet result1 = st.executeQuery(sql2);

        while(result1.next()){
            System.out.println(result1.getInt(1) + " - " + result1.getString(2 ) + " - " +result1.getInt(3));
        }

        pst1.setInt(1, 1111);
        pst1.setString(2, "GOOGLE");

        int numOfUpdateRecs2 = pst1.executeUpdate();
        System.out.println(numOfUpdateRecs2 + " rows updated");

        String sql3= "SELECT * FROM companies" ;
        ResultSet result2 = st.executeQuery(sql3);

        while(result2.next()){
            System.out.println(result2.getInt(1) + " - " + result2.getString(2 ) + " - " +result2.getInt(3));
        }






        con.close();
        st.close();
        result1.close();
        result2.close();
    }
}
