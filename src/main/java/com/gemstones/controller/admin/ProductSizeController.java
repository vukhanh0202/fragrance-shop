package com.gemstones.controller.admin;

import com.gemstones.dto.ProductSizeDTO;
import com.gemstones.service.IProductSizeService;
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

@Controller(value = "productSizeControllerAdmin")
public class ProductSizeController {

    @Autowired
    private IProductSizeService productSizeService;


    @RequestMapping(value = "/quan-tri/san-pham/danh-sach-size", method = RequestMethod.GET)
    public ModelAndView showListProductSize(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                            @RequestParam(value = "tim-kiem", required = false) String searckText,
                                            @RequestParam(value = "orderby", required = false) String orderby) {

        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }

        ProductSizeDTO model = new ProductSizeDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(productSizeService.findAllBySizeAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(productSizeService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);

        ModelAndView mav = new ModelAndView("admin/products/listSize");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/san-pham/chinh-sua-size", method = RequestMethod.GET)
    public ModelAndView editProductsize(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("admin/products/editSize");
        ProductSizeDTO model = new ProductSizeDTO();
        if (id != null) {
            model = productSizeService.findOneById(id);
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
}
