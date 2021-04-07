/*
There are n students in a school class, the rating of the i-th student on Codehorses is ai. You have to form a team consisting of k students (1<=k<=n) such that the ratings of all team members are distinct.
If it is impossible to form a suitable team, print "NO" (without quotes). Otherwise print "YES", and then print k distinct numbers which should be the indices of students in the team you form. If there are multiple answers, print any of them.
INPUT
The first line contains two integers n and k (1<=k<=n<=100) — the number of students and the size of the team you have to form.
The second line contains n integers a1,a2,...,an (1<=ai<=100), where ai is the rating of i-th student.
OUTPUT
If it is impossible to form a suitable team, print "NO" (without quotes). Otherwise print "YES", and then print k distinct integers from 1 to n which should be the indices of students in the team you form. All the ratings of the students in the team should be distinct. You may print the indices in any order. If there are multiple answers, print any of them.
Assume that the students are numbered from 1 to n.
SAMPLE INPUT
5 3
15 13 15 15 12
SAMPLE OUTPUT
YES
1 2 5
*/
#include <iostream>
#include <string>

int main(){
  int n, k, a[101] = {};
  std::cin >> n >> k;
  std::string resultado = "";
  for(int i = 0; i < n; i++){
    int student;
    std::cin >> student;
    if(k > 0 && a[student] == 0){
      k--;
      a[student] = 1;
      resultado += std::to_string(i+1) + " ";
    }
  }
  if(k == 0)
    std::cout << "YES\n" << resultado << "\n";
  else
    std::cout << "NO\n";
}