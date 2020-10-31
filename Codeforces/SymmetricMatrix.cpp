/*SYMMETRIC MATRIX
 Masha has n types of tiles of size 2 x 2. Each cell of the tile contains one integer. Masha has an infinite number of tiles of each type.
 Masha decides to construct the square of size m x m consisting of the given tiles. This square also has to be a symmetric with respect to the main diagonal matrix, and each cell of this square has to be covered with exactly one tile cell, and also sides of tiles should be parallel to the sides of the square. All placed tiles cannot intersect with each other. Also, each tile should lie inside the square. See the picture in Notes section for better understanding.
 Symmetric with respect to the main diagonal matrix is such a square s that for each pair (i, j) the condition s[i][j] == s[j][i] holds. I.e. it is true that the element written in the i-row and j-th column equals to the element written in the j-th rown and i-th column.
 Your task is to determine if Masha can construct a square of size m x m which is a symmetric matrix and consists of tiles she has. Masha can use any number of tiles of each type she has to construct the square. Note that she can not rotate tiles, she can only place them in the orientation they have in the input.
 
 You have to answer t independent test cases.
 INPUT
 The first line of the input contains one integer t(1<=t<=100) - the number of test cases. Then t test cases follow.
 The first line of the test case contains two integers n and m (1<= n, m <= 100) — the number of types of tiles and the size of the square Masha wants to construct.
 The next 2n lines of the test case contain descriptions of tiles types. Types of tiles are written one after another, each type is written on two lines.
 The first line of the description contains two positive (greater than zero) integers not exceeding 100 — the number written in the top left corner of the tile and the number written in the top right corner of the tile of the current type. The second line of the description contains two positive (greater than zero) integers not exceeding 100 - the number written in the bottom left corner of the tile and the number written in the bottom right corner of the tile of the current type. It is forbidden to rotate tiles, it is only allowed to place them in the orientation they have in the input.
 OUTPUT
 For each test case print YES if Masha can construct the square of size m x m which is a symmetric matrix. Otherwise, print NO.
 SAMPLE INPUT
 6
 3 4
 1 2
 5 6
 5 7
 7 4
 8 9
 9 8
 2 5
 1 1
 1 1
 2 2
 2 2
 1 100
 10 10
 10 10
 1 2
 4 5
 8 4
 2 2
 1 1
 1 1
 1 2
 3 4
 1 2
 1 1
 1 1
 SAMPLE OUTPUT
 YES
 NO
 YES
 NO
 YES
 YES
 */

#include<stdio.h>

int main(){
  int t;
  scanf("%d", &t);
  for (int caso = 0; caso < t; caso++) {
    int n, m;
    scanf("%d %d", &n, &m);
    bool sePuede = false;
    for (int i = 0; i < n; i++) {
      int a, b, c, d;
      scanf("%d %d %d %d", &a, &b, &c, &d);
      if (b == c) {
        sePuede = true;
      }
    }
    sePuede = (m&1) == 0 && sePuede;
    printf(sePuede ? "YES": "NO");
    printf("\n");
  }
}
