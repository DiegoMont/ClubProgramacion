/*
Petya is having a party soon, and he has decided to invite his n friends.
He wants to make invitations in the form of origami. For each invitation, he needs two red sheets, five green sheets, and eight blue sheets. The store sells an infinite number of notebooks of each color, but each notebook consists of only one color with k sheets. That is, each notebook contains k sheets of either red, green, or blue.
Find the minimum number of notebooks that Petya needs to buy to invite all n of his friends.
INPUT
The first line contains two integers n and k (1<=n,k<=10^8) — the number of Petya's friends and the number of sheets in each notebook respectively.
OUTPUT
Print one number — the minimum number of notebooks that Petya needs to buy.
SAMPLE INPUT
15 6
SAMPLE OUTPUT
38
*/
#include <iostream>

int main(){
  int n, k;
  std::cin >> n >> k;
  int totalNotebooks = 0;
  totalNotebooks += n*2/k;
  totalNotebooks += (n*2)%k > 0 ? 1: 0;
  totalNotebooks += n*5/k;
  totalNotebooks += (n*5)%k > 0 ? 1: 0;
  totalNotebooks += n*8/k;
  totalNotebooks += (n*8)%k > 0 ? 1: 0;
  std::cout << totalNotebooks <<  "\n";
}