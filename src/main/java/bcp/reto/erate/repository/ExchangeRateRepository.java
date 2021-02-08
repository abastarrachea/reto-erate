package bcp.reto.erate.repository;

import bcp.reto.erate.repository.model.ExchangeRateEntity;
import bcp.reto.erate.repository.model.ExchangeRatePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, ExchangeRatePK> {

    Optional<ExchangeRateEntity> findByExchangeRatePK(ExchangeRatePK exchangeRatePK);

    //Optional<ExchangeRateEntity> findByMoneda(String moneda);

    //Optional<ExchangeRateEntity> findBySigla(String sigal);

}
