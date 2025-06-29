package com.ragul.demo.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//not working
public class RateLimiter {
    public static void main(String[] args) {
        String userid = "user1";
        long currentTime = System.currentTimeMillis();
        Map<String, Long> userList = new HashMap<>();

        if(userList.containsKey(userid)){
            Long time = userList.get(userid);

            if(time<currentTime){

            }

        }else{
            userList.put(userid, currentTime);
        }
    }
}
