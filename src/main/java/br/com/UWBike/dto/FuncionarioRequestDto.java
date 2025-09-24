package br.com.UWBike.dto;

import br.com.UWBike.model.Login;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FuncionarioRequestDto {

        @NotBlank
        private String nomeFunc;

        @NotBlank
        private String cpf;

        @NotNull
        private Double salario;

        @NotBlank
        private String cargo;

        @NotNull
        private LoginRequestDto login;

        private long idPatio;

}
