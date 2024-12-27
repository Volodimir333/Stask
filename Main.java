public class Main {
    public static void main(String[] args) {
        DominoGame game = new DominoGame();


        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");

        game.addPlayer(player1);
        game.addPlayer(player2);


        game.dealInitialHands(7);

        while(!game.isGameOver()){
            game.playRound();
        }
    }
}