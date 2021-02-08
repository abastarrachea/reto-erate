package bcp.reto.erate.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Divisa implements Serializable {

    private static final long serialVersionUID = 7036168699056392020L;

    private Long divisaId;
    private String moneda;
    private String sigla;
}
