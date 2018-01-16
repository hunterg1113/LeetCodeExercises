package com.example;

public class Main
{
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] array = new char[9][9];

//        [[".",".","4",".",".",".","6","3","."],
//        [".",".",".",".",".",".",".",".","."],
//        ["5",".",".",".",".",".",".","9","."],
//
//        [".",".",".","5",".",".",".",".","."],
//        [".",".",".",".",".",".",".",".","."],
//        [".",".",".",".",".",".",".",".","."]]

        array[0][0] = '.';
        array[0][1] = '.';
        array[0][2] = '4';
        array[0][3] = '.';
        array[0][4] = '.';
        array[0][5] = '.';
        array[0][6] = '6';
        array[0][7] = '3';
        array[0][8] = '.';

        array[1][0] = '.';
        array[1][1] = '.';
        array[1][2] = '.';
        array[1][3] = '.';
        array[1][4] = '.';
        array[1][5] = '.';
        array[1][6] = '.';
        array[1][7] = '.';
        array[1][8] = '.';

        array[2][0] = '5';
        array[2][1] = '.';
        array[2][2] = '.';
        array[2][3] = '.';
        array[2][4] = '.';
        array[2][5] = '.';
        array[2][6] = '.';
        array[2][7] = '9';
        array[2][8] = '.';

//        [".",".",".","5","6",".",".",".","."],
//        ["4",".","3",".",".",".",".",".","1"],
//        [".",".",".","7",".",".",".",".","."],

        array[3][0] = '.';
        array[3][1] = '.';
        array[3][2] = '.';
        array[3][3] = '5';
        array[3][4] = '6';
        array[3][5] = '.';
        array[3][6] = '.';
        array[3][7] = '.';
        array[3][8] = '.';

        array[4][0] = '4';
        array[4][1] = '.';
        array[4][2] = '3';
        array[4][3] = '.';
        array[4][4] = '.';
        array[4][5] = '.';
        array[4][6] = '.';
        array[4][7] = '.';
        array[4][8] = '.';

        array[5][0] = '.';
        array[5][1] = '.';
        array[5][2] = '.';
        array[5][3] = '7';
        array[5][4] = '.';
        array[5][5] = '.';
        array[5][6] = '.';
        array[5][7] = '.';
        array[5][8] = '.';

        array[6][0] = '.';
        array[6][1] = '.';
        array[6][2] = '.';
        array[6][3] = '5';
        array[6][4] = '.';
        array[6][5] = '.';
        array[6][6] = '.';
        array[6][7] = '.';
        array[6][8] = '.';

        array[7][0] = '.';
        array[7][1] = '.';
        array[7][2] = '.';
        array[7][3] = '.';
        array[7][4] = '.';
        array[7][5] = '.';
        array[7][6] = '.';
        array[7][7] = '.';
        array[7][8] = '.';

        array[8][0] = '.';
        array[8][1] = '.';
        array[8][2] = '.';
        array[8][3] = '.';
        array[8][4] = '.';
        array[8][5] = '.';
        array[8][6] = '.';
        array[8][7] = '.';
        array[8][8] = '.';

        for (int i = 0; i < 9; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                if (array[i][j] == '.') System.out.print(" |");
                else System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }

        System.out.println(solution.isValidSudoku(array));
    }
}
