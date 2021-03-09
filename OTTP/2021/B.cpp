/*
There is a game called "Unique Bid Auction". Formally, there are n participants, the i-th participant chose the number ai. The winner of the game is such a participant that the number he chose is unique (i. e. nobody else chose this number except him) and is minimal (i. e. among all unique values of a the minimum one is the winning one).
Your task is to find the index of the participant who won the game (or -1 if there is no winner). Indexing is 1-based, i. e. the participants are numbered from 1 to n.
You have to answer t independent test cases.
INPUT
The first line of the input contains one integer t (1<=t<=2*10^4) — the number of test cases. Then t test cases follow.
The first line of the test case contains one integer n (1<=n<=2*10^5) — the number of participants. The second line of the test case contains n integers a1,a2,…,an (1<=ai<=n), where ai is the i-th participant chosen number.
It is guaranteed that the sum of n does not exceed 2*10^5.
OUTPUT
For each test case, print the answer — the index of the participant who won the game (or -1 if there is no winner). Note that the answer is always unique.
SAMPLE INPUT
6
2
1 1
3
2 1 3
4
2 2 2 3
1
1
5
2 3 2 4 2
6
1 1 5 5 4 4
SAMPLE OUTPUT
-1
2
4
1
2
-1
*/

#include<iostream>

int getIndex(int n);

int main() {
	int t;
	std::cin >> t;
	for(int caso = 0; caso < t; caso++) {
		int n;
		std::cin >> n;
		std::cout << getIndex(n) << "\n";
	}
}

int getIndex(int n){
	int a[n] = {}, numeroJugador[n];
	for (int i = 0; i < n; i++){
		int ai;
		std::cin >> ai;
		--ai;
		a[ai]++;
		numeroJugador[ai] = i+1;
	}
	for(int i = 0; i < n; i++){
		if(a[i] == 1){
			return numeroJugador[i];
		}
	}
	return -1;
}
