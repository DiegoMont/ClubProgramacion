/*  WHERES THE BISHOP
Mihai has an 8x8 chessboard whose rows are numbered from 1 to 8 from top to bottom and whose columns are numbered from 1 to 8 from left to right.
Mihai has placed exactly one bishop on the chessboard. The bishop is not placed on the edges of the board. (In other words, the row and column of the bishop are between 2 and 7, inclusive.)
The bishop attacks in all directions diagonally, and there is no limit to the distance which the bishop can attack. Note that the cell on which the bishop is placed is also considered attacked.
Mihai has marked all squares the bishop attacks, but forgot where the bishop was! Help Mihai find the position of the bishop.

INPUT
The first line of the input contains a single integer t (1 <= t <= 36) — the number of test cases. The description of test cases follows. There is an empty line before each test case.
Each test case consists of 8 lines, each containing 8 characters. Each of these characters is either '#' or '.', denoting a square under attack and a square not under attack, respectively.
OUTPUT
For each test case, output two integers r and c (2 <= r, c <= 7) — the row and column of the bishop.
The input is generated in such a way that there is always exactly one possible location of the bishop that is not on the edge of the board.

SAMPLE INPUT
3

.....#..
#...#...
.#.#....
..#.....
.#.#....
#...#...
.....#..
......#.

#.#.....
.#......
#.#.....
...#....
....#...
.....#..
......#.
.......#

.#.....#
..#...#.
...#.#..
....#...
...#.#..
..#...#.
.#.....#
#.......
SAMPLE OUTPUT
4 3
2 2
4 5
*/

#include <stdio.h>

void parseBoard(int* board);

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        int board[8][8];
        // Parse board
        for(size_t i = 0; i < 8; i++) {
            char row[9];
            scanf("%s\n", row);
            for (size_t j = 0; j < 8; j++)
                board[i][j] = row[j] == '#' ? 1: 0;
        }
        // Search cell surrounded by #
        for(size_t i = 1; i < 7; i++)
            for (size_t j = 1; j < 7; j++) {
                int attackedCells = board[i-1][j-1] + board[i+1][j-1] + board[i+1][j+1] + board[i-1][j+1];
                if(attackedCells == 4)
                    printf("%d %d\n", i+1, j+1);
            }
    }
}