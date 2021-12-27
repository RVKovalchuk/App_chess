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
        if (toColumn - column != 0) {
            System.out.println("Pawn can't do it");
            return false;
        }

        if (toColumn > 7 || toLine > 7 || toColumn < 0 || toLine < 0) {
            System.out.println("You can't go outside of chessBoard");
            return false;
        }

        if (color.equals("Black") && line == 6 && (toLine < line) && (Math.abs(toLine - line) == 1 || Math.abs(toLine - line) == 2)) {
            return true;
        } else if (color.equals("Black") && (toLine < line) && (Math.abs(toLine - line) == 1)) {
            return true;
        }

        if (color.equals("White") && line == 1 && (toLine > line) && (toLine - line == 1 || toLine - line == 2)) {
            return true;
        } else if (color.equals("White") && (toLine > line) && (toLine - line == 1)) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
