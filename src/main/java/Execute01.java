import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Step: Registration to the driver
        //1.Step: Do import, it is like having phone machine
        Class.forName("org.postgresql.Driver");

        //2. Step: Create connection with database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "merve2018");

        //3. Step: Create statement
        Statement st = con.createStatement();
        System.out.println("Connection Success");

        /*
        execute() method can be used in DDL(Table creation, drop table,alter table) and DQL(SELECT)
        1)If you use execute() method in DDL you will get false everytime
        2)If you use execute() method in DQL you will get true or false everytime
          When you use execute() method in DQL, if you get ResultSet Object as return,
          you will get true otherwise you will get false.
         */

        //4. Step: Execute the query

        //1.Example: Create a workers table with the columns worker_id,worker_name, worker_salary
        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(20), worker_salary INT)";
        boolean result =st.execute(sql1);
        System.out.println(result);

//        //2.Example: Alter table by adding worker_address column into the workers table
//        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
//        st.execute(sql2);
//
//        //3. Example: Drop the table
//        String sql3 = "DROP TABLE workers";
//        st.execute(sql3);







        //5. Step: Close the connection and statement
        //Close the phone
        con.close();
        st.close();

    }
}
