package Week11.Chess;

public class Rook extends Piece {

    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }

        if (this.getCoordinatesX() == x) {      // sameColumn
            return checkColumn(board, x, y);
        }
        return checkRow(board, x, y);           // sameRow
    }

    private boolean checkColumn(Board board, int x, int y) {
        int min = Math.min(this.getCoordinatesY(), y);
        int max = Math.max(this.getCoordinatesY(), y);
        for (Piece p : board.getPieces()) {
            if (p.getCoordinatesX() == x) {
                if (p.getCoordinatesY() > min && p.getCoordinatesY() < max) {
                    return false;
                }
                if (p.getCoordinatesY() == y && p.getColor().equals(this.getColor())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRow(Board board, int x, int y) {
        int min = Math.min(this.getCoordinatesX(), x);
        int max = Math.max(this.getCoordinatesX(), x);
        for (Piece p : board.getPieces()) {
            if (p.getCoordinatesY() == y) {
                if (p.getCoordinatesX() > min && p.getCoordinatesX() < max) {
                    return false;
                }
                if (p.getCoordinatesX() == x && p.getColor().equals(this.getColor())) {
                    return false;
                }
            }
        }
        return true;
    }
}
