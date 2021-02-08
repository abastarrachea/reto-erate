package bcp.reto.erate.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Exchange {

    private static final long serialVersionUID = 7036168699056392028L;

    private BigDecimal monto;
    private BigDecimal montoExchangeRate;
    private Long monedaOrigenId;
    private Long monedaDestinoId;
    private BigDecimal tipoCambio;
}
