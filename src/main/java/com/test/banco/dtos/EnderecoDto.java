package com.test.banco.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    @Valid
    @NotBlank
    @Size(max = 10)
    private String cep;

    @Valid
    @NotBlank
    private String rua;

    @Valid
    @NotNull
    private int numero;

    @Valid
    @Size(max=20)
    private String complemento;

    @Valid
    @NotBlank
    private String bairro;

    @Valid
    @NotBlank
    private String cidade;

    @Valid
    @NotBlank
    @Size(max = 2)
    private String uf;

}
