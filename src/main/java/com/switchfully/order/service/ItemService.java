package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.service.dtos.ItemDTO;
import com.switchfully.order.service.mappers.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTO addItem(ItemDTO itemDTO) {
        Item itemSaved = itemRepository.addItem(itemMapper.mapToItem(itemDTO));
        return itemMapper.mapToDTO(itemSaved);
    }
}
