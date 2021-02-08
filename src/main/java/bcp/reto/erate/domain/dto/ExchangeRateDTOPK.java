package bcp.reto.erate.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExchangeRateDTOPK implements Serializable {

    private static final long serialVersionUID = 7036168699056392028L;

    private Long divisaOrigenId;
    private Long divisaDestinoId;
}
