package com.marketMakers.service;

import com.marketMakers.model.Invoice;
import com.marketMakers.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository repository;

    public Iterable<Invoice> findAll() {
        return repository.findAll();
    }

    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }
}