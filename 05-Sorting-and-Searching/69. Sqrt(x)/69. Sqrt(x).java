1class Solution {
2    public int mySqrt(int x) {
3        int half = x/2;
4
5        if(x == 1) return 1;
6
7        int left = 1;
8        int right = half;
9
10        while(left<=right){
11            int mid = left + (right-left)/2;
12            long sq = 1L*mid*mid;
13            if(sq == x){
14                return mid;
15            }
16
17            if(sq>x ){
18                right = mid-1;
19            }
20            else{
21                left = mid+1;
22            }
23
24        }
25        return right;
26    }
27}