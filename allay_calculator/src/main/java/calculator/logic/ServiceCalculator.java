package calculator.logic;

public class ServiceCalculator {
	
	public ServiceCalculator(String route, int volume, int weight) {
		this.route=route;
		this.volume = volume;
		this.weight = weight;
	}
	
	String route;
	int volume;
	int weight;
	
	int railPossibility = 9;
	String separator = "\\|";
	
	public boolean isRailRatePossible(){
		
		String [] way = route.split(separator);
		int ways = way.length;
		
		if(ways==railPossibility){
			return true;
		}
		return false;
	}
	public int getSeaRate(){
		String [] way = route.split(separator);
		int rate = Integer.parseInt(way[1])*volume+Integer.parseInt(way[4])*volume;
		return rate;	
	}
	
public int getRailRate(){	
		String [] way = route.split(separator);
		int rate = Integer.parseInt(way[7])*volume+Integer.parseInt(way[4])*volume;
		return rate;	
	}

public int getSeaTime(){
	String [] way = route.split(separator);
	int rate = Integer.parseInt(way[2])+Integer.parseInt(way[5]);
	return rate;	
}

public int getRailTime(){	
	String [] way = route.split(separator);
	int rate = Integer.parseInt(way[8])+Integer.parseInt(way[5]);
	return rate;	
}

public String getWay(){	
	String [] way = route.split(separator);
	String route = "FCA/FOB " + way[0] + " - FOT "+way[3] + ", Ukraine";
	return route;	
}
	
}
