public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn <= 7 && toLine <= 7 && toColumn >= 0 && toLine >= 0 &&
                !(toColumn - column == 0 && toLine - line == 0) && (chessBoard.board[toLine][toColumn] == null ||
                !(chessBoard.board[toLine][toColumn].getColor().equals(this.color)))) {
            return (Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) || (Math.abs(toColumn - column) == 2 && Math.abs(toLine - line) == 1);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}