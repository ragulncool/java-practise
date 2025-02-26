//package com.ragul.demo.Incomplete.WorkBreak;
//
//import java.util.*;
//
//public class WorkBreak {
//
//    public static void main(String[] args) {
//       List<String> dictList = Arrays.asList("i", "love");
//       List<String> breakedWordList =new ArrayList<>();
//       String str="ILoveYou";
//       System.out.println(breakIntoWords(dictList, str, breakedWordList));
//    }
//
//    private static List<String> breakIntoWords(List<String> dictList, String str, List<String> breakedWordList) {
//          //      for (int i=0;i<str.length();i++){
//      //  int i=;
//        int start=0,end=start+1;
//                    if(dictList.contains(str.substring(start,end).toLowerCase())){
//                        breakedWordList.add(str.substring(start,end));
//                        System.out.println("Word found in dict: "+str.substring(start,end));
//                        breakedWordList = breakIntoWords(dictList, str.substring(end+1, str.length()),breakedWordList);
//                    }else{
//                        System.out.println("Word not found in dict: "+str.substring(start,end));
//                        breakedWordList = breakIntoWords(dictList, str.substring(i),breakedWordList);
//
//                        //    return breakedWordList;
//                    }
//           //     }
//                return breakedWordList;
//    }
//}
