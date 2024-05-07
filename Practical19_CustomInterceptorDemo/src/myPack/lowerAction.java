package myPack;

public class lowerAction {
	
	private String name;

	   public String execute() throws Exception {
		   name=name.toLowerCase();
	      return "success";
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }


}
