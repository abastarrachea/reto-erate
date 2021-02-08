package bcp.reto.erate.domain.service;

import bcp.reto.erate.domain.dto.ExchangeRate;
import bcp.reto.erate.domain.dto.ExchangeRateDTOPK;
import bcp.reto.erate.repository.DivisaRepository;
import bcp.reto.erate.repository.ExchangeRateRepository;
import bcp.reto.erate.repository.mapper.ExchangeRateMapper;
import bcp.reto.erate.repository.model.DivisaEntity;
import bcp.reto.erate.repository.model.ExchangeRateEntity;
import bcp.reto.erate.repository.model.ExchangeRatePK;
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
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    private ExchangeRateMapper exchangeRateMapper = new ExchangeRateMapper();

    /*@Override
    public ExchangeRate add(ExchangeRate exchangeRate) {
        //var entity = exchangeRateMapper.toExchangeRateEntity(exchangeRate);
        var entity = ExchangeRateMapper.MAPPER.toExchangeRateEntity(exchangeRate);
        entity = this.exchangeRateRepository.save(entity);
        return ExchangeRateMapper.MAPPER.toExchangeRate(entity);
        return null;
    }*/

    @Override
    public ExchangeRate update(ExchangeRate exchangeRate) {
        var entity = this.exchangeRateMapper.toExchangeRateEntity(exchangeRate);
        entity = this.exchangeRateRepository.saveAndFlush(entity);
        return this.exchangeRateMapper.toExchangeRate(entity);
    }

    public Optional<ExchangeRate> findById(ExchangeRateDTOPK id) {
        Optional<ExchangeRateEntity> entity = exchangeRateRepository.findById(exchangeRateMapper.toExchangeRatePK(id));
        return entity.map(e->this.exchangeRateMapper.toExchangeRate(e));
    }

    public Optional<ExchangeRate> findExchangeRate(ExchangeRateDTOPK id) {
        Optional<ExchangeRateEntity> entity = exchangeRateRepository.findByExchangeRatePK(exchangeRateMapper.toExchangeRatePK(id));
        return entity.map(e->this.exchangeRateMapper.toExchangeRate(e));
    }


}
