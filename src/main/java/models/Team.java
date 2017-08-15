package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/8/17.
 */
public class Team {
    private static ArrayList<Team> instances = new ArrayList<>();
    private String teamName;
    private String teamDescription;
    private String teamMember1;
    private String teamMember2;
    private String teamMember3;
    private String teamMember4;
    private int id;
    private boolean addedTeam;

    public Team (String teamName, String teamDescription, String teamMember1, String teamMember2, String teamMember3, String teamMember4){
        this.teamName = teamName;
        this.teamDescription = teamDescription;
        this.teamMember1 = teamMember1;
        this.teamMember2 = teamMember2;
        this.teamMember3 = teamMember3;
        this.teamMember4 = teamMember4;
        instances.add(this);
        this.id = instances.size();
        this.addedTeam = false;
    }

    public static ArrayList<Team> getAll(){
        return instances;
    }

    public String getTeamName(){
        return teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public String getTeamMember1() {
        return teamMember1;
    }

    public String getTeamMember2() {
        return teamMember2;
    }

    public String getTeamMember3() {
        return teamMember3;
    }

    public String getTeamMember4() {
        return teamMember4;
    }

    public int getId() {
        return id;
    }

    public boolean getAddedTeam(){
        return this.addedTeam;
    }

    public static Team findById(int id){
        return instances.get(id-1);
    }

    public void update(String teamName) {
        this.teamName = teamName;
    }

    public static void clearAllTeams(){
        instances.clear();
    }

    public void deleteTeam(){
        instances.remove(id-1);
        for(Team thisTeam: instances){
            thisTeam.id = instances.indexOf(thisTeam) + 1;
        }
    }

}
