import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoSet {
    private List<Tile> tiles;

    public DominoSet() {
        this.tiles = new ArrayList<>();
        generateTiles();
    }

    private void generateTiles() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                tiles.add(new Tile(i, j));
            }
        }
        tiles.removeIf(tile -> tile.getLeft() == tile.getRight() && tile.getLeft() == 6);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void shuffleTiles() {
        Collections.shuffle(tiles);
    }

    public Tile takeTile() {
        if(tiles.isEmpty()){
            return null;
        }
        return  tiles.remove(0);
    }

}
