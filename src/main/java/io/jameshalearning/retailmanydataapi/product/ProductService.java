package io.jameshalearning.retailmanydataapi.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> product = new ArrayList<Product>();
		productRepository.findAll().forEach(product::add);
		return product;
	}

	public Product addProducts(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}

	public void removeProductById(Integer id) {
		productRepository.deleteById(id);
	}
}
