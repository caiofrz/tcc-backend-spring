package tcc.caioferraz.backendapi.domain.rooms;

public record RoomDTO(
        Integer number,
        RoomEnum type,
        Integer bedQuantity,
        String description,
        Double dailyRate
        ) {}
