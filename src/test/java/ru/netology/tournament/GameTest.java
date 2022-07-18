package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player gamer1 = new Player(1, "Vasya", 10);
    Player gamer2 = new Player(2, "Petya", 10);
    Player gamer3 = new Player(3, "Vova", 11);
    Player gamer4 = new Player(4, "Kolya", 9);
    Player gamer5 = new Player(5, "Roma", 12);


    @Test
    public void shouldCompareStrengthOfTwoPlayersIfBothPlayersHaveEqualStrength() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(gamer1);
        registeredPlayers.register(gamer2);

        int expected = 0;
        int actual = registeredPlayers.round(gamer1.getName(), gamer2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfFirstPlayerStrongerThanSecond() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(gamer1);
        registeredPlayers.register(gamer4);

        int expected = 1;
        int actual = registeredPlayers.round(gamer1.getName(), gamer4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfFirstPlayersWeakerThanSecond() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(gamer3);
        registeredPlayers.register(gamer5);

        int expected = 2;
        int actual = registeredPlayers.round(gamer3.getName(), gamer5.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfFirstOfPlayersIsNotRegistered() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(gamer1);
        registeredPlayers.register(gamer3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(gamer4.getName(), gamer3.getName());
        });
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfSecondOfPlayersIsNotRegistered() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(gamer1);
        registeredPlayers.register(gamer4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(gamer1.getName(), gamer2.getName());
        });
    }

    @Test
    public void shouldCompareStrengthOfTwoPlayersIfBothPlayersAreNotRegistered() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(gamer1);
        registeredPlayers.register(gamer3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(gamer4.getName(), gamer2.getName());
        });
    }
}
