import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class CropScrap {
public static void main(String[]args)throws IOException{
	
System.out.println(croapRozetka());

	
}
public static List<Croap> croapRozetka(){
	List<Croap>croaps=new ArrayList<Croap>();
	
	//Buckwheat Parsing in Rozetka
	String buckwheatRozetka="https://rozetka.com.ua/ua/art_foods_4820191590977/p47538592/characteristics/";

	String buckwheatPriceHTML="<div class=\"product-carriage__price product-carriage__price_color_red\"> 55<span class=\"product-carriage__price-symbol\">";
	String buckwheatNameHTML="<a href=\"/ua/krupy/c4628397/vid-225787=grechka/\">Гречка</a>";
	String buckwheatCategoryHTML="<a href=\"/ua/krupy/c4628397/tip170598=obgarennaya/\">Обсмажена</a>";
	String buckwheatProducerHTML="<a href=\"/ua/krupy/c4628397/strana-proizvoditelj-tovara-90098=544338/\">Україна</a>";
	String buckwheatWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=751-g-1000-g/\">1 кг</a>";


	Document buckwheatPriceDoc=Jsoup.parse(buckwheatPriceHTML,buckwheatRozetka);
	Document buckwheatNameDoc=Jsoup.parse(buckwheatNameHTML,buckwheatRozetka);
	Document buckwheatCategoryDoc=Jsoup.parse(buckwheatCategoryHTML,buckwheatRozetka);
	Document buckwheatWeightDoc=Jsoup.parse(buckwheatWeightHTML,buckwheatRozetka);
	Document buckwheatProducerDoc=Jsoup.parse(buckwheatProducerHTML,buckwheatRozetka);


	String buckwheatPrice=buckwheatPriceDoc.body().text();
	String buckwheatName=buckwheatNameDoc.body().text();
	String buckwheatCategory=buckwheatCategoryDoc.body().text();
	String buckwheatProducer=buckwheatProducerDoc.body().text();
	String buckwheatWeight=buckwheatWeightDoc.body().text();
	String buckwheatResource=buckwheatRozetka;
	
	//Wheat Parsing in Rozetka
	//In process...
	/*
	String wheatRozetka="https://rozetka.com.ua/ua/terra_4820015730794/p23653956/characteristics/";
	
	String wheatPriceHTML="<div class=\"product-carriage__price\"> 17<span class=\"product-carriage__price-symbol\">";
	String wheatNameHTML="<a href=\"/ua/krupy/c4628397/vid-225787=pshenichnaya-krupa/\">Пшенична крупа</a>";
	String wheatCategoryHTML="<a href=\"/ua/krupy/c4628397/tip170598=obgarennaya/\">Обсмажена</a>";
	String wheatProducerHTML="<a href=\"/ua/krupy/c4628397/strana-proizvoditelj-tovara-90098=544338/\">Україна</a>";
	String wheatWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=501-g-750-g/\">700 г</a>";


	Document wheatPriceDoc=Jsoup.parse(buckwheatPriceHTML,buckwheatRozetka);
	Document wheatNameDoc=Jsoup.parse(buckwheatNameHTML,buckwheatRozetka);
	Document wheatCategoryDoc=Jsoup.parse(buckwheatCategoryHTML,buckwheatRozetka);
	Document wheatWeightDoc=Jsoup.parse(buckwheatWeightHTML,buckwheatRozetka);
	Document wheatProducerDoc=Jsoup.parse(buckwheatProducerHTML,buckwheatRozetka);


	String wheatPrice=buckwheatPriceDoc.body().text();
	String wheatName=buckwheatNameDoc.body().text();
	String wheatCategory=buckwheatCategoryDoc.body().text();
	String wheatProducer=buckwheatProducerDoc.body().text();
	String wheatWeight=buckwheatWeightDoc.body().text();
	String wheatResource=buckwheatRozetka;
	*/
	Croap buckwheat=new Croap(buckwheatPrice, buckwheatName, buckwheatCategory, buckwheatProducer, buckwheatWeight, buckwheatResource);
	croaps.add(buckwheat);
	
	
	return croaps;
	
}
}
