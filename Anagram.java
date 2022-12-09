package com.assesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Anagrams {
	
	public static List<List<String>> groupAnagrams(String[] strs) {

	    if (strs == null || strs.length == 0) 
	    {
	      return new ArrayList<>();
	    }

	    Map<String, List<String>> anagramsMap = new HashMap<>();
	    for (String str : strs) {  			//map over strs
	      char[] arr = str.toCharArray();  //convert string to array to sort
	      Arrays.sort(arr);					//sort array
	      String sortedStr = String.valueOf(arr); //convert array back to string

	      if (!anagramsMap.containsKey(sortedStr))
	      {
	        anagramsMap.put(sortedStr, new ArrayList<>());
	      }
	      anagramsMap.get(sortedStr).add(str);
	    }

	    List<List<String>> list = new ArrayList<>();
	    for (Map.Entry<String, List<String>> anagrams : anagramsMap.entrySet()) 
	    {
	      list.add(anagrams.getValue());
	    }
	    return list;
	  }
}

public class Anagram{
	public static void main(String[] a) {
		System.out.println(Anagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
	}
}
