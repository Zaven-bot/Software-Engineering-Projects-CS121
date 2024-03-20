import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { 
        super(c);
    }

    public String toString() {
	    if (color() == Color.BLACK) {
            return "bq";
        } else {
            return "wq";
        }
    }

    // queen @ d1
    public List<String> moves(Board b, String loc) {
        List<String> queenMoves = new ArrayList<>();

        // Directions for queen
        int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = {1, 1, 1, 0, -1, -1, -1, 0};

        int currRow = loc.charAt(1) - '0'; // 1
        int currCol = loc.charAt(0) - '`'; // 4
        int destRow = 0;
        int destCol = 0;

        for (int dest = 0; dest < 8; dest++) {
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
                        queenMoves.add(newPosition);
                    // If destination has enemy
                    } else if (this.color() != destPiece.color()) {
                        // add destination to queenMoves and stop moving
                        // in this direction
                        queenMoves.add(newPosition);
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

        return queenMoves;
    }

}