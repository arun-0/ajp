package myPack;

import com.opensymphony.xwork2.ActionSupport;

public class upperAction extends ActionSupport {
	
	private String name;
	
	public String execute() throws Exception {
		
			System.out.println("Hello executing action");
			//int i=10;
			if(name.equalsIgnoreCase("admin")) {
				return "success";
			} else {
				System.out.println("Error");
				return "error";
			}
		
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }


}
