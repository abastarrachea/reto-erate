package bcp.reto.erate.web;

import bcp.reto.erate.domain.dto.Exchange;
import bcp.reto.erate.domain.dto.ExchangeRate;
import bcp.reto.erate.domain.dto.ExchangeRateDTOPK;
import bcp.reto.erate.domain.service.DivisaService;
import bcp.reto.erate.domain.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    private final DivisaService divisaService;

    @GetMapping("/{monedaOrigenId}/{monedaDestinoId}")
    public ResponseEntity<ExchangeRate> findById(@PathVariable(name="monedaOrigenId") Long monedaOrigenId,
                                                 @PathVariable(name="monedaDestinoId") Long monedaDestinoId) {
        ExchangeRateDTOPK dtoPK = new ExchangeRateDTOPK();
        dtoPK.setDivisaOrigenId(monedaOrigenId);
        dtoPK.setDivisaDestinoId(monedaDestinoId);
        Optional<ExchangeRate> exchangeRate = exchangeRateService.findById(dtoPK);

        return exchangeRate.isPresent() ? new ResponseEntity<>(exchangeRate.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Exchange> loadExchange(@RequestBody Exchange rate) throws Exception {
        if(rate != null) {
            if(rate.getMontoExchangeRate() == null && rate.getTipoCambio() == null) {
                ExchangeRateDTOPK id = new ExchangeRateDTOPK();
                id.setDivisaOrigenId(rate.getMonedaOrigenId());
                id.setDivisaDestinoId(rate.getMonedaDestinoId());

                Optional<ExchangeRate> exchangeRate = exchangeRateService.findById(id);
                if(exchangeRate.isPresent()) {
                    rate.setTipoCambio(exchangeRate.get().getValorCambio());
                    rate.setMontoExchangeRate(rate.getMonto().multiply(rate.getTipoCambio()));
                    return new ResponseEntity<>(rate, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping
    public ResponseEntity<ExchangeRate> update(@RequestBody ExchangeRate exchangeRate) throws Exception{
        Optional<ExchangeRate> dto = exchangeRateService.findById(exchangeRate.getExchangeRateDTOPK());
        if(dto.isPresent()) {
            dto.get().setValorCambio(exchangeRate.getValorCambio());
            exchangeRate = this.exchangeRateService.update(dto.get());
            return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
