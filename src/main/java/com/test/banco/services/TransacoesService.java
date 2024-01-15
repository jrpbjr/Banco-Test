package com.test.banco.services;

import com.test.banco.enums.TipoTransacao;
import com.test.banco.exceptions.NegocioException;
import com.test.banco.models.Conta;
import com.test.banco.models.Transacao;
import com.test.banco.repositories.TransacaoRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@Service
public class TransacoesService {
    private TransacaoRepository _repositoryTransacao;
    private ContaService contaService;

    @Transactional
    public Transacao efetuarTransacao(Transacao transacao) {
        if (transacao.getValor().compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new NegocioException("Valor da transação inválido.");
        }

        List<Conta> contas = contaService.atualizarSaldo(transacao);
        if (contas.isEmpty()) {
            throw new NegocioException("Não foi possível concluir a transação.");
        }
        transacao.setConta_origem(contas.get(0));
        transacao.setConta_destino(contas.get(1));
        return _repositoryTransacao.save(transacao);
    }


    public List<Transacao> listarTransacoesPorTipo(TipoTransacao tipoTransacao) {
        List<Transacao> transacoes = _repositoryTransacao.listarTransacoesPorTipo(tipoTransacao.toString());
        if (transacoes.isEmpty()) {
            throw new NegocioException("Nenhuma transação do tipo " + tipoTransacao + " encontrada.");
        }
        return transacoes;
    }


    public List<Transacao> listarTransacoesPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        List<Transacao> transacoes = _repositoryTransacao.listarTransacoesPorPeriodo(dataInicial, dataFinal.plusDays(1));
        if (transacoes.isEmpty()) {
            throw new NegocioException("Nenhuma transação encontrada entre " + dataInicial + " e " + dataFinal);
        }
        return transacoes;
    }


    public List<Transacao> listarTransacoesPorIdConta(String id) {
        contaService.buscarContaPorId(id);
        List<Transacao> transacoes = _repositoryTransacao.listarTransacoesPorConta(id);
        if (transacoes.isEmpty()) {
            throw new NegocioException("Nenhuma transação encontrada para a conta informada (ID: " + id + ").");
        }

        return transacoes;
    }


    public Transacao buscarTransacaoPorId(String id) {
        return _repositoryTransacao.findById(id).orElseThrow(() -> new NegocioException("Transação não encontrada (ID:  " + id + ")."));
    }
}