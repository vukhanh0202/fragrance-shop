package com.gemstones.controller.web;

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

@Controller(value = "baseControllerOfWeb")
public class BaseController {

    @Autowired
    IProductService productService;

    @Autowired
    IProduct_ProductSizeService product_productSizeService;

    public ModelAndView mav = new ModelAndView();

    @PostConstruct
    public ModelAndView Init () {
        List<ProductDTO> allProductSize= productService.findAll();
        List<String> names = new ArrayList<>();
        List<String> images = new ArrayList<>();
        List<Long> ids = new ArrayList<>();

        for (ProductDTO item:
                allProductSize) {
            if (product_productSizeService.findAllByProductIdAndStatus(item.getId(),1).size() != 0){
                names.add('"'+ item.getName()+'"');
                Product_ProductSizeDTO tempItem = product_productSizeService.findAllByProductIdAndStatus(item.getId(),1).get(0);
                images.add('"'+tempItem.getImages()+'"');
                ids.add(tempItem.getId());
            }
        }
        mav.addObject("names", names);
        mav.addObject("images", images);
        mav.addObject("ids", ids);

        return mav;
    }
}
