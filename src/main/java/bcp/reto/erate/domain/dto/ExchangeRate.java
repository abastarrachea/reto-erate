package bcp.reto.erate.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ExchangeRate implements Serializable {

    private static final long serialVersionUID = 7036168699056392028L;

    private ExchangeRateDTOPK exchangeRateDTOPK;
    private BigDecimal valorCambio;
}
