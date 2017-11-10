package Controllers;

import Data.Data;
import Models.User;
import java.util.Scanner;

public class MainController {
    private Data data;
    Scanner input = new Scanner(System.in);


    public MainController() {
        this.data = new Data();
        data.generateData();
    }


    public void run() {
        int choice;
        boolean status = true;

        do {
            System.out.println("\nVelkomment til VI CYKLER PÅ ARBEJDE\n");
            System.out.println("1) Jeg er registreret bruger");
            System.out.println("2) Log ind som gæst");
            System.out.println("0) Afslut program");
            System.out.print("\nIndtast valg: ");
            choice = input.nextInt();

            switch (choice) {
                case 0: status = false;
                    break;
                case 1:
                    userLogin();
                    break;
                case 2:
                    GuestController guestController = new GuestController(data);
                    guestController.printGuestMenu();
                    break;
                default:
            }
        }while(status);
    }

        public void userLogin() {
        String username;
        String password;

        input.nextLine();

        System.out.println("\nLogin med dit brugernavn og password nedenfor\n");
        System.out.print("Brugernavn: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();

        User currentUser = validateLogin(username, password);

        if(currentUser != null){
            switch (currentUser.getType()){
                case 1:
                    AdminController adminController = new AdminController();
                    adminController.printAdminMenu();
                    break;
                case 2:
                    DeltagerController deltagerController = new DeltagerController(data);
                    deltagerController.printDeltagerMenu();
                    break;
                default:
            }
        }else{
            System.out.println("Forkert Brugernavn eller password, prøv igen");
        }


    }

    public User validateLogin(String username, String password) {

        for (User user : data.getUsers())
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        return null;
    }
}


