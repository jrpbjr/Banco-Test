package com.test.banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{
    @Column(length = 100, nullable = false)
    private String nome_fantasia;

    @Column(length = 14, unique = true, nullable = false)
    private String cnpj;

    @Column(length = 50, nullable = false)
    private String nome_contato;

    public PessoaJuridica(Long id, String nome, String email, String telefone, String celular, Endereco endereco, Conta conta, LocalDateTime criado_em, LocalDateTime alterado_em, boolean status, String nome_fantasia,  String cnpj, String nome_contato) {
        super(id, nome, email, telefone, celular, endereco, conta, criado_em, alterado_em, status);
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.nome_contato = nome_contato;
    }

}
