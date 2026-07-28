1class Solution {
2    public List<Integer> findPeaks(int[] mountain) {
3        List<Integer> ans = new ArrayList<>();
4
5        int left = -1;
6        int right = -1;
7        for(int i=1; i<mountain.length-1; i++){
8            
9            left = mountain[i-1];
10            right = mountain[i+1];
11            
12            
13            
14            if(mountain[i]>left && mountain[i]>right){
15                ans.add(i);
16            }
17
18            
19        }
20
21        return ans;
22    }
23}