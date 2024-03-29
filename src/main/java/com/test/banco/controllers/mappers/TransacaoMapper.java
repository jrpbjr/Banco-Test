package com.test.banco.controllers.mappers;

import com.test.banco.dtos.TransacaoDto;
import com.test.banco.models.Transacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class TransacaoMapper {
    private ModelMapper modelMapper;

    public Transacao toEntityTransacao(TransacaoDto transacaoDto) {
        return modelMapper.map(transacaoDto, Transacao.class);
    }
}
