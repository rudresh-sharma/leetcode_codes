1class Solution {
2
3    public String evaluate(String s, List<List<String>> knowledge) {
4        Map<String, String> dict = new HashMap<>();
5        for (List<String> kd : knowledge) {
6            dict.put(kd.get(0), kd.get(1));
7        }
8        boolean addKey = false;
9        StringBuilder key = new StringBuilder();
10        StringBuilder res = new StringBuilder();
11        for (int i = 0; i < s.length(); i++) {
12            char c = s.charAt(i);
13            if (c == '(') {
14                addKey = true;
15            } else if (c == ')') {
16                if (dict.containsKey(key.toString())) {
17                    res.append(dict.get(key.toString()));
18                } else {
19                    res.append('?');
20                }
21                addKey = false;
22                key.setLength(0);
23            } else if (addKey) {
24                key.append(c);
25            } else {
26                res.append(c);
27            }
28        }
29        return res.toString();
30    }
31}