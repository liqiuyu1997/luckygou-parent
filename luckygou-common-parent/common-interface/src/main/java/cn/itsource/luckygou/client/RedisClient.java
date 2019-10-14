package cn.itsource.luckygou.client;

import cn.itsource.luckygou.client.impl.RedisClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "LUCKYGOU-COMMON",fallback = RedisClientImpl.class)
public interface RedisClient {
    /**
     * 获取缓存数据
     */
    @GetMapping("/redis")
    public String get(@RequestParam("key") String key);

    /**
     * 设置缓存数据
     */
    @PostMapping("/redis")
    public void set(@RequestParam("key") String key, @RequestParam("value") String value);


}
