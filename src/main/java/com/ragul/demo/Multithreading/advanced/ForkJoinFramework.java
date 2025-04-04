package com.ragul.demo.Multithreading.advanced;
//The ExecutorService manages threads, making it easier to execute tasks concurrently, while the Fork/Join Framework is designed for parallel processing, allowing you to divide and conquer complex tasks.

//The Fork/Join Framework is a more specialized tool designed for parallel processing.
//It is ideal for situations where you need to divide a large task into smaller sub-tasks (fork() method) and then combine their result (join())


import java.util.concurrent.ForkJoinPool;

//Result solve(Problem problem) {
//        if (problem is small)
//        directly solve problem
//	else {
//                split problem into independent parts
//                fork new subtasks to solve each part
//                join all subtasks
//                compose result from subresults
//        }
//}
public class ForkJoinFramework {
       //  var numberOfProcessors = Runtime.getRunTime().availableProcessors();

        ForkJoinPool pool = new ForkJoinPool(4);


        }
