package bcp.reto.erate.domain.service;

import bcp.reto.erate.domain.dto.ExchangeRate;
import bcp.reto.erate.domain.dto.ExchangeRateDTOPK;
import bcp.reto.erate.repository.model.ExchangeRatePK;

import java.util.List;
import java.util.Optional;

public interface ExchangeRateService {

    //ExchangeRate add(ExchangeRate exchangeRate);
    ExchangeRate update(ExchangeRate exchangeRate);

    //Optional<ExchangeRate> findExchangeRate(Long origenID, Long destinoID);

    Optional<ExchangeRate> findById(ExchangeRateDTOPK id);

    Optional<ExchangeRate> findExchangeRate(ExchangeRateDTOPK id);




}
