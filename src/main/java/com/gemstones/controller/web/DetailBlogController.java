package com.gemstones.controller.web;

import com.gemstones.dto.BlogDTO;
import com.gemstones.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "detailBlogControllerOfWeb")
public class DetailBlogController extends BaseController {

    @Autowired
    private IBlogService blogService;

    @RequestMapping(value = "/chi-tiet-bai-viet", method = RequestMethod.GET)
    public ModelAndView detailBlog(@RequestParam("id") Long id) {
        BlogDTO model = blogService.findOneById(id);

        mav.setViewName("web/detailBlog");
        mav.addObject("model",model);
        mav.addObject("listRelateBlog", blogService.findTop10ByTypeBlogAndOrOrderByModifiedDate(model.getTypeBlog()));
        return mav;
    }
}
