package com.poc.redis.controller;

import com.poc.redis.model.CargaComum;
import com.poc.redis.repository.CargaComumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("poc-redis")
public class PocRedisController {

    private final CargaComumRepository cargaComumRepository;

    private PocRedisController(CargaComumRepository cargaComumRepository) {
        this.cargaComumRepository = cargaComumRepository;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<CargaComum> getRedisKey(@RequestParam final String nomeCp, @RequestParam final String idLoja) {
        Optional<CargaComum> optional = cargaComumRepository.findById(String.format("%s:%s", nomeCp, idLoja));
        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CargaComum postRedisKey(@RequestBody final CargaComum cargaComum) {
        cargaComum.setHashArquivo(UUID.randomUUID().toString());
        cargaComumRepository.save(cargaComum);
        return cargaComum;
    }
}
