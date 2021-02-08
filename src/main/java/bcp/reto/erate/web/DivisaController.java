package bcp.reto.erate.web;

import bcp.reto.erate.domain.dto.Divisa;
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

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/divisa")
@RequiredArgsConstructor
public class DivisaController {

    private final DivisaService divisaService;

    @GetMapping("/{id}")
    public ResponseEntity<Divisa> findById(@PathVariable(name="id") Long id) {
        log.info("id:: " + id);
        Optional<Divisa> divisa = divisaService.findById(id);
        return divisa.isPresent() ? new ResponseEntity<>(divisa.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<Divisa>> findAll() {
        return !divisaService.findAll().isEmpty() ? new ResponseEntity<>(divisaService.findAll(), HttpStatus.OK) :
         new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
