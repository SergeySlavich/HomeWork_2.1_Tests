import java.util.Scanner;

public class Main {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCrossTurn = true;
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
        while (true) {
            printField(field);
            if(isFieldFull(field)){
                System.out.println("Поле заполнено. Следующий ход невозможен. НИЧЬЯ!");
                break;
            }
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
                    isCrossTurn = true;
                } else {
                    isCrossTurn = false;
                }
                isCrossTurn = !isCrossTurn;
            }
        }
        System.out.println("Игра закончена!");
    }

    public static boolean isWin(char[][] field, char player){
        int sum;
        for (int i = 0; i < SIZE; i++) {
            sum = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == player) {
                    sum++;
                    if (sum == SIZE)
                        return true;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            sum = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == player) {
                    sum++;
                    if (sum == SIZE)
                        return true;
                }
            }
        }
        sum = 0;
        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] == player)
                sum++;
            if (sum == SIZE)
                return true;
        }
        sum = 0;
        for (int i = 0; i < SIZE; i++) {
            if (field[SIZE - 1 - i][i] == player)
                sum++;
            if (sum == SIZE)
                return true;
        }
        System.out.println();
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

    public static boolean isFieldFull(char[][] field){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
