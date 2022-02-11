package box.logic;

public class SecurityAccess {
	
	public boolean isAccessNotAllowForManagerId(int managerid){
		if(managerid==19 //victor
				||managerid==20 //Yievgen
				||managerid==22 //Angelina
				||managerid==23 //Olga
				||managerid==25){ //Alla
			return true;
		}
		return false;	
	}

}
