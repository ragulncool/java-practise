package com.ragul.demo.problems.DSA.easy.Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String args[]) {

        int[] nums = {0,2,3,4,6,8,9};//{0,1,2,4,5,7};//{0,4,5,6,9,11};;
        System.out.println("===BRUTAL APPROACH===");
        List<List<Integer>> summedranges = findSummaryRangesBrutalApproach(nums);

        for(List<Integer> l:summedranges){
            for(Integer l1:l){
               System.out.print(l1+" ");
            }
            System.out.println();
        }

        System.out.println("===SLIDING WINDOW APPROACH===");
        findSummaryRangesSlidingWindowApproach(nums);
    }



    private static List<List<Integer>> findSummaryRangesBrutalApproach(int[] nums) {
        List<List<Integer>> summedranges = new ArrayList<>();
        int start = 0,end=nums[0],current,past;
        for(int i=1;i<nums.length;i++) {
            current=nums[i];
            past=nums[i-1];
                if(current==past+1){
                    if(i==nums.length-1){
                        end=current;
                        List<Integer> subList1 =new ArrayList<>(); subList1.add(start);  subList1.add(end); summedranges.add(subList1);
                    }
                    continue;

                }else{
                    end=past;
                    List<Integer> subList =new ArrayList<>();  subList.add(start);  subList.add(end); summedranges.add(subList);
                    start=current;

                    if(i==nums.length-1){
                        end=current;
                        List<Integer> subList1 =new ArrayList<>(); subList1.add(start);  subList1.add(end); summedranges.add(subList1);
                    }
                }

        }
            return summedranges;
    }

    private static void findSummaryRangesSlidingWindowApproach(int[] nums) {
        for(int i=0;i<nums.length;i++){
           int start=nums[i];
           while (i+1<nums.length && nums[i]==nums[i+1]-1){
               i++; //skip numbers in b/w interval
           }
           int end = nums[i]; //new i after sliding process
            System.out.println(start+" "+end);
        }


    }

}
