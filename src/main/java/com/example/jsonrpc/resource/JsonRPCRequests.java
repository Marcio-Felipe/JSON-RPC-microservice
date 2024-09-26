package com.example.jsonrpc.resource;

import com.example.jsonrpc.model.JsonRpcRequest;
import com.example.jsonrpc.service.JsonRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localrpc")
public class JsonRPCRequests {

    @Autowired
    private JsonRPCService jsonRPCService;

    @PostMapping("/block-number")
    public ResponseEntity<String> getBlockNumber(@RequestBody JsonRpcRequest jsonRpcRequest) {
        ResponseEntity<String> responseBlockNumber =  jsonRPCService.requestSendToBlockChain(jsonRpcRequest);
        if(responseBlockNumber.getStatusCode().is2xxSuccessful())
         return responseBlockNumber;
        else return ResponseEntity.status(responseBlockNumber.getStatusCode()).build();
    }

    @PostMapping("/storage")
    public ResponseEntity<String> getStorage(@RequestBody JsonRpcRequest jsonRpcRequest) {
        ResponseEntity<String> responseBlockNumber =  jsonRPCService.requestSendToBlockChain(jsonRpcRequest);
        if(responseBlockNumber.getStatusCode().is2xxSuccessful())
            return responseBlockNumber;
        else return ResponseEntity.status(responseBlockNumber.getStatusCode()).build();
    }

    @PostMapping("/contract-byte-code")
    public ResponseEntity<String> getContractByteCode(@RequestBody JsonRpcRequest jsonRpcRequest) {
        ResponseEntity<String> responseBlockNumber =  jsonRPCService.requestSendToBlockChain(jsonRpcRequest);
        if(responseBlockNumber.getStatusCode().is2xxSuccessful())
            return responseBlockNumber;
        else return ResponseEntity.status(responseBlockNumber.getStatusCode()).build();
    }
}
