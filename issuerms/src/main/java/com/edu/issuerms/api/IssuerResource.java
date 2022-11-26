package com.edu.issuerms.api;

import com.edu.issuerms.model.Issuer;
import com.edu.issuerms.service.IssuerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/issuer")
public class IssuerResource {
    @Autowired
    private IssuerService issuerService;

    //  Fetch all issers
    @GetMapping("/issuers")
    public List<Issuer> getAllIssuers() {
        return issuerService.findAll().stream().collect(Collectors.toList());
    }

    //  Fetch Issuer by isbn / bookid
    @GetMapping("/issuers/{isbn}")
    public List<Issuer> findByIsbn(@PathVariable String isbn) {
       return issuerService.findByIsbn(isbn);
    }

    //  Fetch Issuer by custId
    @GetMapping("/issuers/{custid}")
    public List<Issuer> findByCustomerId(@PathVariable String custid) {
        return issuerService.findByCustId(custid);
    }

    //  Issue Book to Customer
    @PostMapping("/doBookIssuer")
    public Issuer doBookIssuer(@RequestBody Issuer issuer){
//            throws URISyntaxException {
//        Issuer saved = issuerService.save(issuer);
//        return ResponseEntity.created(new URI(saved.getId().toString())).body(saved);
       return issuerService.doBookIssuer(issuer);
    }

//    @PutMapping("")
//    @PutMapping("/book/{id}")
//    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
}
