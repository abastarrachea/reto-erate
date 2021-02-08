package bcp.reto.erate.domain.service;

import bcp.reto.erate.domain.dto.Divisa;
import bcp.reto.erate.repository.DivisaRepository;
import bcp.reto.erate.repository.mapper.DivisaMapper;
import bcp.reto.erate.repository.mapper.ExchangeRateMapper;
import bcp.reto.erate.repository.model.DivisaEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class DivisaServiceImpl implements DivisaService {

    @Autowired
    private DivisaRepository divisaRepository;

    private DivisaMapper divisaMapper = new DivisaMapper();

    @Override
    public Divisa add(Divisa divisa) {
        var entity = divisaMapper.toDivisaEntity(divisa);
        entity = this.divisaRepository.save(entity);
        return this.divisaMapper.toDivisa(entity);
    }

    @Override
    public Divisa update(Divisa divisa) {
        var entity = divisaMapper.toDivisaEntity(divisa);
        entity = this.divisaRepository.saveAndFlush(entity);
        return this.divisaMapper.toDivisa(entity);
    }

    @Override
    public Optional<Divisa> findById(Long divisaId) {
        Optional<DivisaEntity> entity = this.divisaRepository.findById(divisaId);
        return entity.map(e -> this.divisaMapper.toDivisa(e));
        //return this.divisaMapper.toDivisa(entity.get());
    }

    @Override
    public List<Divisa> findAll() {
        List<DivisaEntity> entities = this.divisaRepository.findAll();
        return divisaMapper.toDivisas(entities);
    }
}
