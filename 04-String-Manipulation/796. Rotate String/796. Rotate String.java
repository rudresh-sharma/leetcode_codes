1class Solution {
2    public boolean rotateString(String s, String goal) {
3
4        if(s.length() != goal.length()) return false;
5        String ans = s+s;
6
7        return ans.contains(goal);
8    }
9}