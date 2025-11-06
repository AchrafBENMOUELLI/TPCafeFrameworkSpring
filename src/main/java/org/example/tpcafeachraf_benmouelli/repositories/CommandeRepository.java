package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
