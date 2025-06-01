package com.spring.redis.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.redis.entity.Item;
import com.spring.redis.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> items() {
        return itemRepository.findAll();
    }

	@Cacheable(value = "items", key = "#a0")
	public Item getItem(Integer id) {
		try {
			Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
			System.out.println("Loading data from DB {}" + item);
			return item;
		} catch (Exception e) {
			System.out.println("exception inside get item db call" + e.getMessage());
			return null;
		}
	}

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @CacheEvict(value = "items", key = "#a0")
    public Item updateItem(Integer id, Item request) {
        Item item = getItem(id);
        item.setPrice(request.getPrice());
        item.setProductName(request.getProductName());
        return itemRepository.save(item);
    }
}
