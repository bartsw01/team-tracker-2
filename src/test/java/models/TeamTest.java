package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/8/17.
 */
public class TeamTest {
    @After
    public void tearDown() throws Exception {
        Team.clearAllTeams(); //I clear out allll the posts before each test.
    }

    @Test
    public void NewTeamObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = setupNewTeam();
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void TeamInstantiatesWithTeamName_true() throws Exception {
        Team team = setupNewTeam();
        assertEquals("Test Team", team.getTeamName());
    }

    @Test
    public void AllTeamsAreCorrectlyReturned_true() {
        Team team = setupNewTeam();
        Team otherTeam = setupNewTeam();
        assertEquals(2, Team.getAll().size());
    }

    @Test
    public void AllTeamsContainsAllTeams_true() {
        Team team = setupNewTeam();
        Team otherTeam = setupNewTeam();
        assertTrue(Team.getAll().contains(team));
        assertTrue(Team.getAll().contains(otherTeam));
    }

    @Test
    public void getAddedTeam_isFalseAfterInstantiation_false() throws Exception {
        Team myTeam = setupNewTeam();
        assertEquals(false, myTeam.getAddedTeam());
    }

    @Test
    public void getId_TeamInstantiateWithAnID_1() throws Exception {
        Team.clearAllTeams();  // Remember, the test will fail without this line! We need to empty leftover
        Team team = setupNewTeam();
        assertEquals(1, team.getId());
    }

    @Test
    public void findReturnsCorrectTeam() throws Exception {
        Team team = setupNewTeam();
        assertEquals(1, Team.findById(team.getId()).getId());
    }

    @Test
    public void findReturnsCorrectTeamWhenMoreThanOneTeamExists() throws Exception {
        Team team = setupNewTeam();
        Team otherTeam = setupNewTeam();
        assertEquals(2, Team.findById(otherTeam.getId()).getId());
    }

    @Test
    public void updateChangesTeamContent() throws Exception {
        Team team = setupNewTeam();
        String formerTeamName = team.getTeamName();
        team.update("Problematics");
        assertNotEquals(formerTeamName, team.getTeamName());
    }

    @Test
    public void deleteASpecificTeam() throws Exception {
        Team team = setupNewTeam();
        Team otherTeam = new Team("Code Warriors", "Way of the Code Warriors", "Maxine", "Joey", "Lizzy", "Fred");
        team.deleteTeam();
        assertEquals(1, Team.getAll().size());
        assertEquals(Team.getAll().get(0).getId(), 1);
    }






    public Team setupNewTeam(){
        return new Team("Test Team", "Test Description", "Test Member 1", "Test Member 2", "Test Member 3", "Test Member 4");
    }




}