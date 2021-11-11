package Week10.Chess;

public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        int diffX = x - this.getCoordinatesX();
        int diffY = y - this.getCoordinatesY();
        if (Math.abs(diffX) != Math.abs(diffY)) {
            return false;
        }
        if (diffX == diffY) {
            return checkPositiveDiagonal(board, x, y);
        }
        // diffX = - diffY
        return checkNegativeDiagonal(board, x, y);
    }

    private boolean checkPositiveDiagonal(Board board, int x, int y) {
        // x1 - y1 = x2 - y2 -> diff1 = diff2
        int diff1 = this.getCoordinatesX() - this.getCoordinatesY();
        int min = Math.min(x, this.getCoordinatesX());
        int max = Math.max(x, this.getCoordinatesX());
        for (Piece p : board.getPieces()) {
            int diff2 = p.getCoordinatesX() - p.getCoordinatesY();
            if (diff1 == diff2) {       // cùng chéo // chéo chính
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

    private boolean checkNegativeDiagonal(Board board, int x, int y) {
        // x1 + y1 = x2 + y2 -> diff1 = diff2
        int diff1 = this.getCoordinatesX() + this.getCoordinatesY();
        int min = Math.min(x, this.getCoordinatesX());
        int max = Math.max(x, this.getCoordinatesX());
        for (Piece p : board.getPieces()) {
            int diff2 = p.getCoordinatesX() + p.getCoordinatesY();
            if (diff1 == diff2) {       // cùng chéo // chéo phụ
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

