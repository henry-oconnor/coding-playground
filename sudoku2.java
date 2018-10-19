/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in 
such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose 
the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a 
valid Sudoku puzzle according to the layout rules described above. Note that the puzzle 
represented by grid does not have to be solvable.

EXAMPLE 
for:
grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]

sudoku2(grid) = true

for:
grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]

sudoku2(grid) = false
*/

boolean sudoku2(char[][] a) {

        for (int i = 0; i < a.length; i++) {
            int rowOffset = (i / 3) * 3;

            for (int j = 0; j < a.length; j++) {
                int colOffset = (j / 3) * 3;
                if (a[i][j] != '.') {
                    if (a[i][j] == a[(i + 1) % 3 + rowOffset][(j + 1) % 3 + colOffset]
                            || a[i][j] == a[(i + 2) % 3 + rowOffset][(j + 1) % 3 + colOffset]
                            || a[i][j] == a[(i + 1) % 3 + rowOffset][(j + 2) % 3 + colOffset]
                            || a[i][j] == a[(i + 2) % 3 + rowOffset][(j + 2) % 3 + colOffset]) {
                        return false;
                    }
                    int c = 0, r = 0;
                    while (++c + i < 9) {
                        if (c < 9 && a[i][j] == a[i + c][j]) {
                            return false;
                        }
                    }
                    while (++r + j < 9) {
                        if (a[i][j] == a[i][j + r]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }