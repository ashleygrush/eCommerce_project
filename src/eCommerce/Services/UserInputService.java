package eCommerce.Services;


import eCommerce.Model.Platforms;
import eCommerce.Model.Products;

import java.util.Scanner;

public class UserInputService {


    // User Product Details
    public Products userProductDetails() {
        Scanner scanner = new Scanner(System.in);

        Products product = new Products();
        System.out.println("Enter new product name:");
        product.setName(scanner.nextLine());
        System.out.println("Enter new product description:");
        product.setDescription(scanner.nextLine());
        return product;
    }

    // User Product ID Delete
    public int userDeleteProductId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product ID to delete:");
        return scanner.nextInt();
    }

    // User Platform Details
    public Platforms userPlatformDetails() {
        Scanner scanner = new Scanner(System.in);

        Platforms platforms = new Platforms();
        System.out.println("Enter new platform name:");
        platforms.setPlatform_name(scanner.nextLine());
        System.out.println("Enter new platform url:");
        platforms.setPlatform_url(scanner.nextLine());
        System.out.println("Enter new Sales fee");
        platforms.setSales_fee(scanner.nextDouble());
        return platforms;
    }

    // User Platform ID Delete
    public int userDeletePlatformId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter platform ID to delete:");
        return scanner.nextInt();
    }


    // User menu Selection
    public int userMenuSelection() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // Main Menu
    public void printMenu() {
        System.out.println("----------------- MAIN MENU -----------------");
        System.out.println("------- Products ---------");
        System.out.println("Enter 1 = view all products.");
        System.out.println("Enter 2 = create a new product.");
        System.out.println("Enter 3 = delete a product by ID.");
        System.out.println("Enter 4 = list all projects");
        System.out.println("-------- Platforms ---------");
        System.out.println("Enter 5 = view all platforms.");
        System.out.println("Enter 6 = create a new platform.");
        System.out.println("Enter 7 = delete a platform by ID.");
        System.out.println("Enter 8 = list all platforms");
        System.out.println("------------ Exit ----------");
        System.out.println("Enter 9 = return to main menu - coming soon");
        System.out.println("enter -1 to exit program");
        System.out.println("--------------------------------------------");
    }

}
