package Controllers;

//Her skal alle funktionerne for Deltager ligge!

import java.util.Scanner;
import Data.Data;
import Models.Deltager;
import Models.Hold;

public class DeltagerController {

    Scanner input = new Scanner(System.in);
    Data data;

    public DeltagerController(Data data) {
        this.data = data;
    }

    public void printDeltagerMenu() {
        int choice;
        boolean status = true;

        do {

            System.out.println("\n\tDELTAGER MENU");
            System.out.println("\t1) Ændr Hold");
            System.out.println("\t2) Ændr Deltager");
            System.out.println("\t3) Vis Deltageroplysninger");
            System.out.println("\t4) Vis Holdoplysninger");
            System.out.println("\t0) Log af");
            System.out.print("\n\tIndtast valg: ");
            choice = input.nextInt();

            switch (choice) {
                case 0:
                    status = false;
                    break;
                case 1: changeTeam();
                    break;
                case 2: changeContestant();
                    break;
                case 3: printContestantData();
                    break;
                case 4: printTeamData();
                    break;
                default: System.out.println("\nFejl i indtastningen, prøv igen!\n");
            }
        }while(status);
    }

    private void printTeamData() {
        data.printAlleHold();
    }


    private void printContestantData() {
        Hold currentTeam;
        int contestantNumber = 0;

        System.out.println("\nVælg hvilket hold du vil se deltageroplysninger fra\n");
        printTeamData();
        System.out.print("\nIndtast holdNr.: ");

        currentTeam = data.getSpecificTeam(input.nextInt());

        System.out.println("Nr.            Navn              email adresse            cyklist Type");

        for (Deltager deltager : currentTeam.getDeltagere()) {
            System.out.println(contestantNumber + "" + deltager.getName() + "    " + deltager.getEmail() + "    " + deltager.getType());
            contestantNumber++;
        }
    }

    private void changeContestant() {


    }

    private void changeTeam() {



    }
}
