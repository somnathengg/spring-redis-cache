package com.spring.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@Autowired
	private CacheManager cacheManager;

	public Object getFromCache(String cacheName, Object key) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			Cache.ValueWrapper wrapper = cache.get(key);
			if (wrapper != null) {
				System.out.println("✅ Cache hit for key: " + key);
				return wrapper.get();
			} else {
				System.out.println("❌ Cache miss for key: " + key);
			}
		}
		return null;
	}

	public void putInCache(String cacheName, Object key, Object value) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			cache.put(key, value);
			System.out.println("🔁 Cached value for key: " + key);
		}
	}

	public void evictFromCache(String cacheName, Object key) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			cache.evict(key);
			System.out.println("🗑️ Removed key: " + key + " from cache");
		}
	}

}
