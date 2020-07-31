package com.gemstones.controller.web;


import com.gemstones.dto.ExportBillDTO;
import com.gemstones.dto.IncenseGroupDTO;
import com.gemstones.service.IExportBillService;
import com.gemstones.service.IProduct_ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller(value = "listCartControllerOfWeb")
public class ListCartController extends BaseController{

    @Autowired
    private IExportBillService cartService;

    @RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
    public ModelAndView listCart(HttpSession session) {
        ExportBillDTO cart = (ExportBillDTO) session.getAttribute("Cart");
        if (cart == null) {
            cart = new ExportBillDTO();
            cart.setTotalPrice(0d);
            cart.setTotalQuantity(0L);
        }
        session.setAttribute("Cart", cart);
        mav.setViewName("web/listCart");

        return mav;
    }

    @RequestMapping(value = "/AddCart/{id}", method = RequestMethod.GET)
    public String AddCart(HttpServletRequest req, HttpSession session, @PathVariable Long id) {

        ExportBillDTO cart = (ExportBillDTO) session.getAttribute("Cart");
        if (cart == null) {
            cart = new ExportBillDTO();
        }
        cart = cartService.addCart(id, cart);
        cart.setTotalPrice(cartService.getTotalPrice(cart));
        cart.setTotalQuantity(cartService.getTotalQuantity(cart));

        session.setAttribute("Cart", cart);
        return "redirect:" + req.getHeader("Referer");
    }

    @RequestMapping(value = "/Edit/{id}", method = RequestMethod.GET)
    public String EditCart(HttpServletRequest req, HttpSession session, @PathVariable Long id, @RequestParam Long quantity) {

        ExportBillDTO cart = (ExportBillDTO) session.getAttribute("Cart");
        if (cart == null) {
            cart = new ExportBillDTO();
        }
        cart = cartService.editCart(id, cart, quantity);
        cart.setTotalPrice(cartService.getTotalPrice(cart));
        cart.setTotalQuantity(cartService.getTotalQuantity(cart));

        session.setAttribute("Cart", cart);
        return "redirect:/gio-hang";
    }

    @RequestMapping(value = "/DeleteCart/{id}", method = RequestMethod.GET)
    public String DeleteCart(HttpServletRequest req, HttpSession session, @PathVariable Long id) {

        ExportBillDTO cart = (ExportBillDTO) session.getAttribute("Cart");
        if (cart == null) {
            cart = new ExportBillDTO();
        }
        cart = cartService.deleteCart(id, cart);
        cart.setTotalPrice(cartService.getTotalPrice(cart));
        cart.setTotalQuantity(cartService.getTotalQuantity(cart));

        session.setAttribute("Cart", cart);
        //return "redirect:" + req.getHeader("Referer");
        return "redirect:/gio-hang";

    }
}
