package com.danieltrujillo.bb2.repository;
import com.danieltrujillo.bb2.model.DeactivationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeactivationReasonRepository extends JpaRepository<DeactivationReason, Long> {
}
