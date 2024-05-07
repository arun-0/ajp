package myPack;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.Interceptor;  

public class myIntercept  implements Interceptor {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init() {}  
	
	    public String intercept(ActionInvocation ai) throws Exception {  
	        System.out.println("pre processing");
	        System.out.println("Login time : "+new Date());
	        String result = ai.invoke();
	        System.out.println(" postprocessing");
	        System.out.println("Logout time : "+new Date());
	        return result;
	        
	    }  
	    
	    public void destroy() {}  
}
