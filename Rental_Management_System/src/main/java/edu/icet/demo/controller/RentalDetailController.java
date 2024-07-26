package edu.icet.demo.controller;

import edu.icet.demo.dto.RentalDetail;
import edu.icet.demo.service.RentalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental-detail-controller")
public class RentalDetailController {
    final RentalDetailService service;

    @GetMapping("/get-all")
    public List<RentalDetail> getAll(){
        return service.getAll();
    }

    @PostMapping("/add-rentalDetail")
    public Boolean addRentalDetail(@RequestBody RentalDetail rentalDetail){
        return service.addRentalDetail(rentalDetail);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable Long id){
        return service.deleteRentalDetailById(id);
    }
    @PutMapping("/update-rentalDetail")
    public Boolean updateEmployee(@RequestBody RentalDetail rentalDetail){
        return service.updateRentalDetail(rentalDetail);
    }
    @GetMapping("/find-by-id/{id}")
    public RentalDetail findById(@PathVariable Long id){
        return service.findById(id);
    }
}
