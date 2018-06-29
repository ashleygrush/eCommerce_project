package eCommerce.Control;

import eCommerce.Services.PlatformService;
import eCommerce.Services.ProductService;
import eCommerce.Services.UserInputService;


public class ECommerceController {

    UserInputService userInputService = new UserInputService();
    ProductService productService = new ProductService();
    PlatformService platformService = new PlatformService();


    public static void main(String[] args) {
        ECommerceController c = new ECommerceController();
        c.start();
    }

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
                    productService.listProducts();
                    break;
                case 2:
                    productService.insertProduct();
                    break;
                case 3:
                    productService.deleteProduct();
                    break;
                case 4:
                    productService.updateProducts();
                    break;
                case 5:
                    platformService.listPlatforms();
                    break;
                case 6:
                    platformService.insertPlatform();
                    break;
                case 7:
                    platformService.deletePlatform();
                    break;
                case 8:
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

