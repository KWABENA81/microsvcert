package com.edu.issuerms.api;

import com.edu.issuerms.model.Issuer;
import com.edu.issuerms.service.IssuerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/issuer")
public class IssuerResource {
    @Autowired
    private IssuerService issuerService;

    @GetMapping("/issuers")
    public List<Issuer> getAllIssuers() {
        return issuerService.findAll().stream().collect(Collectors.toList());
    }
}
