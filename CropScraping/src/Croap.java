public class Croap {
private String price;
private String name;
private String category;
private String producer;
private String weight;
private String resource;
private String imageUrl;
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

@Override
public String toString() {
	return "Croap [price=" + price + ", name=" + name + ", category=" + category + ", producer=" + producer
			+ ", weight=" + weight + ", resource=" + resource + ", imageUrl=" + imageUrl + "]";
}
public Croap(String price, String name, String category, String producer, String weight, String resource,
		String imageUrl) {
	super();
	this.price = price;
	this.name = name;
	this.category = category;
	this.producer = producer;
	this.weight = weight;
	this.resource = resource;
	this.imageUrl = imageUrl;
}

public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getProducer() {
	return producer;
}
public void setProducer(String producer) {
	this.producer = producer;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getResource() {
	return resource;
}
public void setResource(String resource) {
	this.resource = resource;
}

}
