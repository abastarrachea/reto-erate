package bcp.reto.erate.domain.service;

import bcp.reto.erate.domain.dto.Divisa;

import java.util.List;
import java.util.Optional;

public interface DivisaService {

    Divisa add(Divisa divisa);
    Divisa update(Divisa divisa);

    Optional<Divisa> findById(Long divisaId);
    List<Divisa> findAll();
}
