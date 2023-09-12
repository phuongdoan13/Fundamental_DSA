package Part3_DataStructures.c11_HashTable;

import java.util.*;
public class Leetcode_Hash {
    public List<List<String>> findDuplicate(String[] paths) {
        /*
            Q609. Find Duplicate File in System
            Given a list paths of directory info, including the directory path, and all the files with contents in this directory, 
            return all the duplicate files in the file system in terms of their paths. 
            You may return the answer in any order.
            A group of duplicate files consists of at least two files that have the same content.   
        */
        Map<String, List<String>> map = new HashMap<>();
        for(String p : paths){
            String[] values = p.split(" ");
            for(int i = 1; i < values.length; i++){
                String[] fn_content = values[i].split("\\(");
                fn_content[1] = fn_content[1].substring(0, fn_content[1].length() - 1);
                List<String> list = map.getOrDefault(fn_content[1], new ArrayList<String>());
                list.add(values[0] + "/" + fn_content[0]);
                map.put(fn_content[1], list);
            }
        }
        List <List<String>> ans = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1)
                ans.add(map.get(key));
        }
        return ans;
    }
}
