package Models;

import java.util.ArrayList;

public class Virksomhed {

    private String name;
    private String companyId;
    private int antalHold; //En metode skal læse arraylisten nedenfor med hold, antallet af aktive indeks på listen
    private ArrayList<Hold> hold;

    public Virksomhed(String name, String companyId){
        this.name = name;
        this.companyId = companyId;
        this.hold = new ArrayList<>();
    }

    public void addTeam(Hold hold){
        this.hold.add(hold);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public ArrayList<Hold> getAlleHold() {
        return hold;
    }

    public void setAlleHold(ArrayList<Hold> alleHold) {
        this.hold = alleHold;
    }

    public ArrayList<Hold> getHold() {
        return hold;
    }

    public void setHold(ArrayList<Hold> hold) {
        this.hold = hold;
    }

}

