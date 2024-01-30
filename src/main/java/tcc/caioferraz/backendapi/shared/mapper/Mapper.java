package tcc.caioferraz.backendapi.shared.mapper;

import org.mapstruct.MapperConfig;

@MapperConfig
public interface Mapper<D, E> {

  D toDto(E entity);

  E toEntity(D dto);

}
