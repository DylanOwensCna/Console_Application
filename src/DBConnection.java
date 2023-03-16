import java.sql.*;
public class DBConnection {
    /**
     * Enter credentials for db connection to HeidiSQL
     */

    protected static final String DB_URL = "jdbc:mariadb://localhost:3307/quote_application";
    protected static final String DB_USER = "root";
    protected static final String DB_PASS = "declan";
    protected static final String MARIA_DB_DRIVER_NAME = "org.mariadb.jdbc.Driver";

    public static void main(String[] args) {

        try {
            /**
             * register the driver
             */
                doClassForNameRegistration();
                Connection connection = DriverManager.getConnection(
                        DB_URL,
                        DB_USER,
                        DB_PASS
                );
            // Execute a query
            Statement statement = connection.createStatement();
            String autoTableCreate = "CREATE TABLE AutoPolicyQuotes " +
                    "(quote_id INT NOT NULL AUTO_INCREMENT, " +
//                    " policyHolderName VARCHAR(50) NOT NULL," +
                    " policyCarValue DECIMAL(10,2) NOT NULL, " +
                    " policyAccidentTotal INT NOT NULL, " +
                    " policyDriverAge INT NOT NULL, " +
                    " policyLocation INT NOT NULL, " +
                    "quoteTotal DECIMAL(10,2) NOT NULL," +
                    " PRIMARY KEY ( quote_id )" +
                    ")";

            String homeTableCreate = "CREATE TABLE HomePolicyQuotes (" +
                    "quoteId INT NOT NULL AUTO_INCREMENT," +
//                    "policyHolderName VARCHAR(50) NOT NULL," +
                    "policyHomeValue DECIMAL(10,2) NOT NULL," +
                    "policyHomeAge INT NOT NULL," +
                    "policyHeatingType INT NOT NULL," +
                    "propertyValue DECIMAL(10,2) NOT NULL," +
                    "quoteTotal DECIMAL(10,2) NOT NULL," +
                    "PRIMARY KEY (quoteId)" +
                    ");";
            statement.executeUpdate(autoTableCreate);
            statement.executeUpdate(homeTableCreate);
            System.out.println("Table AutoPolicyQuotes created successfully!");
            System.out.println("Table HomePolicyQuotes created successfully!");
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void doClassForNameRegistration() {
        final String driverName = MARIA_DB_DRIVER_NAME;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load MariaDB driver class!");
            System.out.printf("Driver Name: ", driverName);
            System.exit(1);
        }
    }
}

