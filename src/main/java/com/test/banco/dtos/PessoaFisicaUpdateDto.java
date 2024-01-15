package com.test.banco.dtos;

import com.test.banco.enums.Genero;
import com.test.banco.exceptions.validation.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisicaUpdateDto {
    @Valid
    @NotNull
    private Long id;

    @Past
    private LocalDate dt_nascimento;

    @Valid
    private String nome;

    @Valid
    @Email
    private String email;

    private String telefone;

    private String celular;

    @Valid
    private EnderecoDto endereco;

    @ValueOfEnum(enumClass = Genero.class, message = "Valor inválido para genero, valores possiveis: MASCULINO, FEMININO; ")
    private String genero;
}
