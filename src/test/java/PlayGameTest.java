package org.example.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayGameTest {

    static List<Door> doors;

    @BeforeEach
    void doorsForTest () {
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
    }

    @Test
    void winWithoutRiskIfDoorTrue () {
        Player player = new Player("Player1", false);
        Game game = new Game(player, doors);
        Door door = game.round(2);
        assertTrue(door.isPrize());
    }

    @Test
    void looseWithoutRiskIfDoorFalse () {
        Player player = new Player("Player2", false);
        Game game = new Game(player, doors);
        Door door = game.round(1);
        assertFalse(door.isPrize());
    }

    @Test
    void looseWithRiskIfDoorTrue () {
        Player player = new Player("Player3", true);
        Game game = new Game(player, doors);
        Door door = game.round(2);
        assertFalse(door.isPrize());
    }

    @Test
    void winWithRiskIfDoorFalse () {
        Player player = new Player("Player4", true);
        Game game = new Game(player, doors);
        Door door = game.round(0);
        assertTrue(door.isPrize());
    }

    @Test
    void getRiskTestIfTrue(){
        Player player = new Player("Player5", true);
        assertTrue(player.getRisk());
    }

    @Test
    void getRiskTestIfFalse(){
        Player player = new Player("Player6", false);
        assertFalse(player.getRisk());
    }
}
