package com.switchfully.order.service.mappers;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.service.dtos.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    public ItemDTO mapToDTO(Item item) {
        return new ItemDTO(item);
    }

    public Item mapToItem(ItemDTO itemDTO) {
        return new Item(itemDTO);
    }

    public List<ItemDTO> convertItemMapToDtoList(List<Item> items) {
        return items.stream().map(ItemDTO::new).collect(Collectors.toList());
    }
}
