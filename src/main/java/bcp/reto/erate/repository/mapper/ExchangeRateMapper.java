package bcp.reto.erate.repository.mapper;

import bcp.reto.erate.domain.dto.ExchangeRate;
import bcp.reto.erate.domain.dto.ExchangeRateDTOPK;
import bcp.reto.erate.repository.model.ExchangeRateEntity;
import bcp.reto.erate.repository.model.ExchangeRatePK;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@RequiredArgsConstructor
public class ExchangeRateMapper {

    @Autowired
    private DivisaMapper divisaMapper;

    public ExchangeRate toExchangeRate(ExchangeRateEntity entity) {
        if ( entity == null ) {
            return null;
        }
        ExchangeRate exchangeRate = new ExchangeRate();

        if(entity.getExchangeRatePK() != null) {
            //exchangeRate.setDivisaOrigenId(entity.getExchangeRatePK().getDivisaOrigenId());
            //exchangeRate.setDivisaDestinoId(entity.getExchangeRatePK().getDivisaDestinoId());
            exchangeRate.setExchangeRateDTOPK(toExchangeRateDTOPK(entity.getExchangeRatePK()));
        }
        exchangeRate.setValorCambio(entity.getValorCambio());
        return exchangeRate;
    }

    public ExchangeRateEntity toExchangeRateEntity(ExchangeRate exchangeRate) {
        if ( exchangeRate == null ) {
            return null;
        }

        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();

        if(exchangeRate.getExchangeRateDTOPK() != null) {
            exchangeRateEntity.setExchangeRatePK(toExchangeRatePK(exchangeRate.getExchangeRateDTOPK()));
        }
        //ExchangeRatePK id = new ExchangeRatePK();
        //id.setDivisaOrigenId(exchangeRate.getDivisaOrigenId());
        //id.setDivisaDestinoId(exchangeRate.getDivisaDestinoId());

        //exchangeRateEntity.setExchangeRatePK(id);
        exchangeRateEntity.setValorCambio( exchangeRate.getValorCambio() );

        return exchangeRateEntity;
    }

    //@Override
    public List<ExchangeRate> toExchangesRates(List<ExchangeRateEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ExchangeRate> list = new ArrayList<ExchangeRate>( entities.size() );
        for ( ExchangeRateEntity exchangeRateEntity : entities ) {
            list.add( toExchangeRate( exchangeRateEntity ) );
        }

        return list;
    }

    //

    public ExchangeRateDTOPK toExchangeRateDTOPK(ExchangeRatePK id) {
        if ( id == null ) {
            return null;
        }

        ExchangeRateDTOPK dtopk = new ExchangeRateDTOPK();

        if(id.getDivisaOrigenId() != null && id.getDivisaDestinoId() != null) {
            dtopk.setDivisaOrigenId(id.getDivisaOrigenId());
            dtopk.setDivisaDestinoId(id.getDivisaDestinoId());
        }
        return dtopk;
    }

    //@Override
    public ExchangeRatePK toExchangeRatePK(ExchangeRateDTOPK dtopk) {
        if ( dtopk == null ) {
            return null;
        }

        ExchangeRatePK id = new ExchangeRatePK();
        id.setDivisaOrigenId(dtopk.getDivisaOrigenId());
        id.setDivisaDestinoId(dtopk.getDivisaDestinoId());

        return id;
    }
}
