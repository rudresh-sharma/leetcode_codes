1class Solution {
2    public int gcdOfOddEvenSums(int n) {
3        int sumOdd = n*n;
4        int sumEven = n*(n+1);
5
6        return gcd(sumOdd, sumEven);
7
8    }
9
10    static int gcd(int a, int b){
11
12
13       while(b != 0){
14            int temp = a%b;
15            a = b;
16            b = temp;
17       }
18       return a;
19    }
20}