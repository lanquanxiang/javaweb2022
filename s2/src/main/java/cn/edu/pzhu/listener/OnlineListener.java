package cn.edu.pzhu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionAttributeListener {
	
	private static int o = 0;

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
			if ("user".equals(se.getName())) { //加入session域的有可能不是user，有可能是错误消息msg
				o= o+1;
				se.getSession().getServletContext().setAttribute("o", o);
				System.out.println("用户上线了");
			}
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	 synchronized (OnlineListener.class) {
 			if ("user".equals(se.getName())) { //加入session域的有可能不是user，有可能是错误消息msg
 				o= o-1;
 				se.getSession().getServletContext().setAttribute("o", o);
 				System.out.println("用户下线了");
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
