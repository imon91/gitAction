package dataBase;

import coreUtils.BuildParameterKeys;

import java.sql.*;

public class DataBaseCore {

    private static Connection connection;
    private String mobileNumber=null;
    private String data = null;
    private static String hostName = null;


    private static boolean createDataBaseConnection(){
        boolean db_connected = false;
        try {

            // Load the MySQL JDBC driver

            String driverName = "com.mysql.cj.jdbc.Driver";

            Class.forName(driverName);


            // Create a connection to the database

//            if(System.getProperty(BuildParameterKeys.KEY_TRIGGER)
//                    .equalsIgnoreCase("Jenkins")){
//                hostName = "uat-pub.vnksrvc.com";
//            }else {
                hostName = "uat-pub.vnksrvc.com";
//            }

            String url = "jdbc:mysql://" + hostName + "/";

            String username = "vshopdat";

            String password = "Vshopdev@567";

            connection = DriverManager.getConnection(url, username, password);



            System.out.println("Successfully Connected to the database!");

            db_connected = true;

        } catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
        }
        return db_connected;
    }

    public static ResultSet executeQuery(String query){
        //System.out.println(query);
        ResultSet results=null;
        if(createDataBaseConnection()){
            try{
                Statement statement = connection.createStatement();
                results = statement.executeQuery(query);
            }catch (Exception e){
                System.out.println(e);
                System.out.println("Exception At Execute Query for  : "+ query);
            }
        }else {
            System.out.println("Database Connection Failure");
        }
        return results;
    }

    public static void closeDbConnection(){
        try{
            if(connection.isClosed()){
                System.out.println("Connection is closed");
            }else {
                connection.close();
                //System.out.println("Successfully Closed DB connection");
            }
        }catch (Exception e){
            System.out.println("Database Connection Close Exception : "+e);
        }
    }

    public String getOTPForStore() {
        if (createDataBaseConnection()) {
            try {
                // Read Credentials Properties file
                mobileNumber = "8801877755530";//"%01877755580%"
            } catch (Exception e) {
                System.out.println("failed to connect to DB");
            }


            try {

                ResultSet results = executeQuery("SELECT OTP FROM store_admin_service.user_otps WHERE phone = " + mobileNumber + " ORDER BY id DESC LIMIT 1");


// Get a result set containing all data from test_table

//                Statement statement = connection.createStatement();

//                ResultSet results = statement.executeQuery("SELECT OTP FROM store_admin_service.user_otps WHERE phone = " + mobileNumber + " ORDER BY id DESC LIMIT 1");

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
        return null;
    }

    public int getZoneIdByLocationName(String locationName) throws SQLException {
        int zoneId = 0;
        ResultSet resultSet = executeQuery("select id from shopup_cmt.zones where name = '"+ locationName +"';");
        if (resultSet != null){
            System.out.println("control is inside query");
            try {
                while (resultSet.next()) {
                    zoneId = resultSet.getInt(1);
                }
            } catch (Exception e){
                System.out.println("Exception at getting Zone ID");
            } finally {
                closeDbConnection();
            }
        } else {
            System.out.println("result set is null");

        }


        return zoneId;
    }

}
