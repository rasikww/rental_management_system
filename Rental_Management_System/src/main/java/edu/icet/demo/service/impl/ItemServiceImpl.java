package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.HardwareItem;
import edu.icet.demo.entity.HardwareItemEntity;
import edu.icet.demo.repository.HardwareItemRepository;
import edu.icet.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    final HardwareItemRepository repository;
    final ObjectMapper mapper;

    @Override
    public Boolean addItem(HardwareItem item) {
        Boolean isSaved = false;
        HardwareItemEntity itemEntity = null;
        try {
            itemEntity = mapper.convertValue(item, HardwareItemEntity.class);
            repository.save(itemEntity);
            isSaved = true;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isSaved;
    }

    @Override
    public List<HardwareItem> getAll() {
        List<HardwareItemEntity> hardwareItemEntityList = repository.findAll();
        List<HardwareItem> hardwareItemList = new ArrayList<>();

        hardwareItemEntityList.forEach(hardwareItemEntity ->
                hardwareItemList.add(
                        mapper.convertValue(hardwareItemEntity, HardwareItem.class)
                ));
        return hardwareItemList;
    }

    @Override
    public Boolean deleteItemById(Long id) {
        Boolean isDeleted = false;
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                isDeleted = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public Boolean updateItem(HardwareItem item) {
        Boolean isUpdated = false;
        try {
            if (repository.findById(item.getItemId()).isPresent()){
                repository.save(mapper.convertValue(item, HardwareItemEntity.class)
                );
                isUpdated = true;
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public HardwareItem findById(Long id) {
        return mapper.convertValue(repository.findById(id), HardwareItem.class);
    }
}
