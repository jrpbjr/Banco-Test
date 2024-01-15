package com.test.banco.models;

import com.test.banco.enums.Genero;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa{
    @Column(length = 20, nullable = false, unique = true)
    private String cpf;

    @Column(length = 20, nullable = false, unique = true)
    private String rg;

    @Column(length = 20, nullable = false)
    private LocalDate dt_nascimento;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;


    public PessoaFisica(Long id, String nome, String email, String telefone, String celular, Endereco endereco, Conta conta, LocalDateTime criado_em, LocalDateTime alterado_em, boolean status, String cpf, String rg, LocalDate dt_nascimento,  Genero genero) {
        super(id, nome, email, telefone, celular, endereco, conta, criado_em, alterado_em, status);
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.genero = genero;
    }



}
