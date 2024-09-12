package sample.sp24.t4s4.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.sp24.t4s4.user.UserDTO;

/**
 *
 * @author PC
 */
@WebFilter(filterName = "NewFilter", urlPatterns = {"/*"})
public class AuthenFilter implements Filter {

    private static final boolean debug = true;

    private static List<String> USER_RESOURCES;
    private static List<String> ADMIN_RESOURCES;
    private static List<String> NON_AUTHEN_RESOURCES;

    private static final String US = "US";
    private static final String AD = "AD";
    private static final String LOGIN_PAGE = "login.html";

    private FilterConfig filterConfig = null;

    public AuthenFilter() {
        USER_RESOURCES = new ArrayList<>();
        USER_RESOURCES.add("user.jsp");
        ADMIN_RESOURCES = new ArrayList<>();
        ADMIN_RESOURCES.add("admin.jsp");
        ADMIN_RESOURCES.add("user.jsp");
        NON_AUTHEN_RESOURCES = new ArrayList<>();
        NON_AUTHEN_RESOURCES.add("login.html");
        NON_AUTHEN_RESOURCES.add("login.html");
        NON_AUTHEN_RESOURCES.add("MainController");
        NON_AUTHEN_RESOURCES.add(".jpg");
        NON_AUTHEN_RESOURCES.add(".gif");
        NON_AUTHEN_RESOURCES.add("shopping.html");
        NON_AUTHEN_RESOURCES.add("shopping.jsp");

    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("NewFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("NewFilter:DoAfterProcessing");
        }

    }

 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        int index = uri.lastIndexOf("/");
        String resource = null;
        boolean checkContain = false;
        for (String str : NON_AUTHEN_RESOURCES) {
            if (uri.contains(str)) {
                checkContain = true;
                break;
            }
        }
        if (checkContain) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = req.getSession();
            if (session == null || session.getAttribute("LOGIN_USER") == null) {
                res.sendRedirect(LOGIN_PAGE);
            } else {
                String roleID = ((UserDTO) session.getAttribute("LOGIN_USER")).getRoleID();
                if (AD.equals(roleID) && ADMIN_RESOURCES.contains(resource)) {
                    chain.doFilter(request, response);
                } else if (US.equals(roleID) && USER_RESOURCES.contains(resource)) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(LOGIN_PAGE);
                }
            }
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

 
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("NewFilter:Initializing filter");
            }
        }
    }

    
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("NewFilter()");
        }
        StringBuffer sb = new StringBuffer("NewFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
