/**
Sports League Simulation
=====

You are the manager for a soccer team in a league with 3 other teams.
Before the start of the next season you would like to simulate how all
the teams will do next season with no trades between teams. Here are the
teams playing in the next season and their performance scores:

Team     Score
----     ----
Tigers   66
Dolphins 46
Sharks   79
Whales   75

One season consists of 3 games for each team, one game against each
opponent. Each game will have 1 winner and 1 loser, there are no draws.
At the end of the season the team with the most amount of game wins wins
that season. If there are more than one team with the highest amount of
wins in a season, they all win the season.

During a game, the chance a team wins is determined by their performance
score matched up against their opponent's. The stronger team will have a
higher score than the weaker team. For each point of difference, add 1%
to that team's chance to win from 50%.

For Example:
If the Tigers played the Dolphins:
Tigers Score: 66
Dolphins Score: 46

66 > 46 -- Tigers are more likely to win
66 - 46 = 20 -- difference in score
50% + 20% = 70% -- chance for the Tigers to win
100% - 70% = 30% -- chance for the dolphins to win

Scores do not update after games, they are constant.

Using this logic, write a simulation that plays 1 million seasons and
outputs the teams ranked by number of season wins.
**/

Time Complexity - O(Number of Seasons * Number of possible matches in each season)
