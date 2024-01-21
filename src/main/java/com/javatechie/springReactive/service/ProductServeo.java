package com.javatechie.springReactive.service;

import com.javatechie.springReactive.dto.ProductDto;
import com.javatechie.springReactive.repo.ProductRepo;
import com.javatechie.springReactive.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServeo {


    @Autowired
    ProductRepo productRepo;

    public Flux<ProductDto> getProducts(){
        return productRepo.findAll()
                .map(AppUtils::EntityToDto);
    }

    public Mono<ProductDto> getProductById(String id){
        return productRepo.findById(id).map(AppUtils::EntityToDto);
    }


    public Flux<ProductDto> getProductInRange(Double min , Double  max){
        return productRepo.findByPriceBetween(Range.closed(min,max));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> dtoMono){
      return  dtoMono.map(AppUtils::DtoToEntity)
                .flatMap(productRepo::insert)
                .map(AppUtils::EntityToDto);
    }


    public Mono<ProductDto> updateProduct(Mono<ProductDto> dtoMono,String id){
      return   productRepo.findById(id)
                .flatMap(p->dtoMono.map(AppUtils::DtoToEntity).doOnNext(e->e.setId(id)))
                .flatMap(productRepo::save)
                .map(AppUtils::EntityToDto);

    }

    public Mono<Void> deleteMono(String id){
        return productRepo.deleteById(id);
    }
}
