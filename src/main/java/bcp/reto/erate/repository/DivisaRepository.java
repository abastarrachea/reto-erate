package bcp.reto.erate.repository;

import bcp.reto.erate.repository.model.DivisaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DivisaRepository extends JpaRepository<DivisaEntity, Long> {
}
