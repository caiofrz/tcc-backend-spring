package tcc.caioferraz.backendapi.dto;

import tcc.caioferraz.backendapi.domain.rooms.RoomEnum;

public record RoomDTO(
        Integer number,
        RoomEnum type,
        Integer bedQuantity,
        String description,
        Double dailyRate
) {
}
