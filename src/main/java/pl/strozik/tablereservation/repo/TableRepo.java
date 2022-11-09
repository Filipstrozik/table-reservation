package pl.strozik.tablereservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strozik.tablereservation.model.Tablee;

import java.util.Optional;

public interface TableRepo extends JpaRepository<Tablee, Long> {
    void deleteTableeById(Long id);

    Optional<Tablee> findTableeById(Long id);
}
