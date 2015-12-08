import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
 
//Get all teams with total wins over all seasons
public class Simulation {
	
	int numberofMatches;
	int numberOfTeamsInOneMatch = 2;
	int totalSeason;
	int [][] teamsWinCounter;
	TrackingWinner AllSeasons;
	ArrayList<Team> list;
	
	public Simulation(ArrayList<Team> listobj, int totalSeason)
	{		
		list = new ArrayList<Team>(listobj);
		this.totalSeason = totalSeason;
		numberofMatches = getPossibleNumberOfMatches(list.size());
		teamsWinCounter = new int[numberofMatches][numberOfTeamsInOneMatch];	
		for(int gameCount = 0; gameCount < list.size(); gameCount++)
		{
			for(int teamCount = 0; teamCount < numberOfTeamsInOneMatch; teamCount++)
			{
				teamsWinCounter[gameCount][teamCount] = 0;
			}			
		}
		AllSeasons = new TrackingWinner(list);
	}	

	//Finding the team winning count over all seasons
	//Time Complexity O(number of season * number of matches in each seasons)
	public void findSeasonWinner()
	{		
		for(int seasonCounter = 0; seasonCounter < totalSeason; seasonCounter++)
		{
			TrackingWinner obj = new TrackingWinner(list);
			int gameCounter = 0;
			for(int firstTeamCounter = 0; firstTeamCounter < list.size(); firstTeamCounter++)
			{
				for(int secondTeamCounter = firstTeamCounter+1; secondTeamCounter < list.size(); secondTeamCounter++)
				{															
					randomlyChooseTeam(firstTeamCounter,secondTeamCounter, gameCounter,obj);											
					gameCounter++;					
				}
			}	
			//Find the list of winners in one season and add 1 as winning points to the corresponding team
			int maxValue = Collections.max(obj.teamWins.values());
			for(Map.Entry<String, Integer> entry : obj.teamWins.entrySet())
			{ 
				if(entry.getValue() == maxValue)
				{
					String key = entry.getKey();
					AllSeasons.teamWins.put(key, AllSeasons.teamWins.get(key)+1);
				}			
			}				
		}				
		//Sort team based on their season win count
		SortMapOnValueInteger hashObj = new SortMapOnValueInteger(AllSeasons.teamWins);			
		System.out.println(hashObj.sortedMap);		
	}	
	
	//Randomly chosse a team to win in the match
	public void randomlyChooseTeam(int firstTeamCounter,int secondTeamCounter, int gameCounter,TrackingWinner obj)
	{
		int firstScore = Math.round((((50+list.get(firstTeamCounter).score-list.get(secondTeamCounter).score)*totalSeason)/100));
		int secondScore = totalSeason-firstScore;
		Random rand = new Random();
		int randomNumber = rand.nextInt(numberOfTeamsInOneMatch);
		int flag = 0;
		if(randomNumber == 1)
		{
			if(teamsWinCounter[gameCounter][numberOfTeamsInOneMatch-2] < firstScore)
			{
				flag = 1;
			}			
		}
		else
		{						
			if(teamsWinCounter[gameCounter][numberOfTeamsInOneMatch-1] >= secondScore) 
			{
				flag = 1;
			}
		}
		if(flag == 1)
		{
			String key = list.get(firstTeamCounter).teamName;
			obj.teamWins.put(key, obj.teamWins.get(key)+1);
			teamsWinCounter[gameCounter][numberOfTeamsInOneMatch-2] = 1+teamsWinCounter[gameCounter][numberOfTeamsInOneMatch-2];
		}
		else
		{
			String key = list.get(secondTeamCounter).teamName;
			obj.teamWins.put(key, obj.teamWins.get(key)+1);
			teamsWinCounter[gameCounter][numberOfTeamsInOneMatch-1] = 1+teamsWinCounter[gameCounter][numberOfTeamsInOneMatch-1];
		}
	}    
	//Finding the number of matches possible combination
	private int getPossibleNumberOfMatches(int size) {		
		//Finding number of Combination using nc(n-r)r formula		
		int r = 2;
		int k = size-r;
		int n = 1;
		for(int counter = 1; counter <= size; counter++)
		{
			n *= counter;
			if( k == counter)
			{
				k = n;
			}			
		}	
		return (n/(k*r));
	}
}