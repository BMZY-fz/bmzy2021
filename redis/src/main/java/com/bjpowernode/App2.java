package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.116.129", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            jedis.hset("website", "baidu", "www.baidu.com");
            String s = jedis.hget("website", "baidu");
            System.out.println(s);

            Map<String, String> map = new HashMap<>();
            map.put("id", "666");
            map.put("name", "ysd");
            map.put("age", "240");
            jedis.hmset("大马猴", map);
            List<String> list = jedis.hmget("大马猴", "id", "name", "age");
            for (String s1 : list) {
                System.out.println(s1);
            }


        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            RedisUtils.close();
        }
    }
}
