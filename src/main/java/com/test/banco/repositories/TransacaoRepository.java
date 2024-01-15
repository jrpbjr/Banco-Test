package com.test.banco.repositories;

import com.test.banco.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    @Query(value = "SELECT * FROM transacao t WHERE t.tipo_transacao = ?1", nativeQuery = true)
    List<Transacao> listarTransacoesPorTipo(String tipoTransacao);

    @Query(value = "SELECT * FROM transacao t WHERE t.data BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Transacao> listarTransacoesPorPeriodo(LocalDate dataInicial, LocalDate dataFinal);

    @Query(value = "SELECT * FROM transacao t WHERE t.conta_origem_id = ?1 OR t.conta_destino_id = ?1", nativeQuery = true)
    List<Transacao> listarTransacoesPorConta(String id);
}
