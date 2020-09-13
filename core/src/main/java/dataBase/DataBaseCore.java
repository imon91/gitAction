package dataBase;

import coreUtils.BuildParameterKeys;

import java.sql.*;

public class DataBaseCore {

    private String mobileNumber=null;
    private String data = null;
    private String hostName = null;

    public String getOTPForStore(){
        Connection connection = null;
        try{
            // Read Credentials Properties file
            mobileNumber = "8801877755530";//"%01877755580%"
        }catch (Exception e){

        }
        try {

            // Load the MySQL JDBC driver

            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);


            // Create a connection to the database

            if(System.getProperty(BuildParameterKeys.KEY_TRIGGER)
                    .equalsIgnoreCase("Jenkins")){
                hostName = "uatmysql.vnksrvc.com:3306";
            }else {
                hostName = "34.87.190.247";
            }

            String schema = "store_admin_service";

            String url = "jdbc:mysql://" + hostName +  "/" + schema;

            String username = "vshopdat";

            String password = "Vshopdev@567";

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

            ResultSet results = statement.executeQuery("SELECT OTP FROM user_otps WHERE phone = "+mobileNumber+" ORDER BY id DESC LIMIT 1");

// For each row of the result set ...

            while (results.next()) {

                //System.out.println("Control came here");
                // Get the data from the current row using the column index - column data are in the VARCHAR format

                data = results.getString(1);

                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("OTP");

                System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);


            }


        } catch (SQLException e) {

            System.out.println(e);
            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

}
