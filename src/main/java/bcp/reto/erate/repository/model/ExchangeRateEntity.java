package bcp.reto.erate.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="exchange_rate")
public class ExchangeRateEntity extends ExchangeRatePK {

    @Id
    private ExchangeRatePK exchangeRatePK;

    /*@JoinTable(
            name = "exchange_rate",
            joinColumns = @JoinColumn(name = "FK_DIVISA_ORIGEN", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_DIVISA_DESTINO", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<DivisaEntity> divisas;*/

    private BigDecimal valorCambio;

    /*public void addDivisa(DivisaEntity entity){
        if(this.divisas == null){
            this.divisas = new ArrayList<>();
        }
        this.divisas.add(entity);
    }*/

}
