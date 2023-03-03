package dev.redg.springbootreactapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
  @Id
  private String barcode;

  @Column(length = 50, nullable = false)
  private String name;
}
