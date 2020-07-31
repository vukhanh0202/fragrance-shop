package com.gemstones.controller.web;

import com.gemstones.dto.CustomerDTO;
import com.gemstones.dto.ExportBillDTO;
import com.gemstones.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller(value = "paymentControllerOfWeb")
public class PaymentController extends BaseController{

    @RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
    public ModelAndView payment(HttpSession session, HttpServletRequest req) {
        //ModelAndView mav = new ModelAndView("web/payment");
        mav.setViewName("web/payment");

        CustomerDTO customer = new CustomerDTO();
        mav.addObject("Ship",30000d);
        mav.addObject("customer",customer);
        if (req.getParameter("message") != null) {

            session.invalidate(); // destroy a sesion

            Map<String, String> message = MessageUtils.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        return mav;
    }
}
