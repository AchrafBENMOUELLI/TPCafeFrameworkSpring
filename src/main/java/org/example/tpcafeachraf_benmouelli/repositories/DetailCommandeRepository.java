package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Detail_Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailCommandeRepository extends JpaRepository<Detail_Commande, Long> {
}
