/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rapsutin
 */
public class StatisticsTest {
    
    private Statistics statistics;
    
    @Before
    public void setUp() {
        statistics = new Statistics(new Reader() {

            public List<Player> getPlayers() {
                ArrayList<Player> players = new ArrayList<Player>();

                players.add(new Player("Semenko", "EDM", 4, 12));
                players.add(new Player("Lemieux", "PIT", 45, 54));
                players.add(new Player("Kurri", "EDM", 37, 53));
                players.add(new Player("Yzerman", "DET", 42, 56));
                players.add(new Player("Gretzky", "EDM", 35, 89));

                return players;
            }
        });
    }

    @After
    public void tearDown() {
    }

    @Test
    public void existingPlayerIsFound() {
        Player existingPlayer = statistics.search("Semenko");
        assertTrue(existingPlayer != null);
    }
    
    @Test
    public void nonExitingPlayerIsNotFound() {
        Player nonExistingPlayer = statistics.search("Curry");
        assertEquals(null, nonExistingPlayer);
    }
    
    @Test
    public void allPlayersOfTeamFound() {
        List<Player> teamPlayers = statistics.team("EDM");
        assertEquals(3, teamPlayers.size());
    }
    
    @Test
    public void topScorerFound() {
        Player topScorer = statistics.topScorers(1).get(0);
        assertEquals("Gretzky", topScorer.getName());
    }
    
}
