package eCommerce.Services;

import eCommerce.Model.Platforms;

import java.sql.*;
import java.util.ArrayList;

public class PlatformService {

    // needed variables
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    // import database
    // import products pojo
    DatabaseService databaseService = new DatabaseService();
    UserInputService userInput = new UserInputService();

    // LIST PLATFORMS METHOD
    public void listPlatforms() {
        try {
            // pull data from database connection
            statement = databaseService.sqlStatement();

            // set statement to instance variable "resultSet"
            resultSet = statement.executeQuery("select * from platforms;");

            // put result set variable into Array of Products
            ArrayList<Platforms> platforms = mapResultSetToObjects(resultSet);

            // pull list from toString
            for (Platforms f : platforms) {
                System.out.println(f.toString());
            }
            System.out.println();

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

        } catch (Exception e) {
            System.out.println("Error listing products: " + e.getMessage());
        }
    }


    // INSERT PLATFORMS METHOD
    public void insertPlatform() {

        Platforms platforms = userInput.userPlatformDetails();

        try {
            // connect to database
            connection = databaseService.mySQLConnect();
            // PreparedStatements can use variables and are more efficient; ?, ? gets values for prepared statements below
            preparedStatement = connection.prepareStatement("insert into platforms (platform_name, platform_url, sales_fee)" + "values (?, ?, ?)");
            // 1 - product name   // product.getname
            preparedStatement.setString(1, platforms.getPlatform_name());
            // 2 - product description        // product.getdescription
            preparedStatement.setString(2, platforms.getPlatform_url());

            preparedStatement.setDouble(3,platforms.getSales_fee());
            // execute above into database
            preparedStatement.executeUpdate();

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

            // print message
            System.out.println("New platform: " +platforms.getPlatform_name()+ ", New URL link: " +platforms.getPlatform_url()+
                    ", Sales fee: " +platforms.getSales_fee()+ ", entered successfully.");
        } catch (Exception e) {
            System.out.println("Error inserting new products: " + e.getMessage());
        }
    }

    // DELETE PLATFORMS METHOD
    public void deletePlatform() {
        int id = userInput.userDeletePlatformId();
        try {
            // connect to database
            connection = databaseService.mySQLConnect();

            // DELETE DATA
            //Remove again the insert comment
            preparedStatement = connection.
                    prepareStatement("delete from platforms where id = ? ; ");

            preparedStatement.setInt(1,id);

            // execute above into database
            preparedStatement.executeUpdate();

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

            // print message
            System.out.println("Platform ID : " +id+ ", has been removed.");
        } catch (Exception e) {
            System.out.println("Error deleting platforms: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // UPDATE PLATFORM INFO METHOD
    public void updatePlatform() {
        try {
            // pull data from database connection
            connection = databaseService.mySQLConnect();

            preparedStatement = connection.prepareStatement("SELECT * from platforms");
            resultSet = preparedStatement.executeQuery();

            writeResultSet(resultSet);

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

        } catch (Exception e) {
            System.out.println("Error listing platforms: " + e.getMessage());
        }
    }


    // LIST
    // Results to Mapping above
    private ArrayList<Platforms> mapResultSetToObjects(ResultSet resultSet) throws SQLException {

        ArrayList<Platforms> retList = new ArrayList();

        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // set object and variables
            Platforms f = new Platforms();
            f.setId(resultSet.getInt("id"));
            f.setPlatform_name(resultSet.getString("platform_name"));
            f.setPlatform_url(resultSet.getString("platform_url"));
            f.setSales_fee(resultSet.getDouble("sales_fee"));
            // add product to array list
            retList.add(f);
        }
        // return array list
        return retList;
    }

    // PLATFORM LIST DISPLAY HERE!
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            //establish variables
            int id = resultSet.getInt("id");
            String platform_name = resultSet.getString("platform_name");
            String platform_url = resultSet.getString("platform_url");
            Double sales_fee = resultSet.getDouble("sales_fee");


            System.out.println("ID number: " + id);
            System.out.println("Platform name: " + platform_name);
            System.out.println("Platform URL: " + platform_url);
            System.out.println("Platform Sales Fee: " + sales_fee);
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
        }
    }

}
