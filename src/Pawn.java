public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toColumn - column == 0) && toColumn <= 7 && toLine <= 7 && toColumn >= 0 && toLine >= 0 &&
                (toLine - line != 0) && chessBoard.board[toLine][toColumn] == null) {
            if (color.equals("Black") && line == 6 && (toLine < line) && ((Math.abs(toLine - line) == 1 || Math.abs(toLine - line) == 2))) {
                return true;
            } else if (color.equals("Black") && line != 6 && (toLine < line) && (Math.abs(toLine - line) == 1)) {
                return true;
            } else if (color.equals("White") && line == 1 && (toLine > line) && ((toLine - line == 1 || toLine - line == 2))) {
                return true;
            } else return color.equals("White") && line != 1 && (toLine > line) && (toLine - line == 1);
        }
        if ((Math.abs(toColumn - column) == 1) && toColumn <= 7 && toLine <= 7 && toColumn >= 0 && toLine >= 0 &&
                (Math.abs(toLine - line) == 1) && chessBoard.board[toLine][toColumn] != null &&
                !(chessBoard.board[toLine][toColumn].getSymbol().equals("K")) &&
                !(chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
            if (color.equals("Black") && (toLine < line)) {
                return true;
            } else return color.equals("White") && (toLine > line);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}