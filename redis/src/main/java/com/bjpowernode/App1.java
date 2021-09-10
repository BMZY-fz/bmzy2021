package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class App1 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.116.129", 6379);
            Jedis jedis = pool.getResource();
            jedis.set("name", "姚森达");
            String name = jedis.get("name");
            System.out.println(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
