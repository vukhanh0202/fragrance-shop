package com.gemstones.controller.admin;

import com.gemstones.dto.CustomerDTO;
import com.gemstones.service.ICustomerService;
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

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/quan-tri/doi-tac/khach-hang", method = RequestMethod.GET)
    public ModelAndView showListExportBill(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest req,
                                           @RequestParam(value = "tim-kiem", required = false) String searckText,
                                           @RequestParam(value = "orderby", required = false) String orderby) {
        if (orderby == null) {
            orderby = "asc";
        }
        if (searckText == null) {
            searckText = "";
        }

        CustomerDTO model = new CustomerDTO();

        model.setPage(page);
        model.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(customerService.findAllByNameAndOrderBy(pageable, searckText, orderby));
        model.setTotalItem(customerService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        model.setOrderBy(orderby);

        ModelAndView mav = new ModelAndView("admin/partner/customer");
        if (req.getParameter("message") != null) {
            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }
}
