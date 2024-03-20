import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { 
        super(c);
    }

    public String toString() {
	    if (color() == Color.BLACK) {
            return "bb";
        } else {
            return "wb";
        }
    }

    public List<String> moves(Board b, String loc) {
        List<String> bishopMoves = new ArrayList<>();

        // Directions for bishop
        int[] x = {-1, 1, 1, -1};
        int[] y = {1, 1, -1, -1};

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
                    // If destination is empty
                    if (destPiece == null) {
                        bishopMoves.add(newPosition);
                    // If destination has enemy
                    } else if (this.color() != destPiece.color()) {
                        // add destination to bishopMoves and stop moving
                        // in this direction
                        bishopMoves.add(newPosition);
                        obstacle = true;
                    // If destination has ally
                    } else if (this.color() == destPiece.color()) {
                        // stop moving in this direction
                        obstacle = true;
                    }
                } else {
                    // stop moving out of bounds
                    obstacle = true;
                }
            }
        }

        return bishopMoves;
    }

}