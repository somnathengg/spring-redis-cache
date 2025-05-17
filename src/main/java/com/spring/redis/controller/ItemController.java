package com.spring.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.entity.Item;
import com.spring.redis.service.ItemService;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController {

	@Autowired
    private ItemService itemService;
  
    @GetMapping("/get-all-items")
    public List<Item> getAllItems() {
    	System.out.println("inside get all items");
        return itemService.items();
    }

    @GetMapping("/get-item-by-id")
    public Item getItem(@RequestParam("id") Integer id) {
    	System.out.println("inside get item path variable >>"+id);
        return itemService.getItem(id);
    }

    @PostMapping("/create-item")
    public Item createItem(@RequestBody Item request) {
    	System.out.println("inside create item");
        return itemService.createItem(request);
    }

    @PutMapping("/update-item-by-id")
    public Item updateItem(@RequestParam("id") Integer id, @RequestBody Item request) {
    	System.out.println("inside update item put");
        return itemService.updateItem(id, request);
    }
}
