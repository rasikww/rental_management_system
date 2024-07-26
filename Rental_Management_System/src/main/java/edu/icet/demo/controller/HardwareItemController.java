package edu.icet.demo.controller;

import edu.icet.demo.dto.HardwareItem;
import edu.icet.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item-controller")
public class HardwareItemController {
    final ItemService service;

    @GetMapping("/get-all")
    public List<HardwareItem> getAll(){
        return service.getAll();
    }

    @PostMapping("/add-item")
    public Boolean addItem(@RequestBody HardwareItem item){
        return service.addItem(item);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable Long id){
        return service.deleteItemById(id);
    }
    @PutMapping("/update-item")
    public Boolean updateEmployee(@RequestBody HardwareItem item){
        return service.updateItem(item);
    }
    @GetMapping("/find-by-id/{id}")
    public HardwareItem findById(@PathVariable Long id){
        return service.findById(id);
    }
}
