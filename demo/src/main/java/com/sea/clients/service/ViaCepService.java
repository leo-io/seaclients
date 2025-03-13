// ViaCepService.java
package com.sea.clients.service;

import com.sea.clients.dto.ViaCepResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private static final String VIACEP_URL = "https://viacep.com.br/ws/%s/json/";

    public ViaCepResponseDTO fetchAddressByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(VIACEP_URL, cep);
        return restTemplate.getForObject(url, ViaCepResponseDTO.class);
    }
}