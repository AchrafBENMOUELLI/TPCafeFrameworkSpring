package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
