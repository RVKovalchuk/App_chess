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

        if (toColumn - column == 0 && toLine - line == 0) {
            System.out.println("You must change position of your chessPiece");
            return false;
        }

        if (toColumn > 7 || toLine > 7 || toColumn < 0 || toLine < 0) {
            System.out.println("You can't go to outside of chessBoard");
            return false;
        }

        if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) || (Math.abs(toColumn - column) == 2 && Math.abs(toLine - line) == 1)) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}