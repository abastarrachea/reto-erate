package bcp.reto.erate.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.PROPERTY)
public class ExchangeRatePK implements Serializable {
    
    private Long divisaOrigenId;
    private Long divisaDestinoId;

}
