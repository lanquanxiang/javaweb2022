package cn.edu.pzhu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.edu.pzhu.pojo.Num;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public OnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	synchronized (OnlineListener.class) {
    		if("user".equals(se.getName())) {
    			System.out.println("有用户数据被加入了session");
    	   	     int num =  Num.getOnline()+1;
    	   	     Num.setOnline(num);
    	   	     se.getSession().getServletContext().setAttribute("online", num); //存入域对象，提供给前端页面使用
    		}
		}    
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	synchronized (OnlineListener.class) {
    		if("user".equals(se.getName())) {
    			System.out.println("有用户数据从session中解绑");
    	   	     int num =  Num.getOnline()-1;
    	   	     Num.setOnline(num);
    	   	     se.getSession().getServletContext().setAttribute("online", num); //存入域对象，提供给前端页面使用
    		}
		} 
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
