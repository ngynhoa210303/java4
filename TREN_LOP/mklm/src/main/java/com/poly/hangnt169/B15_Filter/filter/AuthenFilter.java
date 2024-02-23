package com.poly.hangnt169.B15_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/sinh-vien/*",
        "/thuc-vat/*",
})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("Khi init");
    }

    public void destroy() {
        Filter.super.destroy();
        System.out.println("Khi destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do filter before");
        //B1: Ép kiểu HttpSe ->ServletRequest request
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String use = (String) session.getAttribute("uname");
        if (use == null) {
            res.sendRedirect("/Login14Servlet");
        } else {
            chain.doFilter(request, response);
            System.out.println("Do filter after");
        }

    }
}
