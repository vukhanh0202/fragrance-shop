package com.gemstones.controller.admin;

import com.gemstones.dto.Product_ProductSizeDTO;
import com.gemstones.service.IProductService;
import com.gemstones.service.IProductSizeService;
import com.gemstones.service.IProduct_ProductSizeService;
import com.gemstones.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "productAndSizeControllerAdmin")
public class Product_ProductSizeController {

    @Autowired
    private IProduct_ProductSizeService product_productSizeService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductSizeService productSizeService;

    @RequestMapping(value = "/quan-tri/san-pham/danh-sach-san-pham-day-du", method = RequestMethod.GET)
    public ModelAndView showListProductAndSize(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                               @RequestParam(value = "tim-kiem", required = false) String searckText,
                                               @RequestParam(value = "orderby", required = false) String orderby) {
        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }

        /*Full*/
        Product_ProductSizeDTO model = new Product_ProductSizeDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(product_productSizeService.findAllByProductNameAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(product_productSizeService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);
        /*End Full*/

        /*Male*/
        Product_ProductSizeDTO modelMale = new Product_ProductSizeDTO();

        modelMale.setPage(page);
        modelMale.setLimit(limit);
        modelMale.setListResult(product_productSizeService.findAllByProductNameAndGenderAndOrderBy(pageable, searckText,"Nam", orderby));
        modelMale.setTotalItem(product_productSizeService.getTotalItemByGender("Nam"));
        modelMale.setTotalPage((int) Math.ceil((double) modelMale.getTotalItem() / modelMale.getLimit()));
        modelMale.setOrderBy(orderby);
        /*End Male*/

        /*Female*/
        Product_ProductSizeDTO modelFemale = new Product_ProductSizeDTO();

        modelFemale.setPage(page);
        modelFemale.setLimit(limit);
        modelFemale.setListResult(product_productSizeService.findAllByProductNameAndGenderAndOrderBy(pageable, searckText,"Nữ", orderby));
        modelFemale.setTotalItem(product_productSizeService.getTotalItemByGender("Nữ"));
        modelFemale.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelFemale.setOrderBy(orderby);
        /*End Female*/

        /*Active*/
        Product_ProductSizeDTO modelActive = new Product_ProductSizeDTO();

        modelActive.setPage(page);
        modelActive.setLimit(limit);
        modelActive.setListResult(product_productSizeService.findAllByProductNameAndStatusAndOrderBy(pageable, searckText, "Đang hoạt động", orderby));
        modelActive.setTotalItem(product_productSizeService.getTotalItemByStatus("Đang hoạt động"));
        modelActive.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelActive.setOrderBy(orderby);
        /*End Active*/

        /*Inactive*/
        Product_ProductSizeDTO modelInactive = new Product_ProductSizeDTO();

        modelInactive.setPage(page);
        modelInactive.setLimit(limit);
        modelInactive.setListResult(product_productSizeService.findAllByProductNameAndStatusAndOrderBy(pageable, searckText,"Ngừng hoạt động", orderby));
        modelInactive.setTotalItem(product_productSizeService.getTotalItemByStatus("Ngừng hoạt động"));
        modelInactive.setTotalPage((int) Math.ceil((double) modelFemale.getTotalItem() / modelFemale.getLimit()));
        modelInactive.setOrderBy(orderby);
        /*End Inactive*/




        ModelAndView mav = new ModelAndView("admin/products/listProductAndSize");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        mav.addObject("modelMale", modelMale);
        mav.addObject("modelFemale", modelFemale);
        mav.addObject("modelActive", modelActive);
        mav.addObject("modelInactive", modelInactive);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/san-pham/chinh-sua-san-pham-day-du", method = RequestMethod.GET)
    public ModelAndView editProductAndSize(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("admin/products/editProductAndSize");
        Product_ProductSizeDTO model = new Product_ProductSizeDTO();
        if (id != null) {
            model = product_productSizeService.findOneById(id);
            model.setProductId(model.getProduct().getId());
            model.setProductSizeId(model.getProductSize().getId());
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("listProduct", productService.findAll());
        mav.addObject("listProductSize", productSizeService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
