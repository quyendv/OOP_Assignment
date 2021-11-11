package Week10.Chess;

import java.util.ArrayList;

public class Game {
    private Board board;
    private final ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * Move piece to (x, y) if canned.
     * @param piece inputPiece
     * @param x x
     * @param y y
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Piece targetPiece = board.getAt(x, y);
            if (targetPiece == null) {
                moveHistory.add(new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece));
            } else {
                moveHistory.add(new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece, targetPiece));
                board.removeAt(x, y);
            }
            // board.addPiece(piece); // piece k mất, chỉ đổi tọa độ -> k cần add
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
