import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Tile> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Tile> getHand() {
        return hand;
    }

    public void addTile(Tile tile) {
        hand.add(tile);
    }

    public void removeTile(Tile tile){
        hand.remove(tile);
    }

    public void showHand(){
        System.out.println(name + " имеет " + hand);
    }

}