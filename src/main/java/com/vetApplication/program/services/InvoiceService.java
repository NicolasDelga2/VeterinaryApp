package com.vetApplication.program.services;

import com.vetApplication.program.models.Invoice;
import com.vetApplication.program.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired private InvoiceRepository invoiceRepository;

    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findById(int id){
        return invoiceRepository.findById(id);
    }

    public void delete(int id){
        invoiceRepository.deleteById(id);
    }
}
