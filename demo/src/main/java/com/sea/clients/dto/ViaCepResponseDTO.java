package com.sea.clients.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class ViaCepResponseDTO {
 private String cep;
 private String logradouro;
 private String bairro;
 private String localidade;
 private String uf;
 private String complemento;


 public String getCep() { return cep; }
 public String getLogradouro() { return logradouro; }
 public String getBairro() { return bairro; }
 public String getLocalidade() { return localidade; }
 public String getUf() { return uf; }
 public String getComplemento() { return complemento; }

 public void setCep(String cep) { this.cep = cep; }
 public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
 public void setBairro(String bairro) { this.bairro = bairro; }
 public void setLocalidade(String localidade) { this.localidade = localidade; }
 public void setUf(String uf) { this.uf = uf; }
 public void setComplemento(String complemento) { this.complemento = complemento; }
}