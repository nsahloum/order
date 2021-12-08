package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemUrgencyIndicator;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.service.dtos.item.ItemDTO;
import com.switchfully.order.service.mappers.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTO addItem(ItemDTO itemDTO) {
        Item itemSaved = itemRepository.addItem(itemMapper.mapToItem(itemDTO));
        return itemMapper.mapToDTO(itemSaved);
    }

    public ItemDTO getItemById(String id){
        return itemMapper.mapToDTO(itemRepository.getItemById(id));
    }

    public List<ItemDTO> getAllItems() {
        return itemMapper.convertItemMapToDtoList(itemRepository.getAllItems()).stream()
                .sorted(Comparator.comparing(ItemDTO::getItemUrgencyIndicator))
                .toList();
    }

    public List<ItemDTO> getByUrgencyIndicator(String urgencyIndicator) {
        return itemMapper.convertItemMapToDtoList(itemRepository.getAllItems()).stream()
                .filter(itemDTO -> itemDTO.getItemUrgencyIndicator().toString().equals(urgencyIndicator))
                .collect(Collectors.toList());
    }
}
