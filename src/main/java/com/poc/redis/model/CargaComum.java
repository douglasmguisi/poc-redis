package com.poc.redis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "CargaComum", timeToLive = 60)
@Data
@Builder
public class CargaComum {

    private String nomeCp;
    private String idLoja;
    private Integer marcador;
    private String hashArquivo;

    @Id
    @AccessType(AccessType.Type.PROPERTY)
    @JsonIgnore
    public String getId() {
        return String.format("%s:%s", nomeCp, idLoja);
    }

    public void setId(String id) {
    }
}
