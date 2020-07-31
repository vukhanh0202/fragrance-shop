package com.gemstones.controller.web;

import com.gemstones.converter.Product_ProductSizeConverter;
import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.entity.Product_ProductSizeEntity;
import com.gemstones.repository.Product_ProductSizeRepository;
import com.gemstones.service.IProduct_ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller(value = "detailProductControllerOfWeb")
public class DetailProductController extends BaseController{

    @Autowired
    private IProduct_ProductSizeService product_productSizeService;

    @RequestMapping(value = "/chi-tiet/{name}", method = RequestMethod.GET)
    public ModelAndView listDetailProduct(@RequestParam("id") Long id, @PathVariable String name) {
        Product_ProductSizeDTO model = product_productSizeService.findOneById(id);
        mav.setViewName("web/detailProduct");

        List<Product_ProductSizeDTO> listProduct = product_productSizeService.findAllByProductIdAndStatus(model.getProduct().getId(),1);

        List<Product_ProductSizeDTO> listInvokle = new ArrayList<>();
        listInvokle = product_productSizeService.find4LessPrice(model.getNewPriceSale() + 1);
        if (listInvokle.size() < 4){
            listInvokle = product_productSizeService.find4GreaterPrice(model.getNewPriceSale() + 1);
        }
        if (listInvokle.size() < 4){
            listInvokle =product_productSizeService.findAll();
        }
        model.setListResult(listInvokle.subList(0,4));

        mav.addObject("model",model);
        mav.addObject("listProduct",listProduct);

        return mav;
    }


}
