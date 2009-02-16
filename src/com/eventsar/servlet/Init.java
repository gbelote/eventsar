package com.eventsar.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

import org.apache.velocity.*;
import org.apache.velocity.app.*;
import org.apache.velocity.servlet.*;
import org.apache.velocity.context.*;

import com.eventsar.util.VelocityUtil;

public class Init extends HttpServlet
{
    public void init () {
        final String prefix = getServletContext().getRealPath("/");
        VelocityUtil.init( prefix );
    }
}

