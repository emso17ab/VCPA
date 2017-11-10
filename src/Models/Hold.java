package Models;

import java.util.ArrayList;

public class Hold {

    private String holdNavn;
    private String holdKaptajn;
    private String teamId;
    private ArrayList<Deltager> deltagere;

    //Den første constructor anvendes hvis der skal oprettes et hold med en tom deltagerliste

    public Hold(String holdNavn, String holdKaptajn, String teamId){
        this.holdNavn = holdNavn;
        this.holdKaptajn = holdKaptajn;
        this.teamId = teamId;
        this.deltagere = new ArrayList<>();

    }

    //Den anden constructor anvendes til at oprette et hold OG en deltager eller flere

    public Hold(String holdNavn, String holdKaptajn, String teamId, Deltager deltager){
        this.holdNavn = holdNavn;
        this.holdKaptajn = holdKaptajn;
        this.deltagere = new ArrayList<>();
        this.deltagere.add(deltager);

    }


    //METHODS

    public void addDeltagerToTeam(Deltager deltager){
        this.deltagere.add(deltager);
    }



    //GETTER/SETTER


    public String getHoldNavn() {
        return holdNavn;
    }

    public void setHoldNavn(String holdNavn) {
        this.holdNavn = holdNavn;
    }

    public String getHoldKaptajn() {
        return holdKaptajn;
    }

    public void setHoldKaptajn(String holdKaptajn) {
        this.holdKaptajn = holdKaptajn;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    public void setDeltagere(ArrayList<Deltager> deltagere) {
        this.deltagere = deltagere;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
