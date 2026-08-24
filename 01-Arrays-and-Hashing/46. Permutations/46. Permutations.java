1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3
4        return perms(nums);
5        
6    }
7
8
9    public static List<List<Integer>>  perms(int[] nums){
10        List<List<Integer>> ans = new ArrayList<List<Integer>>();
11        int n = nums.length;
12    
13        ans.add(Arrays.asList(nums[n-1]));
14
15        for(int i=n-2; i>=0; i--){
16
17             ans = insertAndReturn(ans, nums[i]);
18
19        }
20
21        return ans;
22    }
23
24
25    public static List<List<Integer>> insertAndReturn(List<List<Integer>> work, int insert){
26        List<List<Integer>> mid = new ArrayList<List<Integer>>();
27
28        for(int i=0; i<work.size(); i++){
29            List<Integer> nano = work.get(i);
30            for(int j=0; j<nano.size()+1; j++){
31            List<Integer> temp = new ArrayList<>(nano); ;
32                temp.add(j,insert);
33                mid.add(temp);
34            }
35        }
36
37        return mid;
38    }
39}