package cn.edu.pzhu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.edu.pzhu.pojo.Num;

/**
 * Application Lifecycle Listener implementation class VisitorListener
 *
 */
@WebListener
public class VisitorListener implements HttpSessionListener {

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
    		 System.out.println("有用户与服务器建立了链接");
    	     int num =  Num.getVisitor()+1;
    	     Num.setVisitor(num);
    	     se.getSession().getServletContext().setAttribute("visitor", num); //存入域对象，提供给前端页面使用
		}       
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	  
    }
	
}
