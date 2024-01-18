package tcc.caioferraz.backendapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public record RoomDTO(
        @NotBlank(message = "O número do quarto não pode estar em branco ou nulo!")
        String number,
        @NotBlank(message = "O tipo do quarto não pode estar em branco ou nulo!")
        String type,
        @NotBlank(message = "A quantidade de camas do quarto não pode estar em branco ou nulo!")
        @Positive(message = "A quantidade de camas deve ser superior a um(1)!")
        Integer bedQuantity,
        @NotBlank(message = "A descrição do quarto não pode estar em branco ou nulo!")
        String description,
        @NotBlank(message = "O valor de diária do quarto não pode estar em branco ou nulo!")
        @Positive(message = "O valor de diária do quarto deve ser um numero positivo!")
        Double dailyRate
) {
}
