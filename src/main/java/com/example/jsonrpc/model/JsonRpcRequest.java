package com.example.jsonrpc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JsonRpcRequest {
    

    private String jsonrpc;
    

    private String method;
    
    @JsonProperty("params")
    private Object[] params;
    
    @JsonProperty("id")
    private Integer id;

}
