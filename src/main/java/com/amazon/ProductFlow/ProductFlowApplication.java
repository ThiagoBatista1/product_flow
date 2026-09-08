package com.amazon.ProductFlow;

import model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reader.ProductReader;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ProductFlowApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProductFlowApplication.class, args);
		ProductReader reader = new ProductReader();
		List<Product> produtos = reader.lerProdutos("src/main/resources/planilha_teste.xlsx");

		for(Product produto : produtos){
			System.out.println(produto);
		}
	}
}
