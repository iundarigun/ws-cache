package br.com.devcave.ws.client.config;

import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                buildPersonCache(),
                buildCountCache()));
        return simpleCacheManager;
    }

    private GuavaCache buildPersonCache() {
        return new GuavaCache("person", CacheBuilder
                .newBuilder()
                .maximumSize(500)
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build(),
                true);
    }

    private GuavaCache buildCountCache() {
        return new GuavaCache("count", CacheBuilder
                .newBuilder()
                .maximumSize(500)
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .build(),
                true);
    }
}
