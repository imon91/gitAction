package dataBase;

import java.sql.*;

public class DataBaseCore {

    private String mobileNumber=null;
    private String data = null;

    public String getOTPForStore(){
        Connection connection = null;
        try{
            // Read Credentials Properties file
            mobileNumber = "%01877755590%";
        }catch (Exception e){

        }
        try {

            // Load the MySQL JDBC driver

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);


            // Create a connection to the database

            String serverName = "uat-pub.vnksrvc.com:3306";

            String schema = "store_admin_service";

            String url = "jdbc:mysql://" + serverName +  "/" + schema;

            String username = "vnksho";

            String password = "Vnkshop@65";

            connection = DriverManager.getConnection(url, username, password);



            System.out.println("Successfully Connected to the database!");


        } catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
        }

        try {


// Get a result set containing all data from test_table

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT OTP FROM user_otps WHERE phone LIKE '"+mobileNumber+"' ORDER BY id DESC LIMIT 1 ");


// For each row of the result set ...

            while (results.next()) {


                // Get the data from the current row using the column index - column data are in the VARCHAR format

                data = results.getString(1);

                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("OTP");

                System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);


            }


        } catch (SQLException e) {

            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }

        return data;
    }

}
