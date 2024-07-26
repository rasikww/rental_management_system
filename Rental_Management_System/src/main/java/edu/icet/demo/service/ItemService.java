package edu.icet.demo.service;

import edu.icet.demo.dto.HardwareItem;

import java.util.List;

public interface ItemService {
    Boolean addItem(HardwareItem item);

    List<HardwareItem> getAll();

    Boolean deleteItemById(Long id);

    Boolean updateItem(HardwareItem item);

    HardwareItem findById(Long id);
}
