import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean isCrossTurn = true;

        while (true) {
            printField(field);
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            String input = scanner.nextLine(); // "2 3"
            String[] parts = input.split(" "); // ["2" , "3"]
            int r = Integer.parseInt(parts[0]) - 1; // 2-1 = 1
            int c = Integer.parseInt(parts[1]) - 1; // 3-1 = 2

            if (field[r][c] != EMPTY) {
                System.out.println("Сюда ходить нельзя");
                continue;
            }

            field[r][c] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                printField(field);
                System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                break;
            } else {
                if (isCrossTurn) {
                    isCrossTurn = false;
                } else {
                    isCrossTurn = true;
                }
                //isCrossTurn = !isCrossTurn;
            }
        }

        System.out.println("Игра закончена!");
    }

    // !!ВНИМАНИЕ!!
    // Работает только для 3x3
    // TODO переписать метод под любое количество строк и столбцов // Выполнено!
    public static boolean isWin(char[][] field, char player) {
        int countChar = 0;     // перменная для подсчета кол-ва символов по строкам, столбцам и диагоналям
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (field[row][column] == player)
                    countChar++;

                 //System.out.println("Строка = " + countChar);
            }
            if (countChar == SIZE) {
                return true;
            }
            countChar = 0;

        }

        for (int column = 0; column < SIZE; column++) {
            for (int row = 0; row < SIZE; row++) {
                if (field[row][column] == player) {
                    countChar++;
                   // System.out.println("Столбец = " + countChar);
                }
            }
            if (countChar == SIZE)
                return true;
            countChar = 0;
        }


        for (int num = 0; num < SIZE; num++) {
            if (field[num][num] == player) {
                countChar++;
                //System.out.println("Диагональ левая = " + countChar);
            }
        }
        if (countChar == SIZE)
            return true;
        countChar = 0;


        for (int num = 0; num < SIZE; num++) {
            if (field[num][SIZE - 1 - num] == player)
                countChar++;
            //System.out.println("Диагональ правая = " + countChar);
        }
        if (countChar  == SIZE)
            return true;

        return false;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
