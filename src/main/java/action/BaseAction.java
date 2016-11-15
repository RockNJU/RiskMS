package action;

import java.util.Map;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware,  
        ServletRequestAware, ServletResponseAware,ServletContextAware {  
  
    private static final long serialVersionUID = 1L;  
    public ServletContext context;
    public HttpServletRequest   req;  
    public HttpServletResponse  resp;  
    public Map session;
	public ServletContext getServletContext() {
		return context;
	}
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	public HttpServletRequest getServletRequest() {
		return req;
	}
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.req = servletRequest;
	}
	public HttpServletResponse getServletResponse() {
		return resp;
	}
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.resp = servletResponse;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
  
}

