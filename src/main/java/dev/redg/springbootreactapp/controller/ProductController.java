package dev.redg.springbootreactapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.redg.springbootreactapp.model.entity.Product;
import dev.redg.springbootreactapp.model.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
  @Autowired
  private ProductService productService;

  // Get methods
  @GetMapping("list")
  public List<Product> getProductList() {
    return productService.getProductList();
  }

  @GetMapping("get/{barcode}")
  public Product getProduct(@PathVariable String barcode) {
    return productService.getProduct(barcode);
  }

  // Post methods
  @PostMapping("add")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    try {
      Product newProduct = productService.addProduct(product);
      return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Patch methods
  @PatchMapping("update/{barcode}")
  public ResponseEntity<Product> updateProduct(@PathVariable String barcode, @RequestBody Product product) {
    try {
      Product productDB = productService.getProduct(barcode);
      if (productDB == null) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      productDB.setName(product.getName());
      return new ResponseEntity<>(productService.updateProduct(productDB), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Delete methods
  @DeleteMapping("delete/{barcode}")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String barcode) {
    try {
      productService.deleteProduct(barcode);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
