package tcc.caioferraz.backendapi.dto;

import java.util.List;

public record PageResponseDTO(
        Integer page,
        Integer size,
        Long totalElements,
        Integer totalPages,
        List<?> data) {
}
