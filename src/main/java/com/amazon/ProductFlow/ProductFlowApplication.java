package com.amazon.ProductFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductFlowApplication {

	public static void main(String[] args) /*throws IOException*/ {
		SpringApplication.run(ProductFlowApplication.class, args);
//		ProductReader reader = new ProductReader();
//
//		try(FileInputStream fis = new FileInputStream("src/main/resources/planilha_teste.xlsx")){
//			List<Product> produtos = reader.lerProdutos(fis);
//
//			for(Product produto : produtos){
//				System.out.println(produto);
//			}
//
//			TemplateWriter writer = new TemplateWriter();
//
//			try (FileOutputStream fos = new FileOutputStream("src/main/resources/planilha_amazon_teste_produtos.xlsm.xlsx")) {
//				writer.escreverProduto(produtos, "src/main/resources/planilha_amazon_teste.xlsm.xlsx", fos);
//            }
//			System.out.println("Arquivo de saída gerado com sucesso!");
//		}

	}
}
