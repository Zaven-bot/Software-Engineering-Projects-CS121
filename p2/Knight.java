import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
	    if (color() == Color.BLACK) {
            return "bn";
        } else {
            return "wn";
        }
    }

    public List<String> moves(Board b, String loc) {
        List<String> knightMoves = new ArrayList<>();
        // Directions for queen
        int[] x = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] y = {1, 2, 2, 1, -1, -2, -2, -1};

        int currRow = loc.charAt(1) - '0';
        int currCol = loc.charAt(0) - '`';
        int destRow = 0;
        int destCol = 0;

        for (int dest = 0; dest < 8; dest++) {
            destRow = currRow + y[dest];
            destCol = currCol + x[dest];

            if (destCol >= 1 && destCol <= 8 && destRow >= 1 && destRow <= 8) {
                char charCol = (char)(destCol + '`');
                String newPosition = String.valueOf(charCol) + destRow;

                // get the piece at newPosition
                Piece destPiece = b.getPiece(newPosition);
                // if its null or an opponent
                if (destPiece == null || destPiece.color() != this.color()) {
                    // add newPosition to knightMoves
                    knightMoves.add(newPosition);
                } 
            }   
        }
        return knightMoves;
    }

}