1class Solution {
2    public int maxProduct(int[] nums) {
3        int firstMax = 0;
4        int secondMax = 0;
5
6        for(int i=0; i<nums.length; i++){
7            if(nums[i] > firstMax){
8                secondMax = firstMax;
9                firstMax = nums[i];
10            }
11            else if(nums[i] > secondMax){
12                secondMax = nums[i];
13            }
14        }
15
16        return (firstMax-1)*(secondMax-1);
17    }
18}