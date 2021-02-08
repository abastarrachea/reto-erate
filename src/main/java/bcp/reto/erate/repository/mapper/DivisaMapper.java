package bcp.reto.erate.repository.mapper;

import bcp.reto.erate.domain.dto.Divisa;
import bcp.reto.erate.domain.dto.ExchangeRate;
import bcp.reto.erate.repository.model.DivisaEntity;
import bcp.reto.erate.repository.model.ExchangeRateEntity;
//import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DivisaMapper {

    public Divisa toDivisa(DivisaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Divisa divisa = new Divisa();

        if(entity.getId() != null) {
            divisa.setDivisaId(Long.valueOf(entity.getId()));
        }

        divisa.setMoneda( entity.getMoneda() );
        divisa.setSigla( entity.getSigla() );

        return divisa;
    }

    //@Override
    public DivisaEntity toDivisaEntity(Divisa divisa) {
        if ( divisa == null ) {
            return null;
        }

        DivisaEntity divisaEntity = new DivisaEntity();

        if(divisa.getDivisaId() != null) {
            divisaEntity.setId(Long.valueOf(divisa.getDivisaId()));
        }

        divisaEntity.setMoneda( divisa.getMoneda() );
        divisaEntity.setSigla( divisa.getSigla() );

        return divisaEntity;
    }

    public List<Divisa> toDivisas(List<DivisaEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Divisa> list = new ArrayList<Divisa>( entities.size() );
        for ( DivisaEntity divisaEntity : entities ) {
            list.add( toDivisa( divisaEntity ) );
        }

        return list;
    }

    public List<DivisaEntity> toDivisaEntities(List<Divisa> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DivisaEntity> list = new ArrayList<DivisaEntity>( entities.size() );
        for ( Divisa divisa : entities ) {
            list.add( toDivisaEntity( divisa) );
        }

        return list;
    }
}
