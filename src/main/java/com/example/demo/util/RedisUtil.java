package com.example.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.springframework.data.redis.core.ScanOptions.scanOptions;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/09 下午 2:00
 */
@Component
public class RedisUtil {
    private static final Logger LOGGER= LogManager.getLogger();
    @Autowired
    public  void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }
    private static StringRedisTemplate redisTemplate;


    /**
     * 写入
     * @param key
     * @param value
     * @return
     */
    public static boolean set(String key,String value){
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
           operations.set(key,value);
        } catch (Exception e) {
          LOGGER.error(e.getLocalizedMessage(),e);
          result=true;
        }

        return result;
    }

    /**
     *写入缓存设置时效时间
     * @param key
     * @param value
     * @param second
     * @return
     */
    public static boolean set(String key,String value, long second){
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            redisTemplate.expire(key, second, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(),e);
            result=true;
        }
        return result;
    }

    /**
     * 读取
     * @param key
     * @return
     */
    public static Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 模糊查询
     * @param key
     * @return
     */
   public static List<Object> getAll(String key){
        List<Object> list=new ArrayList<>();
        Set set= redisTemplate.keys(key+"*");
        return redisTemplate.opsForValue().multiGet(set);
   }

    /**
     * 删除
     * @param key
     * @return
     */
   public static boolean del(String key){
       return redisTemplate.delete(key);
   }
    /**
     * 批量删除
     * @param key
     * @return
     */
    public static boolean delPattern(String key){
        boolean result=false;
        try {
            Set<String>set=redisTemplate.keys(key+"*");
            if(!CollectionUtils.isEmpty(set)){
                redisTemplate.delete(set);
            }
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage(),e);
            result=true;
        }
        return result ;
    }
    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public static void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }
    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public static Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     * 哈希设值设置有效期
     * @param key
     * @param hashKey
     * @param value
     * @param second
     */
    public static void hmSet(String key, Object hashKey, Object value,Long second){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
        redisTemplate.expire(key,second,TimeUnit.SECONDS);
    }

    /**
     * 批量获取哈希
     * @param key
     * @return
     */
    public static List<Object> hmgetByKey(String key){
        return redisTemplate.opsForHash().values(key);
    }
}
