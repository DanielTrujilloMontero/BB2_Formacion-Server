package com.danieltrujillo.bb2.service.impl;

import com.danieltrujillo.bb2.dto.DeactivationReasonDTO;
import com.danieltrujillo.bb2.model.DeactivationReason;
import com.danieltrujillo.bb2.repository.DeactivationReasonRepository;
import com.danieltrujillo.bb2.service.DeactivationReasonService;
import com.danieltrujillo.bb2.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeactivationReasonServiceImplementation implements DeactivationReasonService {
    @Autowired
    DeactivationReasonRepository deactivationReasonRepository;

    @Autowired
    ModelMapperService modelMapperService;

    public List<DeactivationReasonDTO> findDeactivationReasons() {
        List<DeactivationReason> deactivationReasons = deactivationReasonRepository.findAll();
        return modelMapperService.convertDeactivationReasonList2DTOList(deactivationReasons);
    }

    @Override
    public void saveDeactivationReason(DeactivationReasonDTO deactivationReasonDTO) {
        DeactivationReason deactivationReason = modelMapperService.convertDeactivationReasonDTO2Entity(deactivationReasonDTO);
        deactivationReasonRepository.save(deactivationReason);
    }

}
