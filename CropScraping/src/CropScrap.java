import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CropScrap {
public static void main(String[]args)throws IOException, JSONException{
	
buckwheat();
System.out.println();
wheat();
System.out.println();
corn();
System.out.println();
rice();
System.out.println();
barley();
}

public static void buckwheat() throws  IOException, JSONException{
	List<Croap>buckwheats=new ArrayList<Croap>();
	//bkwt stands for buckwheat
	//Buckwheat Parsing in Rozetka
	
	//Getting URL, HTML code for parsing and extracting information such as weight,price,producer ...
	String bkwtRozUrl="https://rozetka.com.ua/ua/art_foods_4820191590977/p47538592/characteristics/";
	
	String buckwheatPriceHTML="<div class=\"product-carriage__price product-carriage__price_color_red\"> 55<span class=\"product-carriage__price-symbol\">";
	String buckwheatNameHTML="<a href=\"/ua/krupy/c4628397/strana-proizvoditelj-tovara-90098=544338/\">Україна</a>";
	String buckwheatCategoryHTML="<a href=\"/ua/krupy/c4628397/vid-225787=grechka/\">Гречка</a>";
	String buckwheatProducerHTML="<a href=\"/ua/krupy/c4628397/strana-proizvoditelj-tovara-90098=544338/\">Україна</a>";
	String buckwheatWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=751-g-1000-g/\">1 кг</a>";
	String imgRozUr="https://i2.rozetka.ua/goods/14397645/art_foods_4820191590977_images_14397645953.jpg";
//Extracting information by function parse() using Jsoup library,arguments of functions is html code and url of page where characteristics is:
	Document buckwheatPriceDoc=Jsoup.parse(buckwheatPriceHTML, bkwtRozUrl);
	Document buckwheatNameDoc=Jsoup.parse(buckwheatNameHTML, bkwtRozUrl);
	Document buckwheatCategoryDoc=Jsoup.parse(buckwheatCategoryHTML, bkwtRozUrl);
	Document buckwheatWeightDoc=Jsoup.parse(buckwheatWeightHTML, bkwtRozUrl);
	Document buckwheatProducerDoc=Jsoup.parse(buckwheatProducerHTML, bkwtRozUrl);


	String buckwheatPrice=buckwheatPriceDoc.body().text();
	String buckwheatName=buckwheatNameDoc.body().text();
	String buckwheatCategory=buckwheatCategoryDoc.body().text();
	String buckwheatProducer=buckwheatProducerDoc.body().text();
	String buckwheatWeight=buckwheatWeightDoc.body().text();
	String buckwheatResource= bkwtRozUrl;
	
	//Creating object of class Croap to store info and future transfer it to .json file
	Croap buckwheatRozetka=new Croap(buckwheatPrice, buckwheatName, buckwheatCategory, buckwheatProducer, buckwheatWeight, buckwheatResource,imgRozUr);
	buckwheats.add(buckwheatRozetka);
	//Buckwheat Parsing in Epicentre
	String bkwtEpicUrl="https://epicentrk.ua/shop/krupa-grechnevaya-khutorok-yadritsya-800-g-4820211661410.html?ssh=new&gclid=CjwKCAiAo5qABhBdEiwAOtGmbvlIB8sEwG8FDjHmtRqGPJeAElRmbaMvZVnWFvEFpASheUoa-zZFgRoCPiwQAvD_BwE";
	
	String bkwtEpicPriceHTML="<div class=\"p-price__main\" title=\"Цена: 39.90 грн/упак.\" data-text=\"грн/упак.\">39.90 </div>";
	String bkwtEpicNameHTML="<span class=\"p-char__value\"><span>Хуторок</span></span>";
	String bkwtEpicCategoryHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-krupa-grechnevaya/\" class=\"link link--blue link--inverted\">крупа гречана</a>";
	String bkwtEpicProducerHTML="<span class=\"p-char__value\"><span>Україна</span></span>";
	String bkwtEpicWeightHTML="<span class=\"p-char__value\"><span>800&nbsp;г</span></span>";
	String imgEpicUrl="https://cdn.27.ua/499/61/c2/2712002_1.jpeg";
	
	Document bkwtEpicPriceDoc=Jsoup.parse(bkwtEpicPriceHTML,bkwtEpicUrl);
	Document bkwtEpicNameDoc=Jsoup.parse(bkwtEpicNameHTML,bkwtEpicUrl);
	Document bkwtEpicCategoryDoc=Jsoup.parse(bkwtEpicCategoryHTML,bkwtEpicUrl);
	Document bkwtEpicProducerDoc=Jsoup.parse(bkwtEpicProducerHTML,bkwtEpicUrl);
	Document bkwtEpicWeightDoc=Jsoup.parse(bkwtEpicWeightHTML,bkwtEpicUrl);
	
	String bkwtEpicPrice=bkwtEpicPriceDoc.body().text();
	String bkwtEpicName=bkwtEpicNameDoc.body().text();
	String bkwtEpicCategory=bkwtEpicCategoryDoc.body().text();
	String bkwtEpicProducer=bkwtEpicProducerDoc.body().text();
	String bkwtEpicWeight=bkwtEpicWeightDoc.body().text();
	String bkwtEpicResource=bkwtEpicUrl;
	
	Croap buckwheatEpic=new Croap(bkwtEpicPrice, bkwtEpicName, bkwtEpicCategory, bkwtEpicProducer, bkwtEpicWeight,bkwtEpicResource,imgEpicUrl);
	buckwheats.add(buckwheatEpic);
	
	String bkwtAquaUrl="https://aquamarket.ua/uk/grechka/10047-khutorok-800-g-krupa-grechana-m-u.html";
	
	String bkwtAquaPriceHTML="<<div class=\"product-price\">40<sup>";
	String bkwtAquaNameHTML="<td>Хуторок</td>";
	String bkwtAquaCategoryHTML="<th colspan=\"2\">ХАРАКТЕРИСТИКИ ХУТОРОК, КРУПА ГРЕЧАНА, СМАЖЕНА, 800 Г</th>";
	String bkwtAquaProducerHTML="<td>Україна</td>";
	String bkwtAquaWeightHTML="<td>800</td>";
	String imgAquaUrl="https://aquamarket.ua/26890-small_default/khutorok-800-g-krupa-grechana-m-u.jpg";
	
	Document bkwtAquaPriceDoc=Jsoup.parse(bkwtAquaPriceHTML,bkwtAquaUrl);
	Document bkwtAquaNameDoc=Jsoup.parse(bkwtAquaNameHTML,bkwtAquaUrl);
	Document bkwtAquaCategoryDoc=Jsoup.parse(bkwtAquaCategoryHTML,bkwtAquaUrl);
	Document bkwtAquaProducerDoc=Jsoup.parse(bkwtAquaProducerHTML,bkwtAquaUrl);
	Document bkwtAquaWeightDoc=Jsoup.parse(bkwtAquaWeightHTML,bkwtAquaUrl);
	
	String bkwtAquaPrice=bkwtAquaPriceDoc.body().text();
	String bkwtAquaName=bkwtAquaNameDoc.body().text();
	String bkwtAquaCategory=bkwtAquaCategoryDoc.body().text();
	String bkwtAquaProducer=bkwtAquaProducerDoc.body().text();
	String bkwtAquaWeight=bkwtAquaWeightDoc.body().text();
	String bkwtAquaResource=bkwtAquaUrl;
	
	Croap buckwheatAqua=new Croap(bkwtAquaPrice, bkwtAquaName, bkwtAquaCategory, bkwtAquaProducer, bkwtAquaWeight,bkwtAquaResource,imgAquaUrl);
	buckwheats.add(buckwheatAqua);
	
	
	//Output of all crops
	/*
	for(Croap buckwheat:buckwheats) {
		System.out.println(buckwheat);
	}
	*/
	String imgEpicSecUrl="https://cdn.27.ua/499/3b/2f/1653551_1.jpeg";
	String imgAquaSecUrl="https://aquamarket.ua/52567-large_default/culinaro-green-buckwheat-grechka-zelena-400-g.jpg";
	String bkwtEpicSecUrl="https://epicentrk.ua/ua/shop/pervotsvit-grechka-s-belymi-gribami-250-g.html";
	
	//Scraping last 2 sort of buckwheats
	String bkwtEpicSecPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 27 грн/шт.\" data-text=\"грн/шт.\">\r\n"
			+ "27 </div>";
	String bkwtEpicSecNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-pervotsvit/\" class=\"link link--blue link--inverted\">Первоцвіт</a>";
	String bkwtEpicSecCategoryHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-krupa-grechnevaya/\" class=\"link link--blue link--inverted\">крупа гречана</a>";
	String bkwtEpicSecProducerHTML="<span>Україна</span>";
	String bkwtEpicSecWeightHTML="<span>250&nbsp;г</span>";
	
	Document bkwtEpicSecPriceDoc=Jsoup.parse(bkwtEpicSecPriceHTML,bkwtEpicSecUrl);
	Document bkwtEpicSecNameDoc=Jsoup.parse(bkwtEpicSecNameHTML,bkwtEpicSecUrl);
	Document bkwtEpicSecCategoryDoc=Jsoup.parse(bkwtEpicSecCategoryHTML,bkwtEpicSecUrl);
	Document bkwtEpicSecProducerDoc=Jsoup.parse(bkwtEpicSecProducerHTML,bkwtEpicSecUrl);
	Document bkwtEpicSecWeightDoc=Jsoup.parse(bkwtEpicSecWeightHTML,bkwtEpicSecUrl);
	
	String bkwtEpicSecPrice=bkwtEpicSecPriceDoc.body().text();
	String bkwtEpicSecName=bkwtEpicSecNameDoc.body().text();
	String bkwtEpicSecCategory=bkwtEpicSecCategoryDoc.body().text();
	String bkwtEpicSecProducer=bkwtEpicSecProducerDoc.body().text();
	String bkwtEpicSecWeight=bkwtEpicSecWeightDoc.body().text();
	String bkwtEpicSecResource=bkwtEpicSecUrl;
	Croap bkwtEpicSec=new Croap(bkwtEpicSecPrice, bkwtEpicSecName, bkwtEpicSecCategory, bkwtEpicSecProducer, bkwtEpicSecWeight, bkwtEpicSecResource,imgEpicSecUrl);
	buckwheats.add(bkwtEpicSec);
	
	String bkwtAquaSecUrl="https://aquamarket.ua/uk/grechka/31537-culinaro-green-buckwheat-grechka-zelena-400-g.html";
	
	String bkwtAquaSecPriceHTML="<<div class=\"product-price\">40<sup>";
	String bkwtAquaSecNameHTML="<td>Culinaro</td>";
	String bkwtAquaSecCategoryHTML="<td>Гречка</td>";
	String bkwtAquaSecProducerHTML="<td>Україна</td>";
	String bkwtAquaSecWeightHTML="<td>800</td>";
	
	Document bkwtAquaSecPriceDoc=Jsoup.parse(bkwtAquaSecPriceHTML,bkwtAquaSecUrl);
	Document bkwtAquaSecNameDoc=Jsoup.parse(bkwtAquaSecNameHTML,bkwtAquaSecUrl);
	Document bkwtAquaSecCategoryDoc=Jsoup.parse(bkwtAquaSecCategoryHTML,bkwtAquaSecUrl);
	Document bkwtAquaSecProducerDoc=Jsoup.parse(bkwtAquaSecProducerHTML,bkwtAquaSecUrl);
	Document bkwtAquaSecWeightDoc=Jsoup.parse(bkwtAquaSecWeightHTML,bkwtAquaSecUrl);
	
	String bkwtAquaSecPrice=bkwtAquaSecPriceDoc.body().text();
	String bkwtAquaSecName=bkwtAquaSecNameDoc.body().text();
	String bkwtAquaSecCategory=bkwtAquaSecCategoryDoc.body().text();
	String bkwtAquaSecProducer=bkwtAquaSecProducerDoc.body().text();
	String bkwtAquaSecWeight=bkwtAquaSecWeightDoc.body().text();
	String bkwtAquaSecResource=bkwtAquaSecUrl;
	Croap bkwtAquaSec=new Croap(bkwtAquaSecPrice, bkwtAquaSecName, bkwtAquaSecCategory, bkwtAquaSecProducer, bkwtAquaSecWeight, bkwtAquaSecResource,imgAquaSecUrl);
	buckwheats.add(bkwtAquaSec);
	
	//Creating JSON object and Json array to store object information
	JSONObject bkwtObject=new JSONObject();
	JSONArray arrayFirst=new JSONArray();
	arrayFirst.put("price: "+buckwheatRozetka.getPrice());
	arrayFirst.put("name: "+buckwheatRozetka.getName());
	arrayFirst.put("category: "+buckwheatRozetka.getCategory());
	arrayFirst.put("producer: "+buckwheatRozetka.getProducer());
	arrayFirst.put("weight: "+buckwheatRozetka.getResource());
	arrayFirst.put("resource: "+bkwtRozUrl);
	arrayFirst.put("image URL: "+imgRozUr);

	JSONArray arraySecond=new JSONArray();
	arraySecond.put("price: "+buckwheatEpic.getPrice());
	arraySecond.put("name: "+buckwheatEpic.getName());
	arraySecond.put("category: "+buckwheatEpic.getCategory());
	arraySecond.put("producer: "+buckwheatEpic.getProducer());
	arraySecond.put("weight: "+buckwheatEpic.getResource());
	arraySecond.put("resource: "+bkwtEpicUrl);
	arraySecond.put("image URL: "+imgEpicUrl);
	
	JSONArray arrayThird=new JSONArray();
	arrayThird.put("price: "+buckwheatAqua.getPrice());
	arrayThird.put("name: "+buckwheatAqua.getName());
	arrayThird.put("category: "+buckwheatAqua.getCategory());
	arrayThird.put("producer: "+buckwheatAqua.getProducer());
	arrayThird.put("weight: "+buckwheatAqua.getResource());
	arrayThird.put("resource: "+bkwtAquaSecUrl);
	arrayThird.put("image URL: "+imgAquaUrl);
	
	JSONArray arrayFourth=new JSONArray();
	arrayFourth.put("price: "+bkwtAquaSec.getPrice());
	arrayFourth.put("name: "+bkwtAquaSec.getName());
	arrayFourth.put("category: "+bkwtAquaSec.getCategory());
	arrayFourth.put("producer: "+bkwtAquaSec.getProducer());
	arrayFourth.put("weight: "+bkwtAquaSec.getResource());
	arrayFourth.put("resource: "+bkwtAquaSecUrl);
	arrayFourth.put("image URL: "+imgAquaSecUrl);
	
	JSONArray arrayFifth=new JSONArray();
	arrayFifth.put("price: "+bkwtEpicSec.getPrice());
	arrayFifth.put("name: "+bkwtEpicSec.getName());
	arrayFifth.put("category: "+bkwtEpicSec.getCategory());
	arrayFifth.put("producer: "+bkwtEpicSec.getProducer());
	arrayFifth.put("weight: "+bkwtEpicSec.getResource());
	arrayFifth.put("resource: "+bkwtEpicSec);
	arrayFifth.put("image URL: "+imgEpicSecUrl);
	
	
	bkwtObject.put("buckwheat #5", arrayFifth);
	bkwtObject.put("buckwheat #4",arrayFourth);
	bkwtObject.put("buckwheat #3", arrayThird);
	bkwtObject.put("buckwheat #2", arraySecond);
	bkwtObject.put("buckwheat #1", arrayFirst);
	
	//writing information to json file
	FileWriter fileWriter=new FileWriter("json_buckwheat_info.json");
	fileWriter.write(bkwtObject.toString());
	fileWriter.close();
	//bkwtArray.put
	System.out.println("JSON file with buckwheat info : "+bkwtObject);
}
public static void wheat() throws IOException, JSONException{
	//Wheat Parsing in Rozetka
		//In process...
	
	String imgRozUrl="https://i2.rozetka.ua/goods/2243145/terra_4820015730794_images_2243145258.jpg";
	String imgAquaUrl="https://aquamarket.ua/8193-small_default/ekorod-400-g-pshenichna-krupa-arnaut.jpg";
	String imgEpicUrl="https://cdn.27.ua/499/44/df/1721567_1.jpeg";
	String imgAquaSecUrl="https://aquamarket.ua/62183-small_default/avgust-800-g-krupi-pshenichni-z-tverdikh-sortiv.jpg";
	String imgEpicSecUrl="https://cdn.27.ua/499/58/6a/1726570_1.jpeg";
		List<Croap>wheats=new ArrayList<Croap>();
		String wheatRozetka="https://rozetka.com.ua/ua/terra_4820015730794/p23653956/characteristics/";
		
		String wheatPriceHTML="<div class=\"product-carriage__price\"> 17<span class=\"product-carriage__price-symbol\">";
		String wheatNameHTML="<a href=\"/ua/krupy/c4628397/vid-225787=pshenichnaya-krupa/\">Пшенична крупа</a>";
		String wheatCategoryHTML="<a href=\"/ua/krupy/c4628397/vid-225787=pshenichnaya-krupa/\">Пшенична крупа</a>";
		String wheatProducerHTML="<a href=\"/ua/krupy/c4628397/strana-proizvoditelj-tovara-90098=544338/\">Україна</a>";
		String wheatWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=501-g-750-g/\">700 г</a>";


		Document wheatPriceDoc=Jsoup.parse(wheatPriceHTML,wheatRozetka);
		Document wheatNameDoc=Jsoup.parse(wheatNameHTML,wheatRozetka);
		Document wheatCategoryDoc=Jsoup.parse(wheatCategoryHTML,wheatRozetka);
		Document wheatWeightDoc=Jsoup.parse(wheatWeightHTML,wheatRozetka);
		Document wheatProducerDoc=Jsoup.parse(wheatProducerHTML,wheatRozetka);


		String wheatPrice=wheatPriceDoc.body().text();
		String wheatName=wheatNameDoc.body().text();
		String wheatCategory=wheatCategoryDoc.body().text();
		String wheatProducer=wheatProducerDoc.body().text();
		String wheatWeight=wheatWeightDoc.body().text();
		String wheatResource=wheatRozetka;
		
	
		Croap wheatCroap=new Croap(wheatPrice, wheatName, wheatCategory, wheatProducer, wheatWeight, wheatResource,imgRozUrl);
		
	String wheatEpicUrl="https://epicentrk.ua/ua/shop/krupa-pshenichnaya-terra-bystrogo-prigotovleniya-400-g.html";
		
		String whtEpicPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 22.70 грн/шт.\" data-text=\"грн/шт.\">\r\n"
				+ "22.70 </div>";
		String whtEpicNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-terra/\" class=\"link link--blue link--inverted\">Терра</a>";
		String whtEpicCategoryHTML="<span>крупа пшенична</span>";
		String whtEpicProducerHTML="<span>Україна</span>";
		String whtEpicWeightHTML="<span class=\"p-char__value\"><span>400&nbsp;г</span>";


		Document whtEpicPriceDoc=Jsoup.parse(whtEpicPriceHTML,wheatEpicUrl);
		Document whtEpicNameDoc=Jsoup.parse(whtEpicNameHTML,wheatEpicUrl);
		Document whtEpicCategoryDoc=Jsoup.parse(whtEpicCategoryHTML,wheatEpicUrl);
		Document whtEpicWeightDoc=Jsoup.parse(whtEpicProducerHTML,wheatEpicUrl);
		Document whtEpicProducerDoc=Jsoup.parse(whtEpicWeightHTML,wheatEpicUrl);


		String whtEpicPrice=whtEpicPriceDoc.body().text();
		String whtEpicName=whtEpicNameDoc.body().text();
		String whtEpicCategory=whtEpicCategoryDoc.body().text();
		String whtEpicProducer=whtEpicProducerDoc.body().text();
		String whtEpicWeight=whtEpicWeightDoc.body().text();
		String whtEpicResource=wheatEpicUrl;
		
	Croap wheatEpic=new Croap(whtEpicPrice, whtEpicName, whtEpicCategory, whtEpicProducer, whtEpicWeight, whtEpicResource,imgEpicUrl);
		
	String whtAquaUrl="https://aquamarket.ua/uk/pshenichna-krupa/2353-ekorod-400-g-pshenichna-krupa-arnaut.html";
	
	String whtAquaPriceHTML="<div class=\"product-price\">28<sup>";
	String whtAquaNameHTML="<td>Екород</td>";
	String whtAquaCategoryHTML="<h1 class=\"product-name\">Екород, Крупа пшенична Арнаут, органічна, 400 г</h1>";
	String whtAquaProducerHTML="<td>Україна</td>";
	String whtAquaWeightHTML="<td>0 - 500</td>";


	Document whtAquaPriceDoc=Jsoup.parse(whtAquaPriceHTML,wheatEpicUrl);
	Document whtAquaNameDoc=Jsoup.parse(whtAquaNameHTML,wheatEpicUrl);
	Document whtAquaCategoryDoc=Jsoup.parse(whtAquaCategoryHTML,wheatEpicUrl);
	Document whtAquaWeightDoc=Jsoup.parse(whtAquaWeightHTML,wheatEpicUrl);
	Document whtAquaProducerDoc=Jsoup.parse( whtAquaProducerHTML,wheatEpicUrl);


	String whtAquaPrice=whtAquaPriceDoc.body().text();
	String whtAquaName=whtAquaNameDoc.body().text();
	String whtAquaCategory=whtAquaCategoryDoc.body().text();
	String whtAquaProducer=whtAquaProducerDoc.body().text();
	String whtAquaWeight=whtAquaWeightDoc.body().text();
	String whtAquaResource=wheatEpicUrl;
	
Croap wheatAqua=new Croap(whtAquaPrice, whtAquaName, whtAquaCategory, whtAquaProducer, whtAquaWeight, whtAquaResource,imgAquaUrl);

String whtEpicSecUrl="https://epicentrk.ua/ua/shop/krupa-pshenichnaya-sto-pudov-artek-dachka-212-g.html";

String whtEpicSecPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 6.80 грн/шт.\" data-text=\"грн/шт.\">\r\n"
		+ "6.80 </div>";
String whtEpicSecNameHTML="<span>Артек Дачка</span>";
String whtEpicSecCategoryHTML="<span>крупа пшенична</span>";
String whtEpicSecProducerHTML="<span>Україна</span>";
String whtEpicSecWeightHTML="<span>212&nbsp;г</span>";

Document whtEpicSecPriceDoc=Jsoup.parse(whtEpicSecPriceHTML,whtEpicSecUrl);
Document whtEpicSecNameDoc=Jsoup.parse(whtEpicSecNameHTML,whtEpicSecUrl);
Document whtEpicSecCategoryDoc=Jsoup.parse(whtEpicSecCategoryHTML,whtEpicSecUrl);
Document whtEpicSecProducerDoc=Jsoup.parse(whtEpicSecProducerHTML,whtEpicSecUrl);
Document whtEpicSecWeightDoc=Jsoup.parse(whtEpicSecWeightHTML,whtEpicSecUrl);

String whtEpicSecPrice=whtEpicSecPriceDoc.body().text();
String whtEpicSecName=whtEpicSecNameDoc.body().text();
String whtEpicSecCategory=whtEpicSecCategoryDoc.body().text();
String whtEpicSecProducer=whtEpicSecProducerDoc.body().text();
String whtEpicSecWeight=whtEpicSecWeightDoc.body().text();
String whtEpicSecResource=whtEpicSecUrl;
Croap whtEpicSec=new Croap(whtEpicSecPrice, whtEpicSecName, whtEpicSecCategory, whtEpicSecProducer, whtEpicSecWeight, whtEpicSecResource,imgEpicSecUrl);
wheats.add(whtEpicSec);

String whtAquaSecUrl="https://aquamarket.ua/uk/pshenichna-krupa/38683-avgust-800-g-krupi-pshenichni-z-tverdikh-sortiv.html";

String whtAquaSecPriceHTML="<div class=\"product-price\">\r\n"
		+ "                                                            27<sup>";
String whtAquaSecNameHTML="<td>Август</td>";
String whtAquaSecCategoryHTML="<td>Пшенична</td>";
String whtAquaSecProducerHTML="<td>Україна</td>";
String whtAquaSecWeightHTML="<td>800</td>";

Document whtAquaSecPriceDoc=Jsoup.parse(whtAquaSecPriceHTML,whtAquaSecUrl);
Document whtAquaSecNameDoc=Jsoup.parse(whtAquaSecNameHTML,whtAquaSecUrl);
Document whtAquaSecCategoryDoc=Jsoup.parse(whtAquaSecCategoryHTML,whtAquaSecUrl);
Document whtAquaSecProducerDoc=Jsoup.parse(whtAquaSecProducerHTML,whtAquaSecUrl);
Document whtAquaSecWeightDoc=Jsoup.parse(whtAquaSecWeightHTML,whtAquaSecUrl);

String whtAquaSecPrice=whtAquaSecPriceDoc.body().text();
String whtAquaSecName=whtAquaSecNameDoc.body().text();
String whtAquaSecCategory=whtAquaSecCategoryDoc.body().text();
String whtAquaSecProducer=whtAquaSecProducerDoc.body().text();
String whtAquaSecWeight=whtAquaSecWeightDoc.body().text();
String whtAquaSecResource=whtAquaSecUrl;
Croap whtAquaSec=new Croap(whtAquaSecPrice, whtAquaSecName, whtAquaSecCategory, whtAquaSecProducer, whtAquaSecWeight, whtAquaSecResource,imgAquaSecUrl);
wheats.add(whtAquaSec);


		JSONObject wheatJSON=new JSONObject();
		JSONArray arrayFirst=new JSONArray();
		arrayFirst.put("price: "+wheatCroap.getPrice());
		arrayFirst.put("name: "+wheatCroap.getName());
		arrayFirst.put("category: "+wheatCroap.getCategory());
		arrayFirst.put("producer: "+wheatCroap.getProducer());
		arrayFirst.put("weight: "+wheatCroap.getWeight());
		arrayFirst.put("resource: "+wheatRozetka);
		wheatJSON.put("wheat #1", arrayFirst);
		
		JSONArray arraySecond=new JSONArray();
		arraySecond.put("price: "+wheatEpic.getPrice());
		arraySecond.put("name: "+wheatEpic.getName());
		arraySecond.put("category: "+wheatEpic.getCategory());
		arraySecond.put("producer: "+wheatEpic.getProducer());
		arraySecond.put("weight: "+wheatEpic.getWeight());
		arraySecond.put("resource: "+wheatEpicUrl);
		wheatJSON.put("wheat #2", arraySecond);
		
		JSONArray arrayThird=new JSONArray();
		arrayThird.put("price: "+wheatAqua.getPrice());
		arrayThird.put("name: "+wheatAqua.getName());
		arrayThird.put("category: "+wheatAqua.getCategory());
		arrayThird.put("producer: "+wheatAqua.getProducer());
		arrayThird.put("weight: "+wheatAqua.getWeight());
		arrayThird.put("resource: "+whtAquaUrl);
		wheatJSON.put("wheat #3", arrayThird);
		
		JSONArray arrayFourth=new JSONArray();
		arrayFourth.put("price: "+whtEpicSec.getPrice());
		arrayFourth.put("name: "+whtEpicSec.getName());
		arrayFourth.put("category: "+whtEpicSec.getCategory());
		arrayFourth.put("producer: "+whtEpicSec.getProducer());
		arrayFourth.put("weight: "+whtEpicSec.getWeight());
		arrayFourth.put("resource: "+whtEpicSecUrl);
		wheatJSON.put("wheat #4", arrayFourth);
		
		JSONArray arrayFifth=new JSONArray();
		arrayFifth.put("price: "+whtAquaSec.getPrice());
		arrayFifth.put("name: "+whtAquaSec.getName());
		arrayFifth.put("category: "+whtAquaSec.getCategory());
		arrayFifth.put("producer: "+whtAquaSec.getProducer());
		arrayFifth.put("weight: "+whtAquaSec.getWeight());
		arrayFifth.put("resource: "+whtAquaSecUrl);
		
		arrayFirst.put("image URL: "+imgRozUrl);
		arraySecond.put("image URL: "+imgEpicUrl);
		arrayThird.put("image URL: "+imgAquaUrl);
		arrayFourth.put("image URL: "+imgEpicSecUrl);
		arrayFifth.put("image URL: "+imgAquaSecUrl);
		
		
		wheatJSON.put("wheat #5", arrayFifth);
		
		FileWriter fileWriter=new FileWriter("json_wheat_info.json");
		fileWriter.write(wheatJSON.toString());
		fileWriter.close();
		System.out.println("JSON file with wheat info: "+wheatJSON);
		wheats.add(wheatCroap);
		wheats.add(wheatEpic);
		wheats.add(wheatAqua);
		
}
public static void corn() throws JSONException, IOException {
	List<Croap>corns=new ArrayList<Croap>();
	String imgRozUrl="https://i8.rozetka.ua/goods/14397645/art_foods_4820191590892_images_14397645428.jpg";
	String imgAquaUrl="https://aquamarket.ua/62180-small_default/avgust-800-g-krupa-kukurudzyana.jpg";
	String imgEpicUrl="https://cdn.27.ua/499/44/dd/1721565_1.jpeg";
	String imgAquaSecUrl="https://aquamarket.ua/59771-small_default/skviryanka-800-g-krupa-kukurudzyana-shlifovana.jpg";
	String imgEpicSecUrl="https://cdn.27.ua/499/7f/f5/1540085_1.jpeg";
	String cornEpicUrl="https://epicentrk.ua/ua/shop/krupa-kukuruznaya-terra-shlifovannaya-bystrogo-prigotovleniya-400-g.html";
	String cornRozUrl="https://rozetka.com.ua/ua/art_foods_4820191590892/p47649056/characteristics/"; 
	String cornAquaUrl="https://aquamarket.ua/uk/kukurudzyana-krupa/38684-avgust-800-g-krupa-kukurudzyana.html";
	
	String cornEpicPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 22.70 грн/шт.\" data-text=\"грн/шт.\">\r\n"
			+ "22.70 </div>";
	String cornEpicNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-terra/\" class=\"link link--blue link--inverted\">Терра</a>";
	String cornEpicCategoryHTML="<span>крупа кукурудзяна</span>";
	String cornEpicProducerHTML="<span>Україна</span>";
	String cornEpicWeightHTML="<span class=\"p-char__value\"><span>400&nbsp;г</span>";
	String cornEpicResourceHTML=cornEpicUrl;
	
	String cornRozPriceHTML="<div class=\"product-carriage__price\"> 20";
	String cornRozNameHTML="<span>Україна</span>";
	String cornRozCategoryHTML="<a href=\"/ua/krupy/c4628397/vid-225787=kukuruznaya-krupa/\">Кукурудзяна крупа</a>";
	String cornRozProducerHTML="<a href=\"/ua/krupy/c4628397/strana-proizvoditelj-tovara-90098=544338/\">Україна</a>";
	String cornRozWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=501-g-750-g/\">500 г</a>";
	String cornRozResourceHTML=cornRozUrl;
	
	String cornAquaPriceHTML="<div class=\"product-price\">15<sup>";
	String cornAquaNameHTML="<td>Август</td>";
	String cornAquaCategoryHTML="<td>Кукурудзяна</td>";
	String cornAquaProducerHTML="<td>Україна</td>";
	String cornAquaWeightHTML="<td>800</td>";
	String cornAquaResourceHTML=cornAquaUrl;

	Document cornEpicPriceDoc=Jsoup.parse(cornEpicPriceHTML,cornEpicUrl);
	Document cornEpicNameDoc=Jsoup.parse(cornEpicNameHTML,cornEpicUrl);
	Document cornEpicCategoryDoc=Jsoup.parse(cornEpicCategoryHTML,cornEpicUrl);
	Document cornEpicProducerDoc=Jsoup.parse(cornEpicProducerHTML,cornEpicUrl);
	Document cornEpicWeightDoc=Jsoup.parse(cornEpicWeightHTML,cornEpicUrl);
	
	
	Document cornRozPriceDoc=Jsoup.parse(cornRozPriceHTML,cornRozUrl);
	Document cornRozNameDoc=Jsoup.parse(cornRozNameHTML,cornRozUrl);
	Document cornRozCategoryDoc=Jsoup.parse(cornRozCategoryHTML,cornRozUrl);
	Document cornRozProducerDoc=Jsoup.parse(cornRozProducerHTML,cornRozUrl);
	Document cornRozWeightDoc=Jsoup.parse(cornRozWeightHTML,cornRozUrl);
	
	
	Document cornAquaPriceDoc=Jsoup.parse(cornAquaPriceHTML,cornAquaUrl);
	Document cornAquaNameDoc=Jsoup.parse(cornAquaNameHTML,cornAquaUrl);
	Document cornAquaCategoryDoc=Jsoup.parse(cornAquaCategoryHTML,cornAquaUrl);
	Document cornAquaProducerDoc=Jsoup.parse(cornAquaProducerHTML,cornAquaUrl);
	Document cornAquaWeightDoc=Jsoup.parse(cornAquaWeightHTML,cornAquaUrl);
	
	
	String cornEpicPrice=cornEpicPriceDoc.body().text();
	String cornEpicName=cornEpicNameDoc.body().text();
	String cornEpicCategory=cornEpicCategoryDoc.body().text();
	String cornEpicProducer=cornEpicProducerDoc.body().text();
	String cornEpicWeight=cornEpicWeightDoc.body().text();
	
	Croap cornEpic=new Croap(cornEpicPrice, cornEpicName, cornEpicCategory, cornEpicProducer, cornEpicWeight, cornEpicResourceHTML,imgEpicUrl);
	corns.add(cornEpic);
	
	String cornRozPrice=cornRozPriceDoc.body().text();
	String cornRozName=cornRozNameDoc.body().text();
	String cornRozCategory=cornRozCategoryDoc.body().text();
	String cornRozProducer=cornRozProducerDoc.body().text();
	String cornRozWeight=cornRozWeightDoc.body().text();
	Croap cornRoz=new Croap(cornRozPrice, cornRozName, cornRozCategory, cornRozProducer, cornRozWeight, cornRozResourceHTML,imgRozUrl);
	corns.add(cornRoz);
	 
	String cornAquaPrice=cornAquaPriceDoc.body().text();
	String cornAquaName=cornAquaNameDoc.body().text();
	String cornAquaCategory=cornAquaCategoryDoc.body().text();
	String cornAquaProducer=cornAquaProducerDoc.body().text();
	String cornAquaWeight=cornAquaWeightDoc.body().text();
	Croap cornAqua=new Croap(cornAquaPrice, cornAquaName, cornAquaCategory, cornAquaProducer, cornAquaWeight, cornAquaResourceHTML,imgAquaUrl);
	corns.add(cornAqua);
	
	
	String cornEpicSecUrl="https://epicentrk.ua/ua/shop/krupa-kukuruznaya-sto-pudov-750-g.html";

	String cornEpicSecPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 13 грн/упак.\" data-text=\"грн/упак.\">\r\n"
			+ "13 </div>";
	String cornEpicSecNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-sto-pudov/\" class=\"link link--blue link--inverted\">Сто пудов</a>";
	String cornEpicSecCategoryHTML="<span>крупа кукурудзяна</span>";
	String cornEpicSecProducerHTML="<span>Україна</span>";
	String cornEpicSecWeightHTML="<span>750&nbsp;г</span>";

	Document cornEpicSecPriceDoc=Jsoup.parse(cornEpicSecPriceHTML,cornEpicSecUrl);
	Document cornEpicSecNameDoc=Jsoup.parse(cornEpicSecNameHTML,cornEpicSecUrl);
	Document cornEpicSecCategoryDoc=Jsoup.parse(cornEpicSecCategoryHTML,cornEpicSecUrl);
	Document cornEpicSecProducerDoc=Jsoup.parse(cornEpicSecProducerHTML,cornEpicSecUrl);
	Document cornEpicSecWeightDoc=Jsoup.parse(cornEpicSecWeightHTML,cornEpicSecUrl);

	String cornEpicSecPrice=cornEpicSecPriceDoc.body().text();
	String cornEpicSecName=cornEpicSecNameDoc.body().text();
	String cornEpicSecCategory=cornEpicSecCategoryDoc.body().text();
	String cornEpicSecProducer=cornEpicSecProducerDoc.body().text();
	String cornEpicSecWeight=cornEpicSecWeightDoc.body().text();
	String cornEpicSecResource=cornEpicSecUrl;
	Croap cornEpicSec=new Croap(cornEpicSecPrice, cornEpicSecName, cornEpicSecCategory, cornEpicSecProducer, cornEpicSecWeight, cornEpicSecResource,imgEpicSecUrl);
	corns.add(cornEpicSec);

	String cornAquaSecUrl="https://aquamarket.ua/uk/kukurudzyana-krupa/37061-skviryanka-800-g-krupa-kukurudzyana-shlifovana.html";

	String cornAquaSecPriceHTML="<div class=\"product-price\">\r\n"
			+ "                                                            23<sup>";
	String cornAquaSecNameHTML="<td>Сквирянка</td>";
	String cornAquaSecCategoryHTML="<td>Кукурудзяна</td>";
	String cornAquaSecProducerHTML="<td>Україна</td>";
	String cornAquaSecWeightHTML="<td>800</td>";

	Document cornAquaSecPriceDoc=Jsoup.parse(cornAquaSecPriceHTML,cornAquaSecUrl);
	Document cornAquaSecNameDoc=Jsoup.parse(cornAquaSecNameHTML,cornAquaSecUrl);
	Document cornAquaSecCategoryDoc=Jsoup.parse(cornAquaSecCategoryHTML,cornAquaSecUrl);
	Document cornAquaSecProducerDoc=Jsoup.parse(cornAquaSecProducerHTML,cornAquaSecUrl);
	Document cornAquaSecWeightDoc=Jsoup.parse(cornAquaSecWeightHTML,cornAquaSecUrl);

	String cornAquaSecPrice=cornAquaSecPriceDoc.body().text();
	String cornAquaSecName=cornAquaSecNameDoc.body().text();
	String cornAquaSecCategory=cornAquaSecCategoryDoc.body().text();
	String cornAquaSecProducer=cornAquaSecProducerDoc.body().text();
	String cornAquaSecWeight=cornAquaSecWeightDoc.body().text();
	String cornAquaSecResource=cornAquaSecUrl;
	Croap cornAquaSec=new Croap(cornAquaSecPrice, cornAquaSecName, cornAquaSecCategory, cornAquaSecProducer, cornAquaSecWeight, cornAquaSecResource,imgAquaSecUrl);
	corns.add(cornAquaSec);
	
	JSONObject cornJson=new JSONObject();
	JSONArray arrayFirst=new JSONArray();
	
	arrayFirst.put("price: "+cornRoz.getPrice());
	arrayFirst.put("name: "+cornRoz.getName());
	arrayFirst.put("category: "+cornRoz.getCategory());
	arrayFirst.put("producer: "+cornRoz.getProducer());
	arrayFirst.put("weight: "+cornRoz.getWeight());
	arrayFirst.put("resource: "+cornRozResourceHTML);
	cornJson.put("corn #1", arrayFirst);
	
	JSONArray arraySecond=new JSONArray();
	arraySecond.put("price: "+cornEpic.getPrice());
	arraySecond.put("name: "+cornEpic.getName());
	arraySecond.put("category: "+cornEpic.getCategory());
	arraySecond.put("producer: "+cornEpic.getProducer());
	arraySecond.put("weight: "+cornEpic.getWeight());
	arraySecond.put("resource: "+cornEpicResourceHTML);
	cornJson.put("corn #2", arraySecond);
	
	JSONArray arrayThird=new JSONArray();
	arrayThird.put("price: "+cornAqua.getPrice());
	arrayThird.put("name: "+cornAqua.getName());
	arrayThird.put("category: "+cornAqua.getCategory());
	arrayThird.put("producer: "+cornAqua.getProducer());
	arrayThird.put("weight: "+cornAqua.getWeight());
	arrayThird.put("resource: "+cornAquaResourceHTML);
	cornJson.put("corn #3", arrayThird);
	
	JSONArray arrayFourth=new JSONArray();
	arrayFourth.put("price: "+cornEpicSec.getPrice());
	arrayFourth.put("name: "+cornEpicSec.getName());
	arrayFourth.put("category: "+cornEpicSec.getCategory());
	arrayFourth.put("producer: "+cornEpicSec.getProducer());
	arrayFourth.put("weight: "+cornEpicSec.getWeight());
	arrayFourth.put("resource: "+cornEpicResourceHTML);
	cornJson.put("corn #4", arrayFourth);
	
	JSONArray arrayFifth=new JSONArray();
	arrayFifth.put("price: "+cornAquaSec.getPrice());
	arrayFifth.put("name: "+cornAquaSec.getName());
	arrayFifth.put("category: "+cornAquaSec.getCategory());
	arrayFifth.put("producer: "+cornAquaSec.getProducer());
	arrayFifth.put("weight: "+cornAquaSec.getWeight());
	arrayFifth.put("resource: "+cornAquaResourceHTML);
	arrayFirst.put("image URL: "+imgRozUrl);
	arraySecond.put("image URL: "+imgEpicUrl);
	arrayThird.put("image URL: "+imgAquaUrl);
	arrayFourth.put("image URL: "+imgEpicSecUrl);
	arrayFifth.put("image URL: "+imgAquaSecUrl);
	
	cornJson.put("corn #5", arrayFifth);
	System.out.println("JSON file with corn info:"+cornJson);
	FileWriter fileWriter=new FileWriter("json_corn_info.json");
	fileWriter.write(cornJson.toString());
	fileWriter.close();
	}
public static void rice() throws JSONException, IOException {
	List<Croap>rice=new ArrayList<Croap>();
	String imgRozUrl="https://i2.rozetka.ua/goods/6132257/copy_pere_4820191590496_5b59df1b374db_images_6132257896.jpg";
	String imgAquaUrl="https://aquamarket.ua/32374-small_default/ris-scotti-skotti-arborio-dlya-rizotto-500-g.jpg";
	String imgEpicUrl="https://cdn.27.ua/499/61/c4/2712004_2.jpeg";
	String imgAquaSecUrl="https://aquamarket.ua/22411-small_default/avgust-500-g-ris-basmati.jpg";
	String imgEpicSecUrl="https://cdn.27.ua/499/58/80/1726592_1.jpeg";
	String riceEpicUrl="https://epicentrk.ua/ua/shop/ris-khutorok-dlinnyy-shlifovannyy-800-g-4820211660161.html";
	String riceRozUrl="https://rozetka.com.ua/ua/pere_4820191590472/p47561880/characteristics/"; 
	String riceAquaUrl="https://aquamarket.ua/uk/ris/14890-ris-scotti-skotti-arborio-dlya-rizotto-500-g.html";
	
	String riceEpicPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 26.90 грн/упак.\" data-text=\"грн/упак.\">\r\n"
			+ "26.90 </div>";
	String riceEpicNameHTML="<span>Хуторок</span>";
	String riceEpicCategoryHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-ris/\" class=\"link link--blue link--inverted\">рис</a>";
	String riceEpicProducerHTML="<span>Україна</span>";
	String riceEpicWeightHTML="<span>800&nbsp;г</span>";
	String riceEpicResourceHTML=riceEpicUrl;
	
	String riceRozPriceHTML="<div class=\"product-carriage__price\"> 117";
	String riceRozNameHTML="<a href=\"/ua/krupy/c4628397/tip170414=basmati/\">Басматі</a>";
	String riceRozCategoryHTML="<a href=\"/ua/krupy/c4628397/vid-225787=ris/\">Рис</a>";
	String riceRozProducerHTML="<a href=\"/ua/krupy/c4628397/strana-registracii-brenda-87790=429058/\">Україна</a>";
	String riceRozWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=751-g-1000-g/\">800 г</a>";
	String riceRozResourceHTML=riceRozUrl;
	
	String riceAquaPriceHTML="<div class=\"product-price\">\r\n"
			+ "                                                            108<sup>";
	String riceAquaNameHTML="<td>Scotti </td>";
	String riceAquaCategoryHTML="<td>Рис</td>";
	String riceAquaProducerHTML="<td>Італія</td>";
	String riceAquaWeightHTML="<td>500</td>";
	String riceAquaResourceHTML=riceAquaUrl;

	Document riceEpicPriceDoc=Jsoup.parse(riceEpicPriceHTML,riceEpicUrl);
	Document riceEpicNameDoc=Jsoup.parse(riceEpicNameHTML,riceEpicUrl);
	Document riceEpicCategoryDoc=Jsoup.parse(riceEpicCategoryHTML,riceEpicUrl);
	Document riceEpicProducerDoc=Jsoup.parse(riceEpicProducerHTML,riceEpicUrl);
	Document riceEpicWeightDoc=Jsoup.parse(riceEpicWeightHTML,riceEpicUrl);
	
	
	Document riceRozPriceDoc=Jsoup.parse(riceRozPriceHTML,riceRozUrl);
	Document riceRozNameDoc=Jsoup.parse(riceRozNameHTML,riceRozUrl);
	Document riceRozCategoryDoc=Jsoup.parse(riceRozCategoryHTML,riceRozUrl);
	Document riceRozProducerDoc=Jsoup.parse(riceRozProducerHTML,riceRozUrl);
	Document riceRozWeightDoc=Jsoup.parse(riceRozWeightHTML,riceRozUrl);
	
	
	Document riceAquaPriceDoc=Jsoup.parse(riceAquaPriceHTML,riceAquaUrl);
	Document riceAquaNameDoc=Jsoup.parse(riceAquaNameHTML,riceAquaUrl);
	Document riceAquaCategoryDoc=Jsoup.parse(riceAquaCategoryHTML,riceAquaUrl);
	Document riceAquaProducerDoc=Jsoup.parse(riceAquaProducerHTML,riceAquaUrl);
	Document riceAquaWeightDoc=Jsoup.parse(riceAquaWeightHTML,riceAquaUrl);
	
	
	String riceEpicPrice=riceEpicPriceDoc.body().text();
	String riceEpicName=riceEpicNameDoc.body().text();
	String riceEpicCategory=riceEpicCategoryDoc.body().text();
	String riceEpicProducer=riceEpicProducerDoc.body().text();
	String riceEpicWeight=riceEpicWeightDoc.body().text();
	
	Croap riceEpic=new Croap(riceEpicPrice, riceEpicName, riceEpicCategory, riceEpicProducer, riceEpicWeight, riceEpicResourceHTML,imgEpicUrl);
	rice.add(riceEpic);
	
	String riceRozPrice=riceRozPriceDoc.body().text();
	String riceRozName=riceRozNameDoc.body().text();
	String riceRozCategory=riceRozCategoryDoc.body().text();
	String riceRozProducer=riceRozProducerDoc.body().text();
	String riceRozWeight=riceRozWeightDoc.body().text();
	Croap riceRoz=new Croap(riceRozPrice, riceRozName, riceRozCategory, riceRozProducer, riceRozWeight, riceRozResourceHTML,imgRozUrl);
	rice.add(riceRoz);
	 
	String riceAquaPrice=riceAquaPriceDoc.body().text();
	String riceAquaName=riceAquaNameDoc.body().text();
	String riceAquaCategory=riceAquaCategoryDoc.body().text();
	String riceAquaProducer=riceAquaProducerDoc.body().text();
	String riceAquaWeight=riceAquaWeightDoc.body().text();
	Croap riceAqua=new Croap(riceAquaPrice, riceAquaName, riceAquaCategory, riceAquaProducer, riceAquaWeight, riceAquaResourceHTML,imgAquaUrl);
	rice.add(riceAqua);
	
	
	String riceEpicSecUrl="https://epicentrk.ua/ua/shop/ris-sto-pudov-dlya-sushi-400-g.html";

	String riceEpicSecPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 24 грн/шт.\" data-text=\"грн/шт.\">\r\n"
			+ "24 </div>";
	String riceEpicSecNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-sto-pudov/\" class=\"link link--blue link--inverted\">Сто пудов</a>";
	String riceEpicSecCategoryHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-ris/\" class=\"link link--blue link--inverted\">рис</a>";
	String riceEpicSecProducerHTML="<span>Україна</span>";
	String riceEpicSecWeightHTML="<span>400&nbsp;г</span>";

	Document riceEpicSecPriceDoc=Jsoup.parse(riceEpicSecPriceHTML,riceEpicSecUrl);
	Document riceEpicSecNameDoc=Jsoup.parse(riceEpicSecNameHTML,riceEpicSecUrl);
	Document riceEpicSecCategoryDoc=Jsoup.parse(riceEpicSecCategoryHTML,riceEpicSecUrl);
	Document riceEpicSecProducerDoc=Jsoup.parse(riceEpicSecProducerHTML,riceEpicSecUrl);
	Document riceEpicSecWeightDoc=Jsoup.parse(riceEpicSecWeightHTML,riceEpicSecUrl);

	String riceEpicSecPrice=riceEpicSecPriceDoc.body().text();
	String riceEpicSecName=riceEpicSecNameDoc.body().text();
	String riceEpicSecCategory=riceEpicSecCategoryDoc.body().text();
	String riceEpicSecProducer=riceEpicSecProducerDoc.body().text();
	String riceEpicSecWeight=riceEpicSecWeightDoc.body().text();
	String riceEpicSecResource=riceEpicSecUrl;
	Croap riceEpicSec=new Croap(riceEpicSecPrice, riceEpicSecName, riceEpicSecCategory, riceEpicSecProducer, riceEpicSecWeight, riceEpicSecResource,imgEpicSecUrl);
	rice.add(riceEpicSec);

	String riceAquaSecUrl="https://aquamarket.ua/uk/ris/6737-avgust-500-g-ris-basmati.html";

	String riceAquaSecPriceHTML="<div class=\"product-price\">\r\n"
			+ "                                                            46<sup>";
	String riceAquaSecNameHTML="<td>Август</td>";
	String riceAquaSecCategoryHTML="<td>Рис</td>";
	String riceAquaSecProducerHTML=" <td>Україна</td>";
	String riceAquaSecWeightHTML="<td>500</td>";

	Document riceAquaSecPriceDoc=Jsoup.parse(riceAquaSecPriceHTML,riceAquaSecUrl);
	Document riceAquaSecNameDoc=Jsoup.parse(riceAquaSecNameHTML,riceAquaSecUrl);
	Document riceAquaSecCategoryDoc=Jsoup.parse(riceAquaSecCategoryHTML,riceAquaSecUrl);
	Document riceAquaSecProducerDoc=Jsoup.parse(riceAquaSecProducerHTML,riceAquaSecUrl);
	Document riceAquaSecWeightDoc=Jsoup.parse(riceAquaSecWeightHTML,riceAquaSecUrl);

	String riceAquaSecPrice=riceAquaSecPriceDoc.body().text();
	String riceAquaSecName=riceAquaSecNameDoc.body().text();
	String riceAquaSecCategory=riceAquaSecCategoryDoc.body().text();
	String riceAquaSecProducer=riceAquaSecProducerDoc.body().text();
	String riceAquaSecWeight=riceAquaSecWeightDoc.body().text();
	String riceAquaSecResource=riceAquaSecUrl;
	Croap riceAquaSec=new Croap(riceAquaSecPrice, riceAquaSecName, riceAquaSecCategory, riceAquaSecProducer, riceAquaSecWeight, riceAquaSecResource,imgAquaSecUrl);
	rice.add(riceAquaSec);
	

	JSONObject riceJson=new JSONObject();
	JSONArray arrayFirst=new JSONArray();
	
	arrayFirst.put("price: "+riceRoz.getPrice());
	arrayFirst.put("name: "+riceRoz.getName());
	arrayFirst.put("category: "+riceRoz.getCategory());
	arrayFirst.put("producer: "+riceRoz.getProducer());
	arrayFirst.put("weight: "+riceRoz.getWeight());
	arrayFirst.put("resource: "+riceRozResourceHTML);
	riceJson.put("rice #1", arrayFirst);
	
	JSONArray arraySecond=new JSONArray();
	arraySecond.put("price: "+riceEpic.getPrice());
	arraySecond.put("name: "+riceEpic.getName());
	arraySecond.put("category: "+riceEpic.getCategory());
	arraySecond.put("producer: "+riceEpic.getProducer());
	arraySecond.put("weight: "+riceEpic.getWeight());
	arraySecond.put("resource: "+riceEpicResourceHTML);
	riceJson.put("rice #2", arraySecond);
	
	JSONArray arrayThird=new JSONArray();
	arrayThird.put("price: "+riceAqua.getPrice());
	arrayThird.put("name: "+riceAqua.getName());
	arrayThird.put("category: "+riceAqua.getCategory());
	arrayThird.put("producer: "+riceAqua.getProducer());
	arrayThird.put("weight: "+riceAqua.getWeight());
	arrayThird.put("resource: "+riceAquaResourceHTML);
	riceJson.put("rice #3", arrayThird);
	
	JSONArray arrayFourth=new JSONArray();
	arrayFourth.put("price: "+riceAquaSec.getPrice());
	arrayFourth.put("name: "+riceAquaSec.getName());
	arrayFourth.put("category: "+riceAquaSec.getCategory());
	arrayFourth.put("producer: "+riceAquaSec.getProducer());
	arrayFourth.put("weight: "+riceAquaSec.getWeight());
	arrayFourth.put("resource: "+riceAquaSecResource);
	riceJson.put("rice #4", arrayFourth);
	
	JSONArray arrayFifth=new JSONArray();
	arrayFifth.put("price: "+riceEpicSec.getPrice());
	arrayFifth.put("name: "+riceEpicSec.getName());
	arrayFifth.put("category: "+riceEpicSec.getCategory());
	arrayFifth.put("producer: "+riceEpicSec.getProducer());
	arrayFifth.put("weight: "+riceEpicSec.getWeight());
	arrayFifth.put("resource: "+riceEpicSecResource);
	
	arrayFirst.put("image URL: "+imgAquaSecUrl);
	arraySecond.put("image URL: "+imgAquaSecUrl);
	arrayThird.put("image URL: "+imgAquaSecUrl);
	arrayFourth.put("image URL: "+imgAquaSecUrl);
	arrayFifth.put("image URL: "+imgAquaSecUrl);
	
	riceJson.put("rice #5", arrayFifth);
	
	System.out.println("JSON file with rice info:"+riceJson);
	FileWriter fileWriter=new FileWriter("json_rice_info.json");
	fileWriter.write(riceJson.toString());
	fileWriter.close();
}
public static void barley() throws JSONException, IOException {
	List<Croap>barleys=new ArrayList<Croap>();
	String imgRozUrl="https://i2.rozetka.ua/goods/18253364/82804665_images_18253364569.jpg";
	String imgAquaUrl="https://aquamarket.ua/62182-small_default/avgust-800-g-krupa-yachna.jpg";
	String imgEpicUrl="https://cdn.27.ua/499/32/71/1520241_2.jpeg";
	String imgAquaSecUrl="https://aquamarket.ua/71202-small_default/kozub-500-g-krupa-yachna-organichna.jpg";
	String imgEpicSecUrl="https://cdn.27.ua/499/44/e5/1721573_1.jpeg";
	String barleyEpicUrl="https://epicentrk.ua/ua/shop/krupa-yachnevaya-foodsi-1000-g.html";
	String barleyRozUrl="https://rozetka.com.ua/ua/82804665/p82804665/characteristics/"; 
	String barleyAquaUrl="https://aquamarket.ua/uk/yachna-krupa/38682-avgust-800-g-krupa-yachna.html";
	
	String barleyEpicPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 12 грн/упак.\" data-text=\"грн/упак.\">\r\n"
			+ "12 </div>";
	String barleyEpicNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-foodsi/\" class=\"link link--blue link--inverted\">Foodsi</a>";
	String barleyEpicCategoryHTML="<span>крупа ячмінна</span>";
	String barleyEpicProducerHTML="<span>Україна</span>";
	String barleyEpicWeightHTML="<span>1000&nbsp;г</span>";
	String barleyEpicResourceHTML=barleyEpicUrl;
	
	String barleyRozPriceHTML="<div class=\"product-carriage__price\"> 31";
	String barleyRozNameHTML="<span>Україна</span>";
	String barleyRozCategoryHTML="<a href=\"/ua/krupy/c4628397/vid-225787=yachnevaya-krupa/\">Ячна крупа</a>";
	String barleyRozProducerHTML="<span>Україна</span>";
	String barleyRozWeightHTML="<a href=\"/ua/krupy/c4628397/ves147016=301-g-500-g/\">400 г</a>";
	String barleyRozResourceHTML=barleyRozUrl;
	
	String barleyAquaPriceHTML="<div class=\"product-price\">\r\n"
			+ "                                                            18<sup>";
	String barleyAquaNameHTML="<td>Август</td>";
	String barleyAquaCategoryHTML="<td>Ячна</td>";
	String barleyAquaProducerHTML="<td>Україна</td>";
	String barleyAquaWeightHTML="<td>800</td>";
	String barleyAquaResourceHTML=barleyAquaUrl;

	Document barleyEpicPriceDoc=Jsoup.parse(barleyEpicPriceHTML,barleyEpicUrl);
	Document barleyEpicNameDoc=Jsoup.parse(barleyEpicNameHTML,barleyEpicUrl);
	Document barleyEpicCategoryDoc=Jsoup.parse(barleyEpicCategoryHTML,barleyEpicUrl);
	Document barleyEpicProducerDoc=Jsoup.parse(barleyEpicProducerHTML,barleyEpicUrl);
	Document barleyEpicWeightDoc=Jsoup.parse(barleyEpicWeightHTML,barleyEpicUrl);
	
	
	Document barleyRozPriceDoc=Jsoup.parse(barleyRozPriceHTML,barleyRozUrl);
	Document barleyRozNameDoc=Jsoup.parse(barleyRozNameHTML,barleyRozUrl);
	Document barleyRozCategoryDoc=Jsoup.parse(barleyRozCategoryHTML,barleyRozUrl);
	Document barleyRozProducerDoc=Jsoup.parse(barleyRozProducerHTML,barleyRozUrl);
	Document barleyRozWeightDoc=Jsoup.parse(barleyRozWeightHTML,barleyRozUrl);
	
	
	Document barleyAquaPriceDoc=Jsoup.parse(barleyAquaPriceHTML,barleyAquaUrl);
	Document barleyAquaNameDoc=Jsoup.parse(barleyAquaNameHTML,barleyAquaUrl);
	Document barleyAquaCategoryDoc=Jsoup.parse(barleyAquaCategoryHTML,barleyAquaUrl);
	Document barleyAquaProducerDoc=Jsoup.parse(barleyAquaProducerHTML,barleyAquaUrl);
	Document barleyAquaWeightDoc=Jsoup.parse(barleyAquaWeightHTML,barleyAquaUrl);
	
	
	String barleyEpicPrice=barleyEpicPriceDoc.body().text();
	String barleyEpicName=barleyEpicNameDoc.body().text();
	String barleyEpicCategory=barleyEpicCategoryDoc.body().text();
	String barleyEpicProducer=barleyEpicProducerDoc.body().text();
	String barleyEpicWeight=barleyEpicWeightDoc.body().text();
	
	Croap berleyEpic=new Croap(barleyEpicPrice, barleyEpicName, barleyEpicCategory, barleyEpicProducer, barleyEpicWeight, barleyEpicResourceHTML,imgEpicUrl);
	barleys.add(berleyEpic);
	
	String barleyRozPrice=barleyRozPriceDoc.body().text();
	String barleyRozName=barleyRozNameDoc.body().text();
	String barleyRozCategory=barleyRozCategoryDoc.body().text();
	String barleyRozProducer=barleyRozProducerDoc.body().text();
	String barleyRozWeight=barleyRozWeightDoc.body().text();
	Croap barleyRoz=new Croap(barleyRozPrice, barleyRozName, barleyRozCategory, barleyRozProducer, barleyRozWeight, barleyRozResourceHTML,imgRozUrl);
	barleys.add(barleyRoz);
	 
	String barleyAquaPrice=barleyAquaPriceDoc.body().text();
	String barleyAquaName=barleyAquaNameDoc.body().text();
	String barleyAquaCategory=barleyAquaCategoryDoc.body().text();
	String barleyAquaProducer=barleyAquaProducerDoc.body().text();
	String barleyAquaWeight=barleyAquaWeightDoc.body().text();
	Croap barleyAqua=new Croap(barleyAquaPrice, barleyAquaName, barleyAquaCategory, barleyAquaProducer, barleyAquaWeight, barleyAquaResourceHTML,imgAquaUrl);
	barleys.add(barleyAqua);
	
	
	String barleyEpicSecUrl="https://epicentrk.ua/ua/shop/krupa-yachnevaya-terra-bystrogo-prigotovleniya-400-g.html";

	String barleyEpicSecPriceHTML="<div class=\"p-price__main\" title=\"Ціна: 18.70 грн/шт.\" data-text=\"грн/шт.\">\r\n"
			+ "18.70 </div>";
	String barleyEpicSecNameHTML="<a href=\"/ua/shop/krupy-i-makaronnye-izdeliya/fs/brend-terra/\" class=\"link link--blue link--inverted\">Терра</a>";
	String barleyEpicSecCategoryHTML="<span>крупа ячмінна</span>";
	String barleyEpicSecProducerHTML="<span>Україна</span>";
	String barleyEpicSecWeightHTML="<span>400&nbsp;г</span>";

	Document barleyEpicSecPriceDoc=Jsoup.parse(barleyEpicSecPriceHTML,barleyEpicSecUrl);
	Document barleyEpicSecNameDoc=Jsoup.parse(barleyEpicSecNameHTML,barleyEpicSecUrl);
	Document barleyEpicSecCategoryDoc=Jsoup.parse(barleyEpicSecCategoryHTML,barleyEpicSecUrl);
	Document barleyEpicSecProducerDoc=Jsoup.parse(barleyEpicSecProducerHTML,barleyEpicSecUrl);
	Document barleyEpicSecWeightDoc=Jsoup.parse(barleyEpicSecWeightHTML,barleyEpicSecUrl);

	String barleyEpicSecPrice=barleyEpicSecPriceDoc.body().text();
	String barleyEpicSecName=barleyEpicSecNameDoc.body().text();
	String barleyEpicSecCategory=barleyEpicSecCategoryDoc.body().text();
	String barleyEpicSecProducer=barleyEpicSecProducerDoc.body().text();
	String barleyEpicSecWeight=barleyEpicSecWeightDoc.body().text();
	String barleyEpicSecResource=barleyEpicSecUrl;
	Croap barleyEpicSec=new Croap(barleyEpicSecPrice, barleyEpicSecName, barleyEpicSecCategory, barleyEpicSecProducer, barleyEpicSecWeight, barleyEpicSecResource,imgEpicSecUrl);
	barleys.add(barleyEpicSec);

	String barleyAquaSecUrl="https://aquamarket.ua/uk/yachna-krupa/44800-kozub-500-g-krupa-yachna-organichna.html";

	String barleyAquaSecPriceHTML="<div class=\"product-price\">\r\n"
			+ "                                                            36<sup>";
	String barleyAquaSecNameHTML="<td>Козуб</td>";
	String barleyAquaSecCategoryHTML="<td>Ячна</td>";
	String barleyAquaSecProducerHTML=" <td>Україна</td>";
	String barleyAquaSecWeightHTML="<td>500</td>";

	Document barleyAquaSecPriceDoc=Jsoup.parse(barleyAquaSecPriceHTML,barleyAquaSecUrl);
	Document barleyAquaSecNameDoc=Jsoup.parse(barleyAquaSecNameHTML,barleyAquaSecUrl);
	Document barleyAquaSecCategoryDoc=Jsoup.parse(barleyAquaSecCategoryHTML,barleyAquaSecUrl);
	Document barleyAquaSecProducerDoc=Jsoup.parse(barleyAquaSecProducerHTML,barleyAquaSecUrl);
	Document barleyAquaSecWeightDoc=Jsoup.parse(barleyAquaSecWeightHTML,barleyAquaSecUrl);

	String barleyAquaSecPrice=barleyAquaSecPriceDoc.body().text();
	String barleyAquaSecName=barleyAquaSecNameDoc.body().text();
	String barleyAquaSecCategory=barleyAquaSecCategoryDoc.body().text();
	String barleyAquaSecProducer=barleyAquaSecProducerDoc.body().text();
	String barleyAquaSecWeight=barleyAquaSecWeightDoc.body().text();
	String barleyAquaSecResource=barleyAquaSecUrl;
	Croap barleyAquaSec=new Croap(barleyAquaSecPrice, barleyAquaSecName, barleyAquaSecCategory, barleyAquaSecProducer, barleyAquaSecWeight, barleyAquaSecResource,imgAquaSecUrl);
	barleys.add(barleyAquaSec);
	
	
	
	
	JSONObject barleyJson=new JSONObject();
	JSONArray arrayFirst=new JSONArray();
	
	arrayFirst.put("price: "+barleyRoz.getPrice());
	arrayFirst.put("name: "+barleyRoz.getName());
	arrayFirst.put("category: "+barleyRoz.getCategory());
	arrayFirst.put("producer: "+barleyRoz.getProducer());
	arrayFirst.put("weight: "+barleyRoz.getWeight());
	arrayFirst.put("resource: "+barleyRozResourceHTML);
	barleyJson.put("barley #1", arrayFirst);
	
	JSONArray arraySecond=new JSONArray();
	arraySecond.put("price: "+berleyEpic.getPrice());
	arraySecond.put("name: "+berleyEpic.getName());
	arraySecond.put("category: "+berleyEpic.getCategory());
	arraySecond.put("producer: "+berleyEpic.getProducer());
	arraySecond.put("weight: "+berleyEpic.getWeight());
	arraySecond.put("resource: "+barleyEpicResourceHTML);
	barleyJson.put("barley #2", arraySecond);
	
	JSONArray arrayThird=new JSONArray();
	arrayThird.put("price: "+barleyAqua.getPrice());
	arrayThird.put("name: "+barleyAqua.getName());
	arrayThird.put("category: "+barleyAqua.getCategory());
	arrayThird.put("producer: "+barleyAqua.getProducer());
	arrayThird.put("weight: "+barleyAqua.getWeight());
	arrayThird.put("resource: "+barleyAquaResourceHTML);
	barleyJson.put("barley #3", arrayThird);
	
	JSONArray arrayFourth=new JSONArray();
	arrayFourth.put("price: "+barleyAquaSec.getPrice());
	arrayFourth.put("name: "+barleyAquaSec.getName());
	arrayFourth.put("category: "+barleyAquaSec.getCategory());
	arrayFourth.put("producer: "+barleyAquaSec.getProducer());
	arrayFourth.put("weight: "+barleyAquaSec.getWeight());
	arrayFourth.put("resource: "+barleyAquaSecResource);
	barleyJson.put("barley #4", arrayFourth);
	
	JSONArray arrayFifth=new JSONArray();
	arrayFifth.put("price: "+barleyEpicSec.getPrice());
	arrayFifth.put("name: "+barleyEpicSec.getName());
	arrayFifth.put("category: "+barleyEpicSec.getCategory());
	arrayFifth.put("producer: "+barleyEpicSec.getProducer());
	arrayFifth.put("weight: "+barleyEpicSec.getWeight());
	arrayFifth.put("resource: "+barleyEpicSecResource);
	arrayFirst.put("image URL: "+imgAquaSecUrl);
	arraySecond.put("image URL: "+imgAquaSecUrl);
	arrayThird.put("image URL: "+imgAquaSecUrl);
	arrayFourth.put("image URL: "+imgAquaSecUrl);
	arrayFifth.put("image URL: "+imgAquaSecUrl);
	
	barleyJson.put("barley #5", arrayFifth);
	
	System.out.println("JSON file with barley info:"+barleyJson);
	FileWriter fileWriter=new FileWriter("json_barley_info.json");
	fileWriter.write(barleyJson.toString());
	fileWriter.close();
}

}
