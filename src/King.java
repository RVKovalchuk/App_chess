public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn <= 7 && toLine <= 7 && toColumn >= 0 && toLine >= 0) {
            if (!(toColumn - column == 0 && toLine - line == 0)) {
                if (chessBoard.board[toLine][toColumn] == null ||
                        !(chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
                    if ((toColumn - column == 0 || Math.abs(toColumn - column) == 1) && (toLine - line == 0 ||
                            Math.abs(toLine - line) == 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < board.board.length; i++){
            for (int j = 0; j < board.board[i].length; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color) &&
                        board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}