package com.OdkApprenant.demo.repositories;

import com.OdkApprenant.demo.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence, Long> {
}
