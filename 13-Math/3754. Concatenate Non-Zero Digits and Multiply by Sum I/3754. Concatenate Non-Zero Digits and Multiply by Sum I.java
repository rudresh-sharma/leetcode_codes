1class Solution {
2    public long sumAndMultiply(int n) {
3        StringBuilder num = new StringBuilder();
4        String s = String.valueOf(n);
5
6        if(n==0) return 0L;
7        long sum = 0;
8        for(int i=0; i<s.length(); i++){
9            char ch = s.charAt(i);
10            if(s.charAt(i) != '0'){
11                num.append(s.charAt(i));
12                sum += ch-'0';
13            }
14        }
15
16        long ans = Long.parseLong(num.toString());
17
18        ans *= sum;
19
20        return ans;
21    }
22}