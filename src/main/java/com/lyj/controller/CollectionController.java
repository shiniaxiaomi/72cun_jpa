package com.lyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 陆英杰
 * 2018/11/13 15:51
 */

@Controller
@RequestMapping("/collection")
public class CollectionController {

    //javascript:(function(x){window.open('http://www.usetools.cn/collection/url?url=[url]'.replace('[url]', encodeURIComponent(location.href)));})(document);



    @RequestMapping("/url")
    public ModelAndView colleciton(@RequestParam("url") String url, @RequestParam("title") String title){

        ModelAndView mv=new ModelAndView("collection");

        mv.addObject("url",url);
        mv.addObject("title",title);


        return mv;

    }

}
