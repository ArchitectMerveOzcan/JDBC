import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        //On SQL Developer by typing "SHOW CONNECTION" you can find the url.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "merve2018");

        Statement st = con.createStatement();

        //1.Example: Select the country names whose region id's are 1
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
        //If you use execute method, you will get true or false but i wanna see the records.
        boolean r1 = st.execute(sql1);
        System.out.println("execute() methods returned " + r1 + " for select query");

        //To see the records we have another method which is "executeQuery()"
        ResultSet result1 = st.executeQuery(sql1);

        while(result1.next()) {
            System.out.println(result1.getString("country_name"));
        }
        //2.Example: Select the country_id and country_name whose region_id's are greater than 2
        String sql2 = "SELECT country_id,country_name FROM countries WHERE region_id>2";
        ResultSet result2 = st.executeQuery(sql2);

        while(result2.next()){
            System.out.println(result2.getString("country_id") + " --> "+result2.getString("country_name"));
        }

        //3.Example: Select all columns whose number_of_employees is the lowest from companies table
        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resultSet3 = st.executeQuery(sql3);

        while (resultSet3.next()){

            System.out.println(resultSet3.getInt(1)+" "+resultSet3.getString(2)+" "+resultSet3.getInt(3));

        }

        con.close();
        st.close();
        result1.close();



    }
}
