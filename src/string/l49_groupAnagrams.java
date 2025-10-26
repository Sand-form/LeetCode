package string;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class l49_groupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();

        int start = line.indexOf('[');
        int end = line.indexOf(']');
        String str = line.substring(start + 1, end).trim();

        String[] parts = str.split(",");
        List<String> list = new ArrayList<>();
        for(String part : parts) {
            part = part.trim();
            // 除去首尾双引号
            if (part.startsWith("\"") && part.endsWith("\"")) {
                part = part.substring(1, part.length() - 1);
            }
            if(!part.isEmpty()) {
                list.add(part);
            }
        }

        // 转换成数组
        String[] strs = list.toArray(new String[0]);

        // 调用分组函数
        List<List<String>> res = groupAnagrams(strs);
        // 格式化输出
        printResults(res);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            // 转换成字符数组后排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // 希望把字母一样、顺序不同的单词放到同一组中
            /*if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);*/
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void printResults(List<List<String>> res) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < res.size(); i++) {
            List<String> group = res.get(i);
            sb.append("[");
            for(int j = 0; j < group.size(); j++) {
                sb.append("\"").append(group.get(j)).append("\"");
                if(j != group.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if(i != res.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
