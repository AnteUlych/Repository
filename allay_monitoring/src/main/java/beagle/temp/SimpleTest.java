package beagle.temp;


import beagle.dispatcher.Sender;


public class SimpleTest {

	public static void main(String[] args) {

		Sender bird = new Sender("Anton", "satoru@i.ua", "satoru@i.ua", "xzx", 50, 15, "status", "etd", "update");
		bird.sendMonitoring();
		System.out.println("done");
	}

}
