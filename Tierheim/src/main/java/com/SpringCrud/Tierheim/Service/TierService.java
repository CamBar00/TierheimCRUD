package com.SpringCrud.Tierheim.Service;

import com.SpringCrud.Tierheim.DTO.TierDTO;
import com.SpringCrud.Tierheim.DTO.TierSaveDTO;
import com.SpringCrud.Tierheim.DTO.TierUpdateDTO;

import java.util.List;

public interface TierService {
String addTier (TierSaveDTO tierSaveDTO);

    List<TierDTO> getAllTiere();

    String updateTier(TierUpdateDTO tierUpdateDTO);

    boolean deleteTier(int id);
}
