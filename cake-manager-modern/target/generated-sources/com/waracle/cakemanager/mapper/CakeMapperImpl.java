package com.waracle.cakemanager.mapper;

import com.waracle.cakemanager.domain.model.Cake;
import com.waracle.cakemanager.domain.model.Cake.CakeBuilder;
import com.waracle.cakemanager.request.model.CakeRequest;
import com.waracle.cakemanager.response.model.CakeResponse;
import com.waracle.cakemanager.response.model.CakeResponse.CakeResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T00:58:32+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class CakeMapperImpl extends CakeMapper {

    @Override
    public Cake mapCakeRequestToCake(CakeRequest request) {
        if ( request == null ) {
            return null;
        }

        CakeBuilder cake = Cake.builder();

        if ( request.getTitle() != null ) {
            cake.title( request.getTitle() );
        }
        if ( request.getDescription() != null ) {
            cake.description( request.getDescription() );
        }
        if ( request.getImage() != null ) {
            cake.image( request.getImage() );
        }

        return cake.build();
    }

    @Override
    public CakeResponse mapCakeToCakeResponse(Cake cake) {
        if ( cake == null ) {
            return null;
        }

        CakeResponseBuilder cakeResponse = CakeResponse.builder();

        if ( cake.getId() != null ) {
            cakeResponse.id( cake.getId() );
        }
        if ( cake.getTitle() != null ) {
            cakeResponse.title( cake.getTitle() );
        }
        if ( cake.getDescription() != null ) {
            cakeResponse.description( cake.getDescription() );
        }
        if ( cake.getImage() != null ) {
            cakeResponse.image( cake.getImage() );
        }

        return cakeResponse.build();
    }

    @Override
    public List<CakeResponse> mapListOfCakeToListCakeResponse(List<Cake> cake) {
        if ( cake == null ) {
            return null;
        }

        List<CakeResponse> list = new ArrayList<CakeResponse>( cake.size() );
        for ( Cake cake1 : cake ) {
            list.add( mapCakeToCakeResponse( cake1 ) );
        }

        return list;
    }
}
