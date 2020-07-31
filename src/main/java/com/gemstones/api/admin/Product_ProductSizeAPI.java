package com.gemstones.api.admin;

import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.service.IProduct_ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "product_ProductSizeAPIOfAdmin")
public class Product_ProductSizeAPI {

    @Autowired
    private IProduct_ProductSizeService product_productSizeService;

    @PostMapping("/api/product-productsize")
    public Product_ProductSizeDTO createProduct(@RequestBody Product_ProductSizeDTO productDTO) {
     /* ProductDTO pro = productService.findOneById((long) 86);
        byte[] decodeBase64 = Base64.getDecoder().decode(pro.getImagesByte());
        UploadFileUtils.writeOrUpdate(decodeBase64, "/thumnail/" + "test.jpg");
        return productDTO;*/
        /*productDTO = productService.save(productDTO);
        return productDTO;*/
        return product_productSizeService.save(productDTO);
    }

    @PutMapping("/api/product-productsize")
    public Product_ProductSizeDTO updateProduct(@RequestBody Product_ProductSizeDTO productDTO) {
        return product_productSizeService.save(productDTO);
    }

    @DeleteMapping("/api/product-productsize")
    public void deleteProduct(@RequestBody Long[] ids) {
        product_productSizeService.delete(ids);
    }
}
