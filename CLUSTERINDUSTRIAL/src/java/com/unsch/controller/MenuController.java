/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Morpheus
 */
@RestController
public class MenuController {

    @RequestMapping(value = "/menu.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        return new ModelAndView("menu");
    }

    @RequestMapping(value = "/admin.htm")
    public ModelAndView adminview(HttpServletRequest request) {
        return new ModelAndView("admin");
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:index.htm");
    }
}
