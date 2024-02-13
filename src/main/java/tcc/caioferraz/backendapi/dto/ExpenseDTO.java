package tcc.caioferraz.backendapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseDTO(
        @NotBlank(message = "O título da despesa não pode ser branco ou nulo!")
        @Size(min = 5, max = 60, message = "O título da despesa deve conter entre 5 e 60 caracteres!")
        String title,
        @NotNull(message = "O valor da despesa não pode ser nulo!")
        @Positive(message = "O valor da despesa deve ser um numero positivo, superior a 0(zero)!")
        BigDecimal amount,
        @NotNull(message = "A data da despesa não pode ser nula!")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "America/Sao_Paulo")
        LocalDateTime date,
        @NotBlank(message = "A descrição da despesa não pode ser branca ou nula!")
        String description
) {
}
