package io.jameshalearning.retailmanydataapi.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/product", headers = "Accept=application/json",method=RequestMethod.POST)
	public Product addProducts(@RequestBody Product product) {
		return productService.addProducts(product);
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public Product getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

	@RequestMapping(value="/product/{id}",method = RequestMethod.DELETE)
	public String removeProductById(@PathVariable Integer id){
		productService.removeProductById(id);
		return "Product " + id + " deleted Successfully!!!";
	}

}
