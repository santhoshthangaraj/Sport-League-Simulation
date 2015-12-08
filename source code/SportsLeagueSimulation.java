import java.util.ArrayList;

public class SportsLeagueSimulation {
	
	//totalseason is total number of seasons played
	static int totalSeason = 100000;
	
	public static void main(String[] args) {
		
		Team firstTeam = new Team("Tigers",66);
		Team secondTeam = new Team("Dolphins",46);
		Team thirdTeam = new Team("Sharks",79);
		Team fourthTeam = new Team("Whales",75);
		
		//create list of teams and their details
		ArrayList<Team> teamList = new ArrayList<Team>();		
		teamList.add(firstTeam);
		teamList.add(secondTeam);
		teamList.add(thirdTeam);
		teamList.add(fourthTeam);
		
		//Used to predict the winner over all seasons
		Simulation sim = new Simulation(teamList, totalSeason);
		sim.findSeasonWinner();
	}
}
