import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(12, "Egor", 123);
    Player player2 = new Player(14, "Alena", 65);
    Player player3 = new Player(121, "Semen", 123);


    @Test
    public void testFirstPlayerWin() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round(player1.name, player2.name);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWin() {
        Game game = new Game();

        game.register(player2);
        game.register(player1);

        int actual = game.round(player2.name, player1.name);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDrawPlayers() {
        Game game = new Game();

        game.register(player1);
        game.register(player3);

        int actual = game.round(player1.name, player3.name);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNotRegisteredFirst() {
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ваня", player2.name);
        });
    }

    @Test
    public void testNotRegisteredSecond() {
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player2.name, "Ваня");
        });
    }
}
