package com.test.banco.dtos;

import com.test.banco.enums.TipoTransacao;
import com.test.banco.exceptions.validation.ValueOfEnum;
import lombok.Getter;
import lombok.Setter;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class TransacaoDto {

    private ContaTransacaoDto conta_origem;

    private ContaTransacaoDto conta_destino;

    @Valid
    @NotBlank
    @ValueOfEnum(enumClass = TipoTransacao.class, message = "Valor inválido para tipo_transacao, valores possiveis: TED, DOC, PIX, PAGAMENTO")
    private String tipo_transacao;

    @NotNull
    private BigDecimal valor;

    private String descricao;
}
