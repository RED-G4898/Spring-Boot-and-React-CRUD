package dev.redg.springbootreactapp.model.service;

import java.util.List;

import dev.redg.springbootreactapp.model.entity.Product;

public interface ProductService {
  // Get methods
  public List<Product> getProductList();
  public Product getProduct(String barcode);

  // Post methods
  public Product addProduct(Product product);

  // Put methods
  public Product updateProduct(Product product);

  // Delete methods
  void deleteProduct(String barcode);
}
