package com.example.jsonrpc.service;

import com.example.jsonrpc.model.JsonRpcRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class JsonRPCService {

    public ResponseEntity<String> requestSendToBlockChain(JsonRpcRequest jsonRpcRequest) {
        try {
            return interactWIthBlockChain(jsonRpcRequest);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Erro na requisição para blockchain");
        }
    }

    private ResponseEntity<String> interactWIthBlockChain(JsonRpcRequest jsonRpcRequest) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JsonRpcRequest> entity = new HttpEntity<>(jsonRpcRequest);
        URI uri = new URI("HTTP://127.0.0.1:7545");
        return restTemplate.postForEntity(uri, entity, String.class);
    }
}
