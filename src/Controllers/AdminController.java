package Controllers;

//Her skal alle funktionerne for Administrator ligge!

import java.util.Scanner;

public class AdminController {

    public void printAdminMenu() {
        int choice;
        boolean status = true;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n\tADMIN MENU");
            System.out.println("\t1) Godkend Hold");
            System.out.println("\t2) Vis statistik over holdfordelingen");
            System.out.println("\t3) Vis holdoplysninger");
            System.out.println("\t4) Vis alle holdoplysninger");
            System.out.println("\t0) Log af");
            System.out.print("\n\tIndtast valg: ");
            choice = input.nextInt();

            switch (choice) {
                case 0:
                    status = false;
                    break;
                case 1: approveTeam();
                    break;
                case 2: printTeamStatistics();
                    break;
                case 3: printTeamData();
                    break;
                case 4: printAllData();
                    break;
                default: System.out.println("\nFejl i indtastningen, prøv igen!\n");
            }
        }while(status);
    }

    //METHODS

    private void printAllData() {

    }

    private void printTeamData() {

    }

    private void printTeamStatistics() {

    }

    private void approveTeam() {

    }
}
