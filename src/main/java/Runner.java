public class Runner {
    public static void main(String[] args) {
        //1. Step: Registration to the driver
        //2. Step: Create connection with database
        JdbcUtils.connectToDatabase("localhost","Techpro","postgres","merve2018" +
                "");

        //3. Step: Create statement
        JdbcUtils.createStatement();

        //4. Step: Execute the query
        JdbcUtils.createTable("School", "teachers VARCHAR(50)", "name VARCHAR(80)", "schoolId NUMERIC(3)");

        JdbcUtils.insertDataIntoTable("School", "name 'Tom'");

        //JdbcUtils.dropTable("students");

        //5. Step: Close the connection and statement
        JdbcUtils.closeConnectionAndStatement();
    }
}
