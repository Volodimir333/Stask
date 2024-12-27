import java.util.ArrayList;
import java.util.List;

public class DominoGame {
    private DominoSet dominoSet;
    private List<Player> players;
    private List<Tile> board;


    public DominoGame() {
        this.dominoSet = new DominoSet();
        this.players = new ArrayList<>();
        this.board = new ArrayList<>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void dealInitialHands(int tilesPerPlayer){
        dominoSet.shuffleTiles();
        for(Player player : players) {
            for(int i = 0; i < tilesPerPlayer; i++){
                player.addTile(dominoSet.takeTile());
            }
        }
    }

    public void playRound(){
        for (Player player : players){
            System.out.println( player.getName() + " ходит");
            player.showHand();
            Tile selectedTile = playerPlay(player);

            if(selectedTile != null){
                playTile(player, selectedTile);
            }else{
                System.out.println(player.getName() + " Передает ход.");
            }
            if(board.isEmpty()){
                board.add(selectedTile);
                player.removeTile(selectedTile);
            }
            System.out.println("Доска "+ board);
        }
    }

    private Tile playerPlay(Player player){
        if (board.isEmpty()){
            return player.getHand().get(0); // Первый ход, выкладываем любую костяшку
        }else{
            Tile lastBoardTile = board.get(board.size() - 1);
            for (Tile tile : player.getHand()){
                if(tile.getLeft() == lastBoardTile.getRight() || tile.getRight() == lastBoardTile.getRight()){
                    return tile;
                }
            }
        }
        return null;
    }


    private void playTile(Player player, Tile tile){

        if (board.isEmpty()){
            board.add(tile);
            player.removeTile(tile);
        }else{
            Tile lastBoardTile = board.get(board.size() - 1);
            if(tile.getLeft() == lastBoardTile.getRight()){
                board.add(tile);
                player.removeTile(tile);

            } else if (tile.getRight() == lastBoardTile.getRight()) {
                int temp = tile.getLeft();
                board.add(new Tile(tile.getRight(), temp));
                player.removeTile(tile);
            }
        }
    }

    public boolean isGameOver(){
        for (Player player : players){
            if(player.getHand().isEmpty()){
                return true;
            }
        }
        return false;
    }
}