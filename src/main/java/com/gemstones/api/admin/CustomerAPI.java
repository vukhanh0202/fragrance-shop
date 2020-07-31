package com.gemstones.api.admin;

import com.gemstones.dto.CustomerDTO;
import com.gemstones.service.ICustomerService;
import com.gemstones.service.IProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "customerAPIOfAdmin")
public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/api/customer")
    public CustomerDTO createProductSize(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @PutMapping("/api/customer")
    public CustomerDTO updateProduct(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @DeleteMapping("/api/customer")
    public void deleteProduct(@RequestBody Long[] ids) {
        customerService.delete(ids);
    }
}
