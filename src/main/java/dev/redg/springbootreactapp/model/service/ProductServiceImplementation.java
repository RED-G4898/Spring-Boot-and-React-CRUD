package dev.redg.springbootreactapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.redg.springbootreactapp.model.entity.Product;
import dev.redg.springbootreactapp.model.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getProductList() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public Product getProduct(String barcode) {
    return productRepository.findById(barcode).orElse(null);
  }

  @Override
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product updateProduct(Product product) {
    Product productDB = getProduct(product.getBarcode());
    if (productDB == null) {
      return null;
    }
    productDB.setName(product.getName());
    return productRepository.save(productDB);
  }

  @Override
  public void deleteProduct(String barcode) {
    productRepository.deleteById(barcode);
  }
}
