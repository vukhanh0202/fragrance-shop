package com.gemstones.controller.admin;

import com.gemstones.dto.ProductDTO;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.service.IProductService;
import com.gemstones.service.IProduct_ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Controller(value = "baseControllerOfAdmin")
public class BaseController {

    @Autowired
    IProductService productService;

    @Autowired
    IProduct_ProductSizeService product_productSizeService;

    public ModelAndView mav = new ModelAndView();

}
