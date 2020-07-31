package com.gemstones.api.admin;

import com.gemstones.dto.ProductSizeDTO;
import com.gemstones.service.IProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "productSizeAPIOfAdmin")
public class ProductSizeAPI {

    @Autowired
    private IProductSizeService productSizeService;

    @PostMapping("/api/product-size")
    public ProductSizeDTO createProductSize(@RequestBody ProductSizeDTO productSizeDTO) {
     /*   ProductDTO pro = productService.findOneById((long) 86);
        byte[] decodeBase64 = Base64.getDecoder().decode(pro.getImagesByte());
        UploadFileUtils.writeOrUpdate(decodeBase64, "/thumnail/" + "test.jpg");
        return productDTO;*/
        /*productDTO = productService.save(productDTO);
        return productDTO;*/
        return productSizeService.save(productSizeDTO);
    }

    @PutMapping("/api/product-size")
    public ProductSizeDTO updateProduct(@RequestBody ProductSizeDTO productSizeDTO) {
        return productSizeService.save(productSizeDTO);
    }

    @DeleteMapping("/api/product-size")
    public void deleteProduct(@RequestBody Long[] ids) {
        productSizeService.delete(ids);
    }
}
