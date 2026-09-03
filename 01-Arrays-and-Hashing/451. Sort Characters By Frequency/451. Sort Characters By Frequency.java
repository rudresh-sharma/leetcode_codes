1class Solution {
2    public String frequencySort(String s) {
3
4        int n = s.length();
5        var map = new HashMap<Character, Integer> ();
6
7        for(int i=0; i<n; i++){
8            char ch = s.charAt(i);
9            map.put(ch, map.getOrDefault(ch,0)+1);
10        }
11
12        List<Map.Entry<Character,Integer>> list =
13
14            map.entrySet()
15            .stream()
16.sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).toList();
17        StringBuilder ans = new StringBuilder();
18
19        for(Map.Entry<Character,Integer> entry : list){
20            String  t = entry.getKey()+;
21            ans.append(t.repeat(entry.getValue()));
22        }
23
24        return ans.toString();
25    }
26}