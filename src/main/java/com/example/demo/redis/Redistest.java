package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author czh
 * @version 1.0
 * @date 2022/10/7 17:52
 */
@RestController
public class Redistest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/recites")
    public String testredis(){
//        synchronized (this){
        String uuid = UUID.randomUUID().toString();
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent("lockkey", uuid, 60, TimeUnit.SECONDS);
            if (!result) {
                return "订单正在处理";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int resstock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", resstock + "");
                System.out.println("扣减成功，剩余库存：" + resstock);
            } else {
                System.out.println("库存不足");
            }
        }finally {
            if(uuid.equals(stringRedisTemplate.opsForValue().get("lockkey"))){
                stringRedisTemplate.delete("lockkey");
            }
        }
//    }
        return "end";
    }
}
