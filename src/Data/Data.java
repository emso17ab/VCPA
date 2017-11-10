package Data;

import Models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private ArrayList<User> users;
    private ArrayList<Virksomhed> alleVirksomheder;

    public Data(){
    }

    public void generateData() {

        this.users = new ArrayList<>();
        this.alleVirksomheder = new ArrayList<>();

        //Tre testbrugere bliver oprettet
        User user1 = new User("emil", "1234", 1);
        User user2 = new User("kristian", "5555", 2);
        User user3 = new User("mathias", "4444", 2);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        //Seks testdeltagere bliver oprettet
        Deltager deltager1 = new Deltager("Helen", "helen@hotmail.com", "BEGYNDER", "000101");
        Deltager deltager2 = new Deltager("Hanne", "hanne@hotmail.com", "PROFESSIONEL", "000102");
        Deltager deltager3 = new Deltager("Kristian", "kristian@hotmail.com", "ØVET", "000103");
        Deltager deltager4 = new Deltager("Bobby", "bobby@hotmail.com", "ØVET", "000204");
        Deltager deltager5 = new Deltager("Niels", "niels@hotmail.com", "BEGYNDER", "000205");
        Deltager deltager6 = new Deltager("Bjarne", "bjarne@hotmail.com", "PROFESSIONEL", "000206");

        //To testhold bliver oprettet og der lægges 3 testdeltagere ind på hvert hold
        //Constructor 1 fra hold objectet
        Hold hold1 = new Hold("SuperCyklerne", "Kristian", "9901");
        hold1.addDeltagerToTeam(deltager1);
        hold1.addDeltagerToTeam(deltager2);
        hold1.addDeltagerToTeam(deltager3);

        //Constructor 2 fra hold objectet
        Hold hold2 = new Hold("SpasserBasser", "Bjarne","9902", deltager4);
        hold2.addDeltagerToTeam(deltager5);
        hold2.addDeltagerToTeam(deltager6);

        //En testvirksomhed bliver oprettet og de to testhold bliver lagt ind
        Virksomhed virksomhed = new Virksomhed("Copenhagen Business School", "99");
        virksomhed.addTeam(hold1);
        virksomhed.addTeam(hold2);

        //Testvirksomheden bliver lagt ind på Masterlisten over alle virksomheder registreret i programmet
        addCompanyToMasterList(virksomhed);

    }


    public void printAlleHold() {
        int holdnummer = 0;

        System.out.println("\nPrinter en liste over alle hold\n");

        System.out.println("Nr.        Holdnavn          Holdkaptajn        Virksomhed       Antal deltagere");

        for (Virksomhed virksomhed : alleVirksomheder) {
            for (Hold hold : virksomhed.getAlleHold()) {
                System.out.println(holdnummer + "   " + hold.getHoldNavn() + "  " + hold.getHoldKaptajn() + "  " + virksomhed.getName() + "  " + hold.getDeltagere().size());
                holdnummer++;
            }
        }
    }

    public void printDeltagerFraHold(ArrayList<Hold> alleHold){
        Scanner input = new Scanner(System.in);
        int valg;

        printAlleHold();

        System.out.println("Vælg hold fra listen:");
        valg = input.nextInt();

        System.out.println("Oversigt over deltagere for hold: " + alleHold.get(valg).getHoldNavn());

        System.out.println("Navn        email          CyklistType");

            for (Deltager deltager : alleHold.get(valg).getDeltagere()) {
                System.out.println(deltager.getName() + "    " + deltager.getEmail() + "    " + deltager.getType());

            }


    }

    public void printAlleVirksomheder() {
        int virksomhedsnummer = 0;

        System.out.println("\nPrinter en liste over alle virksomheder\n");

        System.out.println("Nr.        Virksomhed          Antal hold");

        for (Virksomhed virksomhed : alleVirksomheder){
            System.out.println(virksomhedsnummer + "   " + virksomhed.getName() + "   " + virksomhed.getAlleHold().size());
            virksomhedsnummer++;
        }
    }


    public ArrayList<User> getUsers() {
        return users;
    }


    public Virksomhed getSpecificCompany(int index){
        return alleVirksomheder.get(index);
    }

    public Hold getSpecificTeam(Virksomhed virksomhed, int index){
        for (Virksomhed virksomhed :alleVirksomheder ) {
            for (Hold hold : virksomhed.getHold()) {
                if()

            }

        }
        return hold.get(index);
    }


    public void addCompanyToMasterList(Virksomhed virksomhed){
        this.alleVirksomheder.add(virksomhed);
    }

    public ArrayList<Virksomhed> getAlleVirksomheder() {
        return alleVirksomheder;
    }

    public void setAlleVirksomheder(ArrayList<Virksomhed> alleVirksomheder) {
        this.alleVirksomheder = alleVirksomheder;
    }

    public ArrayList<Hold> getAlleHold(ArrayList<Hold> alleHold){
        return alleHold;
    }


}





