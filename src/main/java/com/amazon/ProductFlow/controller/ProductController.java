package com.amazon.ProductFlow.controller;

import com.amazon.ProductFlow.model.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.amazon.ProductFlow.reader.ProductReader;
import com.amazon.ProductFlow.writer.TemplateWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @PostMapping("/processar-planilha")
    public ResponseEntity<byte[]> processar(@RequestParam("planilhaOrigem") MultipartFile planilhaOrigem,
                                      @RequestParam("planilhaTemplate") MultipartFile planilhaTemplate) throws IOException {
        ProductReader reader = new ProductReader();
        List<Product> produtos = reader.lerProdutos(planilhaOrigem.getInputStream());

        TemplateWriter writer = new TemplateWriter();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writer.escreverProduto(produtos, planilhaTemplate.getInputStream(), outputStream);

        byte[] arquivoGerado = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "planilha-preenchida.xlsx");

        return new ResponseEntity<>(arquivoGerado, headers, HttpStatus.OK);
    }
}
