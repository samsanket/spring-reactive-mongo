package com.javatechie.springReactive.controller;


import com.javatechie.springReactive.dto.ProductDto;
import com.javatechie.springReactive.service.ProductServeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductServeo productServeo;

    @GetMapping("/")
    public Flux<ProductDto> getAll(){
        return  productServeo.getProducts();
    }

    @GetMapping("/id/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id){
        return productServeo.getProductById(id);

    }


    @GetMapping("/range")
    public Flux<ProductDto> getProductInRange(@RequestParam(name = "min") Double min , @RequestParam("max") Double max){
        return productServeo.getProductInRange(min,max);
    }

    @PostMapping("/save")
    public Mono<ProductDto> addProduct(@RequestBody Mono<ProductDto> productDto){
        return productServeo.saveProduct(productDto);

    }

    @PostMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDto , @PathVariable String id){
        return productServeo.updateProduct(productDto,id);

    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return productServeo.deleteMono(id);
    }
}
