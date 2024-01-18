package tcc.caioferraz.backendapi.domain.rooms;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tcc.caioferraz.backendapi.dto.RoomDTO;
import tcc.caioferraz.backendapi.shared.mapper.Mapper;

@org.mapstruct.Mapper
public interface RoomMapper extends Mapper<RoomDTO, RoomModel> {

  RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

  @Override
  @Mapping(source = "number", target = "number")
  @Mapping(source = "type", target = "type")
  @Mapping(source = "bedQuantity", target = "bedQuantity")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "dailyRate", target = "dailyRate")
  RoomDTO toDto(RoomModel entity);

  @Override
  @Mapping(source = "number", target = "number")
  @Mapping(target = "type", defaultExpression = "java(TypeRoomEnum.valueOf(dto.type()))")
  @Mapping(source = "bedQuantity", target = "bedQuantity")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "dailyRate", target = "dailyRate")
  RoomModel toEntity(RoomDTO dto);
}
