package com.edu.issuerms.service;

import com.edu.issuerms.model.Issuer;
import com.edu.issuerms.repo.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class IssuerService {

    @Autowired
    private IssuerRepository issuerRepository;

    public Collection<Issuer> findAll() {
        return issuerRepository.findAll().stream().collect(Collectors.toList());
    }
}
