package com.example.webapp.services;

import com.example.webapp.domain.Items;
import com.example.webapp.domain.Tags;
import com.example.webapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Items> findAll(){
        List<Items> items = new LinkedList<>();
        itemRepository.findAll().iterator().forEachRemaining(items::add);
        return items;
    }

    @Override
    public Items findById(Long l) {
        Optional<Items> itemOptional = itemRepository.findById(l);
        if (!itemOptional.isPresent()) {
            throw new RuntimeException("Item not found!");
        }
        return itemOptional.get();
    }

    @Override
    public Items save(Items item) {
        Items savedItem = itemRepository.save(item);
        return savedItem;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Items> productOptional = itemRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        Items item = productOptional.get();
        List<Tags> tags = new LinkedList<Tags>();
        item.getTags().iterator().forEachRemaining(tags::add);

        for (Tags tag: tags
        ) {
            item.removeTag(tag);
        }

        itemRepository.save(item);
        itemRepository.deleteById(id);

    }

}
