package com.vetApplication.program.controllers;

import com.vetApplication.program.models.Product;
import com.vetApplication.program.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/findById/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        Product product1 = (Product) getProducts().stream().filter(product -> product.getId() == id);
        if(product1 != null){
            return productService.findById(id);
        }else{
            return null;
        }
    }

    @PostMapping("/addNew")
    public void addNew(@RequestBody Product product) throws Exception {
        if(product != null) {
            productService.save(product);
        }else{
            throw new Exception("Ocurrio un error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) throws Exception {
        Product product1 = (Product) getProducts().stream().filter(product -> product.getId() == id);
        if(getProducts().contains(product1)){
            productService.delete(id);
        }else{
            throw new Exception("El producto no existe");
        }
    }

    public void update(@RequestBody Product product) throws Exception {
        if(product == null) throw new Exception("El producto es nulo");
        if(getProducts().contains(product)){
            productService.save(product);
        }
    }


}
