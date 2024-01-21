package com.javatechie.springReactive.util;

import com.javatechie.springReactive.dto.ProductDto;
import com.javatechie.springReactive.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {


    public static ProductDto EntityToDto(Product product){
        return  new ProductDto(product.getId(),product.getName(), product.getQuanity(),product.getPrice());
    }

    public static Product DtoToEntity(ProductDto productDto){
        Product product= new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
