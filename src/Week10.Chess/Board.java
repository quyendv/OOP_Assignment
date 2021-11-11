package Week10.Chess;

import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {
    }

    /**
     * Add piece to board if no pieces exist at (x, y).
     * @param piece newPiece.
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesX())
                && getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null) {
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return (x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT);
    }

    /**
     * Remove piece at (x, y).
     * @param x coordinateX
     * @param y coordinateY
     */
    public void removeAt(int x, int y) {
        if (validate(x, y)) {
            Piece p = getAt(x, y);
            if (p != null) {
                pieces.remove(p);
            }
        }
    }

    /**
     * Get piece at (x, y).
     * @param x coordinateX
     * @param y coordinateY
     * @return piece.
     */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
