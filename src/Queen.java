public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn <= 7 && toLine <= 7 && toColumn >= 0 && toLine >= 0 &&
                !(toColumn - column == 0 && toLine - line == 0) &&
                (chessBoard.board[toLine][toColumn] == null ||
                        !(chessBoard.board[toLine][toColumn].getColor().equals(this.color)))) {
            if (toColumn - column > 0 && toLine - line == 0) {
                for (int i = column; i < toColumn; i++) {
                    if (i == column) {
                        continue;
                    }
                    return chessBoard.board[line][i] == null;
                }
            } else if (toColumn - column == 0 && toLine - line > 0) {
                for (int i = line; i < toLine; i++) {
                    if (i == line) {
                        continue;
                    }
                    return chessBoard.board[i][column] == null;
                }
            } else if (toColumn - column < 0 && toLine - line == 0) {
                for (int i = column; i > toColumn; i--) {
                    if (i == column) {
                        continue;
                    }
                    return chessBoard.board[line][i] == null;
                }
            } else if (toColumn - column == 0 && toLine - line < 0) {
                for (int i = line; i > toLine; i--) {
                    if (i == line) {
                        continue;
                    }
                    return chessBoard.board[i][column] == null;
                }
            } else if ((Math.abs(toColumn - column) == Math.abs(toLine - line))) {
                if (toLine > line) {
                    for (int i = line; i < toLine; i++) {
                        if (i == line) {
                            continue;
                        }
                        if (chessBoard.board[i][column + Math.abs(i - line) * (toColumn - column) /
                                Math.abs(toColumn - column)] == null) {
                            return true;
                        }
                    }
                } else if (toLine < line) {
                    for (int i = line; i > toLine; i--) {
                        if (i == line) {
                            continue;
                        }
                        if (chessBoard.board[i][column + Math.abs(i - line) * (toColumn - column) /
                                Math.abs(toColumn - column)] == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}