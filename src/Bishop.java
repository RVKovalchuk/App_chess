public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn <= 7 && toLine <= 7 && toColumn >= 0 && toLine >= 0) {
            if (toColumn - column != 0 && toLine - line != 0) {
                if (!chessBoard.board[toLine][toColumn].getColor().equals(this.color) ||
                        chessBoard.board[toLine][toColumn] == null) {
                    return Math.abs(toColumn - column) == Math.abs(toLine - line);
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}