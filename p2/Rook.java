import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
	    if (color() == Color.BLACK) {
            return "br";
        } else {
            return "wr";
        }
    }

    public List<String> moves(Board b, String loc) {
        List<String> rookMoves = new ArrayList<>();

        // Directions for rook
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};

        // Turn character coords to integers
        int currRow = loc.charAt(1) - '0';
        int currCol = loc.charAt(0) - '`';
        int destRow = 0;
        int destCol = 0;

        for (int dest = 0; dest < 4; dest++) {
            destRow = currRow;
            destCol = currCol;

            boolean obstacle = false;

            while (!obstacle) {

                destRow += y[dest];
                destCol += x[dest];

                if (destCol >= 1 && destCol <= 8 && destRow >= 1 && destRow <= 8) {
                    char charCol = (char)(destCol + '`');

                    String newPosition = String.valueOf(charCol) + destRow;

                    // get the piece at newPosition
                    Piece destPiece = b.getPiece(newPosition);

                    // if dest is empty
                    if (destPiece == null) {
                        // add newPosition to rookMoves
                        rookMoves.add(newPosition);
                    // if dest has opponent
                    } else if (destPiece.color() != this.color()) {
                        // add newPosition to rookMoves and stop moving
                        // in this direction
                        rookMoves.add(newPosition);
                        obstacle = true;
                    // else if its an ally piece
                    } else if (destPiece.color() == this.color()) {
                        // stop moving in this direction
                        obstacle = true;
                    }
                } else {
                    // stop moving out of bounds
                    obstacle = true;
                }
            }
        }
        return rookMoves;
    }

}