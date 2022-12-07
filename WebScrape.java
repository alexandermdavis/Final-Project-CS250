import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScrape {

	public void display() throws Exception {
		final Document document = Jsoup.connect("https://weather.com/weather/today/l/41.8858,-87.6229").get();
		
	//Feels like
		for(Element info : document.select("div.TodayDetailsCard--feelsLikeTemp--2x1SW")) {
			final String feelsLike = info.select("span.TodayDetailsCard--feelsLikeTempValue--2icPt").text();
			String[] newFeelsLike = feelsLike.split("�"); //Can't get rid of this symbol after the temperature
			System.out.println("Feels like " + newFeelsLike[0] + " right now.");
		}
	//High/Low
		for(Element info : document.select("div.CurrentConditions--tempHiLoValue--3T1DG")) {
			final String highLow = info.select("span").text();
			String[] newHighLow = highLow.split(" ");
			System.out.println("The high is: " + newHighLow[0]);
			System.out.println("The low is: "+ newHighLow[1]);
			System.out.println("");
		}
	//Current Condition
		for(Element info : document.select("div.CurrentConditions--phraseValue--mZC_p")) {
			String i = info.toString();
			String[] j = i.split(" ");
			String[] k = j[3].split("<");
			System.out.println("It is currently " + k[0] + "out right now.");
			System.out.println("");
		}
	//Stats
		for(Element info : document.select("div.TodayDetailsCard--detailsContainer--2yLtL")) {
			final String stats = info.select("span").text();
			String[] newStats = stats.split(" ");
			String d = newStats[7].substring(0, 2);
			System.out.println(newStats[2] + " " + newStats[3] + " " + newStats[4] + " " + newStats[5]);
			System.out.println("Humidity: " + newStats[6]);
			System.out.println("Dew Point: " + d + " degrees");
			System.out.println("Pressure: " + newStats[10] + " " + newStats[11]);
			System.out.println("UV Index: " + newStats[12] + " " + newStats[13] + " " + newStats[14]);
			System.out.println("Visibility: " + newStats[15] + " miles");
		}
	}
}
