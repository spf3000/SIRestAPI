package hello;

import java.time.*;


public class Age {
	LocalDate nowDate;
	public Age() {
		nowDate = LocalDate.now();
	}
	
	public LocalDate getAge(){
		return this.nowDate;
	}
	public String splitDate(String dateString){
		StringBuilder dateBuilder = new StringBuilder();
		int i = 0;
			while(dateString.charAt(i) !='\"'){
				System.out.println("c "+dateString.charAt(i));
				i+=1;
			}
			i+=1;
			while(dateString.charAt(i)!='\"'){
				System.out.println("d "+dateString.charAt(i));
				dateBuilder.append(dateString.charAt(i));
				i+=1;
			}
		
		return dateBuilder.toString();
	}
	
	public int calculateAge(String birth){
		LocalDate birthDate = LocalDate.parse(birth);				
				if ((birthDate != null) && (this.nowDate != null)) {
          return Period.between(birthDate, this.nowDate).getYears();
      } else {
          return 0;
      }
	
				
	}
	
	
	
}
