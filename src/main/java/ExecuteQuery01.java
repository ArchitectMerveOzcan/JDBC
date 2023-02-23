import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "merve2018");

        Statement st = con.createStatement();

        //Find the name and salary of the worker whose salary is the second highest from the workers table.
        //1.Way
        String sql1 = "SELECT company, number_of_employees " +
                "FROM companies" +
                " ORDER BY number_of_employees " +
                "DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";
        ResultSet result1 = st.executeQuery(sql1);

        while (result1.next()) {
            System.out.println(result1.getString(1)+ " --> " +result1.getInt(2));
        }
        //2.Way
        String sql2 = "SELECT company, number_of_employees\n" +
                "FROM companies \n" +
                "WHERE number_of_employees = (SELECT MAX(number_of_employees) \n" +
                "\t\t\t\t\t\t\t FROM companies \n" +
                "\t\t\t\t\t\t\t WHERE number_of_employees < (SELECT MAX(number_of_employees) \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  FROM companies))";
        ResultSet result2 = st.executeQuery(sql2);

        while (result2.next()) {
            System.out.println(result2.getString(1)+ " --> " +result2.getInt(2));
        }
        //2.Example: Find the company names and number of employees whose number of employees is less than the average number of employees
        String sql3 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees)\n" +
                "\t\t\t\t\t\t\tFROM companies)";
        ResultSet result3 = st.executeQuery(sql3);

        while (result3.next()){
            System.out.println(result3.getString(1) + " --> " +result3.getString(2));

        }





        con.close();
        st.close();
        result1.close();
        result2.close();
        result3.close();









        con.close();
        st.close();

    }
}
