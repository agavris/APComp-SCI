package Help;

import java.util.ArrayList;

public class NhlTeams {

    private String nameOfTeam;

    private String cityOfTeam;

    private ArrayList<String> goalsPlayersOnTeam;

    public NhlTeams(String myName, String myCity) {

        nameOfTeam = myName;

        cityOfTeam = myCity;

        goalsPlayersOnTeam = new ArrayList<>();

    }

    public void changeName(String newName) {
            nameOfTeam = newName;
    }

    public void changeCity(String newCity) {
            cityOfTeam = newCity;
    }

    public void teamSummary() {
        System.out.println(nameOfTeam + " plays here in " + cityOfTeam + " this is the amount of players on the team " + goalsPlayersOnTeam.size());
    }

    public void scoredGoal(String nameOfPlayer) {
        goalsPlayersOnTeam.add(nameOfPlayer);
    }

    public String scoredMost(){

        if(goalsPlayersOnTeam.size() == 0){
            return null;
        }
        
        String mostGoals = goalsPlayersOnTeam.get(0);

        if(goalsPlayersOnTeam.size() == 1){
            return mostGoals;
        }


        for(int i = 1; i < goalsPlayersOnTeam.size(); i++){
            if(goalsPlayersOnTeam.get(i).equals(mostGoals)){
                mostGoals = goalsPlayersOnTeam.get(i);
            }
        }
        return mostGoals;
    }

    public static void main(String[] args) {
        NhlTeams team = new NhlTeams("Canucks", "Vancouver");
        team.teamSummary();
        team.scoredGoal("Thomas Lee");
        team.scoredGoal("Sam Hinckley");
        team.scoredGoal("Thomas Lee");
        team.scoredGoal("Ryan Kirmelewicz");
        System.out.println("The player with the most goals is: " + team.scoredMost());
    }

}