import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "merve2018");

        Statement st = con.createStatement();

        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1 = "UPDATE companies " +
                "SET number_of_employees = 16000 " +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies)";
        int numOfRecUpdated1 = st.executeUpdate(sql1);
        System.out.println(numOfRecUpdated1 + " rows updated");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()){
            System.out.println(result1.getInt(1) +" - " + result1.getString(2)+ " - " + result1.getInt(3));
        }






        con.close();
        st.close();
        result1.close();



    }
}
