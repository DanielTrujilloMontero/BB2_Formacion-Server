package com.danieltrujillo.bb2.service;

import com.danieltrujillo.bb2.dto.DeactivationReasonDTO;

import java.util.List;

public interface DeactivationReasonService {
    public List<DeactivationReasonDTO> findDeactivationReasons();

    public void saveDeactivationReason(DeactivationReasonDTO deactivationReasonDTO);
}
