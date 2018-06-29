package eCommerce.Control;

import eCommerce.Services.PlatformService;
import eCommerce.Services.ProductService;
import eCommerce.Services.UserInputService;

// Controller to run eCommerce package
public class ECommerceController {

    // user input
    UserInputService userInputService = new UserInputService();

    // product services
    ProductService productService = new ProductService();

    // platform services
    PlatformService platformService = new PlatformService();

    // main method
    public static void main(String[] args) {
        ECommerceController c = new ECommerceController();

        // runs loop below
        c.start();
    }

    // controller switch statement for commands
    public void start() {
        // start user control default to 0.
        int user_input = 0;
        // continuously loops until exit (-1)
        do {
            // print menu
            userInputService.printMenu();
            // user selection
            user_input = userInputService.userMenuSelection();

            switch (user_input) {
                case 1:
                    // lists products via toString
                    productService.listProducts();
                    break;
                case 2:
                    // inserts new product info into eCommerce table
                    productService.insertProduct();
                    break;
                case 3:
                    // deletes product info by ID
                    productService.deleteProduct();
                    break;
                case 4:
                    // lists products in orderly table
                    productService.updateProducts();
                    break;
                case 5:
                    // lists platforms via toString
                    platformService.listPlatforms();
                    break;
                case 6:
                    // inserts new platform info into eCommerce table
                    platformService.insertPlatform();
                    break;
                case 7:
                    // deletes product info by ID
                    platformService.deletePlatform();
                    break;
                case 8:
                    // inserts new platform info into orderly table
                    platformService.updatePlatform();
                    break;
                case 9:
                    // return to main menu
                    System.out.println("Main menu coming soon!");
                    break;
            }
            // continue while user does not enter -1
        } while (user_input != -1);

        // exit
        System.out.println("Exiting control.");
    }
}

