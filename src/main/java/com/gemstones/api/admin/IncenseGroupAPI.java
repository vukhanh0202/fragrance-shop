package com.gemstones.api.admin;

import com.gemstones.dto.IncenseGroupDTO;
import com.gemstones.service.IIncenseGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "incenseGroupAPIOfAdmin")
public class IncenseGroupAPI {

    @Autowired
    private IIncenseGroupService incenseGroupService;

    @PostMapping("/api/incense-group")
    public IncenseGroupDTO createProductSize(@RequestBody IncenseGroupDTO incenseGroupDTO) {
     /*   ProductDTO pro = productService.findOneById((long) 86);
        byte[] decodeBase64 = Base64.getDecoder().decode(pro.getImagesByte());
        UploadFileUtils.writeOrUpdate(decodeBase64, "/thumnail/" + "test.jpg");
        return productDTO;*/
        /*productDTO = productService.save(productDTO);
        return productDTO;*/
        return incenseGroupService.save(incenseGroupDTO);
    }

    @PutMapping("/api/incense-group")
    public IncenseGroupDTO updateProduct(@RequestBody IncenseGroupDTO incenseGroupDTO) {
        return incenseGroupService.save(incenseGroupDTO);
    }

    @DeleteMapping("/api/incense-group")
    public void deleteProduct(@RequestBody Long[] ids) {
        incenseGroupService.delete(ids);
    }
}
