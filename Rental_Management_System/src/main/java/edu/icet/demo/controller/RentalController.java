package edu.icet.demo.controller;

import edu.icet.demo.dto.Rental;
import edu.icet.demo.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental-controller")
public class RentalController {
    final RentalService service;

    @GetMapping("/get-all")
    public List<Rental> getAll(){
        return service.getAll();
    }

    @PostMapping("/add-rental")
    public Boolean addRental(@RequestBody Rental rental){
        return service.addRental(rental);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable Long id){
        return service.deleteRentalById(id);
    }
    @PutMapping("/update-rental")
    public Boolean updateEmployee(@RequestBody Rental rental){
        return service.updateRental(rental);
    }
    @GetMapping("/find-by-id/{id}")
    public Rental findById(@PathVariable Long id){
        return service.findById(id);
    }
}
