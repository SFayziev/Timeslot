package com.sh.timeslot.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

//@Configuration
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
//        GuavaCache cache1 = new GuavaCache("book", CacheBuilder.newBuilder().build());
//        GuavaCache cache2 = new GuavaCache("books", CacheBuilder.newBuilder()
//                .expireAfterAccess(30, TimeUnit.MINUTES)
//                .build());
//        simpleCacheManager.setCaches(Arrays.asList(cache1, cache2));
        return simpleCacheManager;
    }


}
