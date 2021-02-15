package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Invoice;
import com.vetApplication.program.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/getInvoices")
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping("/findById/{invoiceId}")
    public Optional<Invoice> findById(@PathVariable int invoiceId) {
        return invoiceService.findById(invoiceId);
    }

    @PostMapping("/addNew")
    public void addNew(@RequestBody Invoice invoice) {
        invoiceService.save(invoice);
    }

    @PutMapping("/update")
    public void update(@RequestBody Invoice invoice) {
        invoiceService.save(invoice);
    }

    @DeleteMapping("/delete/{invoiceId}")
    public void delete(@PathVariable int invoiceId) {
        invoiceService.delete(invoiceId);
    }

}