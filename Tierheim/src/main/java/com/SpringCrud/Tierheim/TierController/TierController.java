package com.SpringCrud.Tierheim.TierController;

import com.SpringCrud.Tierheim.DTO.TierDTO;
import com.SpringCrud.Tierheim.DTO.TierSaveDTO;
import com.SpringCrud.Tierheim.DTO.TierUpdateDTO;
import com.SpringCrud.Tierheim.Service.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/tier")
public class TierController {
    @Autowired
    private TierService tierService;
    @PostMapping(path="/save")
    public String saveTier(@RequestBody TierSaveDTO tierSaveDTO)
    {
        String id = tierService.addTier(tierSaveDTO);
        return id;
    }


    @GetMapping(path="/getAllTiere")
    public List<TierDTO> getAllTiere()
    {
    List<TierDTO>allTiere = tierService.getAllTiere();
    return allTiere;
    }

    @PostMapping(path= "/update")
    public String updateTier(@RequestBody TierUpdateDTO tierUpdateDTO)
    {
        String id = tierService.updateTier(tierUpdateDTO);
        return id;
    }

    @DeleteMapping(path= "/deletetier/{id}")
    public String deleteTier(@PathVariable(value= "id") int id)
    {
        boolean deleteTier = tierService.deleteTier(id);
        return "deleted";
    }


}
