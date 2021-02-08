package bcp.reto.erate.config;

import bcp.reto.erate.domain.dto.Divisa;
import bcp.reto.erate.repository.DivisaRepository;
import bcp.reto.erate.repository.ExchangeRateRepository;
import bcp.reto.erate.repository.model.DivisaEntity;
import bcp.reto.erate.repository.model.ExchangeRateEntity;
import bcp.reto.erate.repository.model.ExchangeRatePK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@Slf4j
public class LoadDataConfig implements CommandLineRunner  {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private DivisaRepository divisaRepository;

    @Override
    public void run(String... args) throws Exception {

        var soles = new DivisaEntity();
        soles.setMoneda("SOLES");
        soles.setSigla("PEN");
        soles = divisaRepository.save(soles);

        log.info("soles: " + soles);
        log.info("solesID: " + soles.getId());

        var dolar = new DivisaEntity();
        dolar.setMoneda("DOLARES");
        dolar.setSigla("USD");
        dolar = divisaRepository.save(dolar);
        log.info("dolar: " + dolar);
        log.info("dolarID: " + dolar.getId());

        var euro = new DivisaEntity();
        euro.setMoneda("EUROS");
        euro.setSigla("EUR");
        euro = divisaRepository.save(euro);
        log.info("euro: " + euro.toString());

        var rate_pen_dolar = new ExchangeRateEntity();
        var pk1 = new ExchangeRatePK();
        pk1.setDivisaOrigenId(soles.getId());
        pk1.setDivisaDestinoId(dolar.getId());
        //rate_pen_dolar.addDivisa(soles);
        //rate_pen_dolar.addDivisa(dolar);
        rate_pen_dolar.setExchangeRatePK(pk1);
        rate_pen_dolar.setValorCambio(BigDecimal.valueOf(3.7));
        rate_pen_dolar = exchangeRateRepository.save(rate_pen_dolar);
        log.info("rate_pen_dolar: " + rate_pen_dolar);
        log.info("rate_pen_dolar:getExchangeRatePK:: " + rate_pen_dolar.getExchangeRatePK());
        log.info("rate_pen_dolar:getExchangeRatePK::toString:: " + rate_pen_dolar.getExchangeRatePK().toString());

        var rate_pen_eur = new ExchangeRateEntity();
        var pk2 = new ExchangeRatePK();
        pk2.setDivisaOrigenId(soles.getId());
        pk2.setDivisaDestinoId(euro.getId());
        rate_pen_eur.setExchangeRatePK(pk2);
        rate_pen_eur.setValorCambio(BigDecimal.valueOf(4.2));
        exchangeRateRepository.save(rate_pen_eur);

        /*var rate_dolar_pen = new ExchangeRateEntity();
        rate_dolar_pen.addDivisa(dolar);
        rate_dolar_pen.addDivisa(soles);
        rate_dolar_pen.setValorCambio(0.37);
        exchangeRateRepository.save(rate_dolar_pen);*/

    }
}
