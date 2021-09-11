package com.devrajs.algoexpert.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> teamAndItsPoint = new HashMap<>();
        String winnerTeam = "NA";
        int maxPoint = Integer.MIN_VALUE;
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> teamPair = competitions.get(i);
            String homeTeam = teamPair.get(0);
            String awayTeam = teamPair.get(1);
            String winner;
            if (results.get(i) == 1) {
                winner = homeTeam;
            } else {
                winner = awayTeam;
            }
            if (teamAndItsPoint.containsKey(winner)) {
                int currentPoint = teamAndItsPoint.get(winner);
                int newPoint = currentPoint + 3;
                teamAndItsPoint.put(winner, newPoint);
                if (newPoint > maxPoint) {
                    winnerTeam = winner;
                    maxPoint = newPoint;
                }
            } else {
                teamAndItsPoint.put(winner, 3);
                if (3 > maxPoint) {
                    winnerTeam = winner;
                    maxPoint = 3;
                }
            }
        }
        return winnerTeam;
    }
}
