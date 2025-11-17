package org.example.tpcafeachraf_benmouelli.repositories;

import org.example.tpcafeachraf_benmouelli.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    List<Adresse> findByVille(String ville);

    List<Adresse> findByCodePostal(Integer codePostal);

    Long countByVille(String ville);

    void deleteByVille(String ville);

    List<Adresse> findByVilleAndCodePostal(String ville, Integer codePostal);

    List<Adresse> findByRueContainingIgnoreCase(String mot);

    List<Adresse> findByVilleIn(List<String> villes);

    List<Adresse> findByCodePostalBetween(Integer min, Integer max);

    List<Adresse> findByCodePostalGreaterThan(Integer cp);

    List<Adresse> findByCodePostalGreaterThanOrEqualTo(Integer cp);

    List<Adresse> findByCodePostalLessThan(Integer cp);

    List<Adresse> findByCodePostalLessThanOrEqualTo(Integer cp);

    List<Adresse> findByVilleAndRueStartingWithOrderByCodePostalAsc(String ville, String prefix);

    List<Adresse> findByRueStartingWith(String prefix);

    List<Adresse> findByVilleEndingWith(String suffix);

    List<Adresse> findByRueIsNull();

    List<Adresse> findByVilleIsNotNull();

}
