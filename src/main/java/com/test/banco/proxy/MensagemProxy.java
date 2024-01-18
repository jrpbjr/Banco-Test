package com.test.banco.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.banco.models.Messagem;

@Component
@FeignClient(name = "mensagem-proxy", url = "https://run.mocky.io/v3/9769bf3a-b0b6-477a-9ff5-91f63010c9d3")

public interface MensagemProxy {
        @GetMapping
        public Messagem getMessage();
}
