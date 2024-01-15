package com.test.banco.dtos;

import com.test.banco.enums.Genero;
import com.test.banco.exceptions.validation.ValueOfEnum;
import lombok.Getter;
import lombok.Setter;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
public class PessoaFisicaDto {
    @Valid
    @Size(max = 20)
    @NotBlank
    private String cpf;

    @Valid
    @Size(max = 20)
    @NotBlank
    private String rg;

    @NotNull
    @Past
    private LocalDate dt_nascimento;

    @Valid
    @NotBlank
    @NotNull
    private String nome;

    @Valid
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotNull
    private String celular;

    @Valid
    private EnderecoDto endereco;

    @Valid
    private ContaDto conta;

    @NotBlank
    private String nome_mae;

    @ValueOfEnum(enumClass = Genero.class, message = "Valor inválido para genero, valores possiveis: MASCULINO, FEMININO; ")
    private String genero;
}
