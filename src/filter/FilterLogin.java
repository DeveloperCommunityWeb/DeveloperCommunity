package filter;

import java.io.IOException;

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


@WebFilter("/FilterLogin")
public class FilterLogin implements Filter {
	private static int status = 0;
	private static int help = 0;

    public FilterLogin() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		((HttpServletResponse)response).setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		((HttpServletResponse)response).setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		((HttpServletResponse)response).setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		((HttpServletResponse)response).setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		HttpSession session = ((HttpServletRequest)request).getSession();
//		((HttpServletResponse)response).sendRedirect("/DeveloperCommunity/admin/index.html");
		if(session.getAttribute("user") == null){
			((HttpServletResponse)response).sendRedirect("/DeveloperCommunity/login");
		}else{
//			((HttpServletRequest)request).getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
			status = 1;
			if(status == 1 && help == 0){
				//((HttpServletRequest)request).getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
				((HttpServletResponse)response).sendRedirect("/DeveloperCommunity/admin/index.jsp");
				status = 2;
				help=1;
			}else{
				chain.doFilter(request, response);
			}
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
