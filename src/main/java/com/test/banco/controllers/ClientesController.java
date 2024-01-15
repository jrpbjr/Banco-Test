package com.test.banco.controllers;

import com.test.banco.controllers.mappers.ClienteMapper;
import com.test.banco.dtos.PessoaFisicaDto;
import com.test.banco.dtos.PessoaFisicaUpdateDto;
import com.test.banco.dtos.PessoaJuridicaDto;
import com.test.banco.dtos.PessoaJuridicaUpdateDto;
import com.test.banco.exceptions.NegocioException;
import com.test.banco.models.PessoaFisica;
import com.test.banco.models.PessoaJuridica;
import com.test.banco.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClientesController {
    private ClienteService service;

    private ClienteMapper clienteMapper;

    @PostMapping("/pf")
    public ResponseEntity cadastrarPessoaFisica(@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto){
        PessoaFisica novoCliente = clienteMapper.toEntityPf(pessoaFisicaDto);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarPessoaFisica(novoCliente));
        } catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/pj")
    public  ResponseEntity cadastrarPessoaJuridica (@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto){
        PessoaJuridica novoCliente = clienteMapper.toEntityPj(pessoaJuridicaDto);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarPessoaJuridica(novoCliente));
        }catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity listarTodosClientes(){
        try {
            List<Object> listaDeClientes = service.listarTodosClientes();
            if(listaDeClientes.isEmpty()){
                throw new NegocioException("Ainda não há clientes cadastrados.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(listaDeClientes);
        } catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarClientePorId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listarClientePorId(id));
        } catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/pf")
    public ResponseEntity atualizarPessoaFisica(@RequestBody @Valid PessoaFisicaUpdateDto pessoa){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizarPessoaFisica(pessoa));
        } catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/pj")
    public ResponseEntity atualizarPessoaJuridica(@RequestBody @Valid PessoaJuridicaUpdateDto pessoa){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizarPessoaJuridica(pessoa));
        } catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("delete/{id}")
    public ResponseEntity inativarCliente(@PathVariable Long id ){
        try {
            if(!service.verificarSeClienteExiste(id)) {
                throw new NegocioException("Cliente não encontrado ou inativo (ID: " + id + ").");
            }

            Optional<PessoaFisica> clientePf = service.listarPessoaFisicaPorId(id);
            Optional<PessoaJuridica> clientePj = service.listarPessoaJuridicaPorId(id);

            if (clientePf.isPresent()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.inativarPessoaFisica(clientePf.get()));
            }

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.inativarPessoaJuridica(clientePj.get()));
        } catch (NegocioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
