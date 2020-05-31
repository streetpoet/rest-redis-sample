package com.spstudio.redis.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spstudio.redis.entity.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Product Domain API Collection", description = " ")
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @ApiOperation(value = "get product detail by product id", notes = "NOTE: product id must be an existing one that already be saved in database")
    @ApiImplicitParam(name = "product-id", value = "description text", paramType = "path", required = true, dataType = "String")
    @GetMapping(path = "/{product-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable("product-id") String productId) {

        Product p = new Product();
        return ResponseEntity.ok(p);
    }
}
