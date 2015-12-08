import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Keeping track of team's win
public class TrackingWinner {
	Map <String, Integer> teamWins = new HashMap<String, Integer>();
	public TrackingWinner( ArrayList<Team> list)
	{		
		for(int teamCount = 0; teamCount < list.size(); teamCount++)
		{
			teamWins.put(list.get(teamCount).teamName, 0);
		}
	}
}