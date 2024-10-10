package cn.edu.pzhu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class VisitorListener
 *
 */
@WebListener
public class VisitorListener implements HttpSessionListener {
	
	private static int v = 0; //历史访问人数

    /**
     * Default constructor. 
     */
    public VisitorListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        synchronized (VisitorListener.class) {
			v = v + 1;
			System.out.println("监听到新的链接");
			se.getSession().getServletContext().setAttribute("v", v);
		}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
