public class Tile {
    private int left;
    private int right;

    public Tile(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + "|" + right + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tile tile = (Tile) obj;
        return (left == tile.left && right == tile.right) ||
                (left == tile.right && right == tile.left);
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(left + right) + Integer.hashCode(left * right);
    }
}
