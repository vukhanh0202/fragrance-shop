package com.gemstones.api.admin;

import com.gemstones.dto.BlogDTO;
import com.gemstones.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "blogAPIOfAdmin")
public class BlogAPI {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/api/blog")
    public BlogDTO createProductSize(@RequestBody BlogDTO blogDTO) { return blogService.save(blogDTO);}

    @PutMapping("/api/blog")
    public BlogDTO updateProduct(@RequestBody BlogDTO blogDTO) {
        return blogService.save(blogDTO);
    }

    @DeleteMapping("/api/blog")
    public void deleteProduct(@RequestBody Long[] ids) {
        blogService.delete(ids);
    }
}
