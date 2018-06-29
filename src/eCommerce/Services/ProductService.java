package eCommerce.Services;

import eCommerce.Model.Products;

import java.sql.*;
import java.util.ArrayList;

public class ProductService {

    // needed variables
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    // import database
    // import products pojo
    DatabaseService databaseService = new DatabaseService();
    UserInputService userInputService = new UserInputService();

    // LIST PRODUCT METHOD
    public void listProducts() {
        try {
            // pull data from database connection
            statement = databaseService.sqlStatement();

            // set statement to instance variable "resultSet"
            resultSet = statement.executeQuery("select * from Products;");

            // put result set variable into Array of Products
            ArrayList<Products> products = mapResultSetToObjects(resultSet);

            // pull list from toString
            for (Products p : products) {
                System.out.println(p.toString());
            }
            System.out.println();

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

        } catch (Exception e) {
            System.out.println("Error listing products: " + e.getMessage());
        }
    }


    // INSERT PRODUCT METHOD
    public void insertProduct() {

        Products products = userInputService.userProductDetails();

        try {
            // connect to database
            connection = databaseService.mySQLConnect();
            // PreparedStatements can use variables and are more efficient; ?, ? gets values for prepared statements below
            preparedStatement = connection.prepareStatement("insert into Products (name, description)" + "values (?, ?)");
            // 1 - product name   // product.getname
            preparedStatement.setString(1, products.getName());
            // 2 - product description        // product.getdescription
            preparedStatement.setString(2, products.getDescription());
            // execute above into database
            preparedStatement.executeUpdate();

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

            // print message
            System.out.println("New product: " + products.getName() + ", New Description: " + products.getDescription() + ", entered successfully.");
        } catch (Exception e) {
            System.out.println("Error inserting new products: " + e.getMessage());
        }
    }

    // DELETE PRODUCT METHOD
    public void deleteProduct() {
        int id = userInputService.userDeleteProductId();
        try {
            // connect to database
            connection = databaseService.mySQLConnect();

            // DELETE DATA
            //Remove again the insert comment
            preparedStatement = connection.
                    prepareStatement("delete from Products where id = ? ; ");

            preparedStatement.setInt(1, id);

            // execute above into database
            preparedStatement.executeUpdate();

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

            // print message
            System.out.println("Product ID : " + id + ", has been removed.");
        } catch (Exception e) {
            System.out.println("Error deleting products: " + e.getMessage());
            e.printStackTrace();
        }
    }


    // UPDATE PRODUCT INFO METHOD
    public void updateProducts() {
        try {
            // pull data from database connection
            connection = databaseService.mySQLConnect();

            preparedStatement = connection.prepareStatement("SELECT * from Products");
            resultSet = preparedStatement.executeQuery();

            writeResultSet(resultSet);

            // CLOSE CONNECTION
            databaseService.closeMySQL(statement, connection);

        } catch (Exception e) {
            System.out.println("Error listing products: " + e.getMessage());
        }
    }


    // Map Results
    private ArrayList<Products> mapResultSetToObjects(ResultSet resultSet) throws SQLException {

        ArrayList<Products> retList = new ArrayList();

        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // set object and variables
            Products p = new Products();
            p.setId(resultSet.getInt("id"));
            p.setName(resultSet.getString("name"));
            p.setDescription(resultSet.getString("description"));
            // add product to array list
            retList.add(p);
        }
        // return array list
        return retList;
    }

    // PRODUCT LIST DISPLAY HERE!
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            //establish variables
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");

            System.out.println("ID number: " + id);
            System.out.println("Product name: " + name);
            System.out.println("Product description: " + description);
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
        }
    }
}

