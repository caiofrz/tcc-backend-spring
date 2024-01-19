package tcc.caioferraz.backendapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RoomDTO(
        @NotBlank(message = "O número do quarto não pode estar em branco ou nulo!")
        String number,
        @NotBlank(message = "O tipo do quarto não pode estar em branco ou nulo!")
        String type,
        @Positive(message = "A quantidade de camas deve ser superior a um(1)!")
        Integer bedQuantity,
        @NotBlank(message = "A descrição do quarto não pode estar em branco ou nulo!")
        String description,
        @Positive(message = "O valor de diária do quarto deve ser um numero positivo!")
        BigDecimal dailyRate
) {
}
