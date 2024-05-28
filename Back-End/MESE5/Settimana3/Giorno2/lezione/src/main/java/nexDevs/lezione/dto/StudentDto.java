package nexDevs.lezione.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    @NotBlank(message = "name can't be empty or null or only space")
    private String name;
    @NotBlank(message = "surname can't be empty or null or only space")
    private String surname;
    @NotNull(message = "birthDate can't be empty or null or only space")
    private LocalDate birthDate;

}
