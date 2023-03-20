package com.SpringCrud.Tierheim.Service;

import com.SpringCrud.Tierheim.DTO.TierDTO;
import com.SpringCrud.Tierheim.DTO.TierSaveDTO;
import com.SpringCrud.Tierheim.DTO.TierUpdateDTO;
import com.SpringCrud.Tierheim.TierRepo.TierRepo;
import com.SpringCrud.Tierheim.entity.Tier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TierServiceIMPL implements TierService{
    @Autowired
    private TierRepo tierRepo;
    @Override
    public String addTier(TierSaveDTO tierSaveDTO) {
        Tier tier = new Tier(tierSaveDTO.getTiername(), tierSaveDTO.getTierart(),tierSaveDTO.getTiergeschlecht(), tierSaveDTO.getTiergeburtstag(), tierSaveDTO.getTierrasse(), tierSaveDTO.getTierbild());

        tierRepo.save(tier);
        return tier.getTiername();
    }

    @Override
    public List<TierDTO> getAllTiere() {
        List<Tier> getTiere = tierRepo.findAll();
        List<TierDTO> tierDTOList = new ArrayList<>();
        for(Tier t:getTiere){
            TierDTO tierDTO = new TierDTO(
                    t.getTierid(),
                    t.getTierart(),
                    t.getTierbild(),
                    t.getTiergeburtstag(),
                    t.getTiergeschlecht(),
                    t.getTiername(),
                    t.getTierrasse()

            );
            tierDTOList.add(tierDTO);
        }
        return tierDTOList;
    }

    @Override
    public String updateTier(TierUpdateDTO tierUpdateDTO) {
        if(tierRepo.existsById(tierUpdateDTO.getTierid()))
        {
            Tier tier = tierRepo.getById(tierUpdateDTO.getTierid());
            tier.setTierart(tierUpdateDTO.getTierart());
            tier.setTierbild(tierUpdateDTO.getTierbild());
            tier.setTiergeburtstag(tierUpdateDTO.getTiergeburtstag());
            tier.setTiergeschlecht(tierUpdateDTO.getTiergeschlecht());
            tier.setTiername(tierUpdateDTO.getTiername());
            tier.setTierrasse(tierUpdateDTO.getTierrasse());

            tierRepo.save(tier);

        }
        else{
            System.out.println("Tier ID existiert nicht!");
        }
        return null;
    }

    @Override
    public boolean deleteTier(int id) {
        if(tierRepo.existsById(id)){
            tierRepo.deleteById((id));
        }
        else {
            System.out.println("Tier id nicht gefunden!");
        }
        return true;
    }

}
