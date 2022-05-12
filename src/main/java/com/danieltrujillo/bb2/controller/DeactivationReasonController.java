package com.danieltrujillo.bb2.controller;

import com.danieltrujillo.bb2.dto.DeactivationReasonDTO;
import com.danieltrujillo.bb2.dto.ItemDTO;
import com.danieltrujillo.bb2.enums.ItemStateEnum;
import com.danieltrujillo.bb2.model.DeactivationReason;
import com.danieltrujillo.bb2.service.DeactivationReasonService;
import com.danieltrujillo.bb2.service.ItemService;
import com.danieltrujillo.bb2.service.ValueCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DeactivationReason")
public class DeactivationReasonController {

    @Autowired
    private DeactivationReasonService deactivationReasonService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ValueCheckerService valueCheckerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/DeactivationReasons")
    public List<DeactivationReasonDTO> findDeactivationReasons() {
        return deactivationReasonService.findDeactivationReasons();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/Add")
    public void saveDeactivationReason(DeactivationReasonDTO deactivationReasonDTO) {
        if (deactivationReasonDTO.getItem() != null) {
            System.out.println("ITEM NO NULO");
            ItemDTO itemInserted = valueCheckerService.checkItem(deactivationReasonDTO.getItem());
            if(itemInserted != null) {
                System.out.println("ITEM EXISTE");
                deactivationReasonDTO.setItem(itemInserted);
                deactivationReasonService.saveDeactivationReason(deactivationReasonDTO);
            }
        }
    }
}
