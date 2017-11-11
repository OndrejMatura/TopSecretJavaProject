package checkers;

public class Board {

    public final static int WIDTHHEIGHT = 8;
    final Field[][] fields;

    public void print() {
        System.out.println("\n     a   b   c   d   e   f   g   h     ".toUpperCase());
        System.out.println("   |---|---|---|---|---|---|---|---|   ");

        for (int y = 0; y < fields.length; y++) {
            System.out.print(" ");
            System.out.print((y + 1) + " |");

            for (int x = 0; x < fields[y].length; x++) {
                switch (fields[y][x].getPlayer()) {
                    case 0:
                        System.out.print("   ");
                        break;
                    case 1:
                        System.out.print(" X ");
                        break;
                    case 2:
                        System.out.print(" O ");
                        break;
                }
                System.out.print("|");
            }
            System.out.print(" " + (y + 1) + " \n   |---|---|---|---|---|---|---|---|   ");
            System.out.println();
        }
        System.out.println("     a   b   c   d   e   f   g   h     ".toUpperCase());
    }

    public void moveField(int x1, int y1, int x2, int y2) {
        getField(x1, y1).moveTo(getField(x2, y2));
    }

    public Field getField(int x, int y) {
        return fields[y][x];
    }

    public Field getField(Position pos) {
        return fields[pos.getY()][pos.getX()];
    }

    public Field getField(String pos) {
        char[] row = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        pos = pos.toLowerCase();
        if (pos.matches("[abcdefgh][12345678]")) {
            int x = 0;
            for (int i = 0; i < row.length; i++) {
                if (pos.charAt(0) == row[i]) {
                    x = i;
                    break;
                }
            }
            int y = Integer.parseInt(pos.substring(1)) - 1;
            return fields[y][x];
        }
        return fields[0][0];
    }

    public Board() {
//        int[][] placement = {
//            {0, 1, 0, 1, 0, 1, 0, 1},
//            {1, 0, 1, 0, 1, 0, 1, 0},
//            {0, 1, 0, 1, 0, 1, 0, 1},
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {2, 0, 2, 0, 2, 0, 2, 0},
//            {0, 2, 0, 2, 0, 2, 0, 2},
//            {2, 0, 2, 0, 2, 0, 2, 0},};

//        int[][] placement = {
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 1, 0, 1, 0, 1, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 1, 0, 1, 0},
//            {0, 0, 0, 2, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0},};
        int[][] placement = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 2, 0, 2, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 2, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},};

        fields = new Field[WIDTHHEIGHT][WIDTHHEIGHT];
        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields[y].length; x++) {
                fields[y][x] = new Field(x, y, placement[y][x], this);
            }
        }

        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields[y].length; x++) {
                fields[y][x].checkMoves();
            }
        }

    }
}
