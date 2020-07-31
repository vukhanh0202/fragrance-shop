package com.gemstones.api.admin;

import com.gemstones.dto.ProductDTO;
import com.gemstones.entity.ProductEntity;
import com.gemstones.service.IProductService;
import com.gemstones.service.impl.ProductService;
import com.gemstones.utils.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {


    @Autowired
    private IProductService productService;

    @PostMapping("/api/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
     /*   ProductDTO pro = productService.findOneById((long) 86);
        byte[] decodeBase64 = Base64.getDecoder().decode(pro.getImagesByte());
        UploadFileUtils.writeOrUpdate(decodeBase64, "/thumnail/" + "test.jpg");
        return productDTO;*/
        /*productDTO = productService.save(productDTO);
        return productDTO;*/
        return productService.save(productDTO);
    }

    @PutMapping("/api/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/api/product")
    public void deleteProduct(@RequestBody Long[] ids) {
        productService.delete(ids);
    }
}
