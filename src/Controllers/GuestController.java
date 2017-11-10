package Controllers;

//Her skal alle funktionerne for Gæst ligge!

import Models.Deltager;
import Models.Hold;
import Data.Data;
import Models.Virksomhed;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class GuestController {
    Data data;
    Scanner input = new Scanner(System.in);

    public GuestController(Data data){
        this.data = data;
    }

    public void printGuestMenu() {
        int choice;
        boolean status = true;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n\tGUEST MENU");
            System.out.println("\t1) Opret Hold");
            System.out.println("\t2) Tilmeld Deltager");
            System.out.println("\t0) Log af");
            System.out.print("\tIndtast valg: ");
            choice = input.nextInt();

            switch(choice){
                case 0: status = false;
                    break;
                case 1: createTeam();
                    break;
                case 2: createContestant();
                    break;
                default: System.out.println("\nFejl i indtastningen, prøv igen!\n");
            }


        }while(status);
    }

    private void createContestant() {
        int scenario = 0;
        boolean status = true;
        Hold currentTeam = null;
        String contestantName;
        String contestantEmail;
        String contestantType;
        String userId;

        do {

            if(scenario == 0) {

                System.out.println("OPRET NY DELTAGER\n" +
                        "Vælg fra listen hvilket hold deltageren skal oprettes på");
                data.printAlleHold();
                System.out.print("\nIndtast holdNr.: ");

                currentTeam = data.getSpecificTeam(input.nextInt());


                System.out.println("Du er ved at oprette en ny deltager til hold: " + currentTeam.getHoldNavn() + "?");
                System.out.println("1) Fortsæt\n2) Vælg andet hold\n3) Fortryd");
                switch (input.nextInt()) {
                    case 1:
                        scenario = 1;
                        break;
                    case 2:
                        status = true;
                        break;
                    case 3: status = false;
                        break;
                    default:
                }
            }

            if (scenario == 1) {
                input.nextLine();
                System.out.print("\nIndtast deltagers navn: ");
                contestantName = input.nextLine();
                System.out.print("\nIndtast deltagers email adresse: ");
                contestantEmail = input.nextLine();

                System.out.print("\nVælg deltagers cykelist Type\n");
                System.out.println("1) BEGYNDER");
                System.out.println("2) ØVET");
                System.out.println("3) EXPERT");

                contestantType = convertType(input.nextInt());

                userId = generateUserId();

                Deltager newContestant = new Deltager(contestantName, contestantEmail, contestantType, userId);

                currentTeam.addDeltagerToTeam(newContestant);

                System.out.println(newContestant.getName() + " blev oprettet på hold " + currentTeam.getHoldNavn());
                System.out.println("1) Tilføj flere deltagere til hold " + currentTeam.getHoldNavn() + "?");
                System.out.println("2) Tilføj ny deltager til et andet hold?");
                System.out.println("3) Tilbage til Hovedmenuen");

                switch (input.nextInt()) {
                    case 1:
                        scenario = 1;
                        break;
                    case 2:
                        scenario = 0;
                        break;
                    case 3:
                        status = false;
                        break;
                    default:
                }


            }
        }while(status);

    }

    private void createTeam() {
        int scenario = 0;
        boolean status = true;
        String teamName;
        String teamCaptain;
        String teamId;
        String companyName;
        String companyId;
        Virksomhed currentCompany;

        do {

            if(scenario == 0) {
                input.nextLine();
                System.out.println("Vil du oprette et nyt hold til en...");
                System.out.println("1) ny Virksomhed");
                System.out.println("2) eksisterende Virksomed");
                System.out.print("\nIndtast valg: ");

                switch (input.nextInt()) {
                    case 1:
                        scenario = 1;
                        break;
                    case 2:
                        scenario = 2;
                        break;
                    default:
                }
            }

            if(scenario ==1){
                System.out.println("\nIndtast navnet på den virksomhed du vil oprette et hold under: ");
                companyName = input.nextLine();
            }

            if(scenario == 2) {

                data.printAlleHold();

                System.out.print("\nIndtast holdNr.: ");
                currentCompany = data.getSpecificCompany(input.nextInt());

                System.out.println("Indtast holdnavn: ");
                teamName = input.nextLine();
                System.out.println("Indtast holdkaptajn: ");
                teamCaptain = input.nextLine();

                teamId = generateTeamId(currentCompany);

                Hold hold = new Hold(teamName, teamCaptain, teamId);
                data.addTeam(hold);

                companyId = generateCompanyId();
                Virksomhed virksomhed = new Virksomhed(currentCompany.getName(), teamId, hold);

                for (Hold hold1 : data.getAlleHold()) {
                    System.out.println("holdnavn: " + hold1.getHoldNavn() + "Holdkaptajn: " + hold1.getHoldKaptajn());
                }
            }

        }while(status);


    }

    //Additional Methods

    //metode der konverterer cyklisttypen som et tal 1,2 eller 3 om til tekstform
    public String convertType(int numberType){
        String textType = "default";
        if (numberType == 1)
            textType = "BEGYNDER";
        else if(numberType == 2)
            textType = "ØVET";
        else if(numberType == 3)
            textType = "EXPERT";

        return textType;
    }

    //metode der genererer et userId til deltageren. Skal bruges til at identificere og logge ind i programmet.
    private String generateUserId() {
        int userIdInteger = data.getUsers().size() + 1;
        String userIdString = String.valueOf(userIdInteger);
        return userIdString;
    }

    //metode der genererer et teamId til holdet. Skal bruges til at identificere holdet i programmet.
    private String generateTeamId(Virksomhed virksomhed) {
        int teamIdInteger = virksomhed.getHold().size() + 1;
        String teamIdString = String.valueOf(teamIdInteger);
        return teamIdString;
    }

    //metode der genererer et virksomhedsId til virksomheden. Skal bruges til at identificere virksomheden i programmet.
    private String generateCompanyId() {
        int companyIdInteger = data.getAlleVirksomheder().size() + 1;
        String companyIdString = String.valueOf(companyIdInteger);
        return companyIdString;
    }
}
