package com.ssafy.food.dto;

public class FoodVO implements Comparable<FoodVO>{
	private int code;
    private String name;
    private String maker;
    private String material;
    private String  image;
    private String supportpereat;
    /**일회 제공되는 칼로기*/
    private String calory;
    /**일회 제공되는 탄수화물*/
    private String carbo;
    /**일회 제공되는 단백질*/
    private String protein;
    /**일회 제공되는 지방*/
    private String fat;
    /**일회 제공되는 당류*/
    private String sugar;
    /**일회 제공되는 나트륨*/
    private String natrium;
    /**일회 제공되는 콜레스테롤*/
    private String chole;
    /**일회 제공되는 포화지방산*/
    private String fattyacid;
    /**일회 제공되는 트렌스지방*/
    private String transfat;
   
    private String allergy;
    private int year;
    

	public FoodVO() {	}
	
	public FoodVO(int code, String name, String maker, String material, String image) {
		this.code = code;
		this.name = name;
		this.maker = maker;
		this.material = material;
		this.image = image;
	}

	public FoodVO(int code, String name, String maker, String material, String image, String supportpereat,
			String calory, String carbo, String protein, String fat, String sugar, String natrium, String chole,
			String fattyacid, String transfat, String allergy, int year) {
		super();
		this.code = code;
		this.name = name;
		this.maker = maker;
		this.material = material;
		this.image = image;
		this.supportpereat = supportpereat;
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
		this.allergy = allergy;
		this.year = year;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSupportpereat() {
		return supportpereat;
	}
	public void setSupportpereat(String supportpereat) {
		this.supportpereat = supportpereat;
	}
	public String getCalory() {
		return calory;
	}
	public void setCalory(String calory) {
		this.calory = calory;
	}
	public String getCarbo() {
		return carbo;
	}
	public void setCarbo(String carbo) {
		this.carbo = carbo;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	public String getNatrium() {
		return natrium;
	}
	public void setNatrium(String natrium) {
		this.natrium = natrium;
	}
	public String getChole() {
		return chole;
	}
	public void setChole(String chole) {
		this.chole = chole;
	}
	public String getFattyacid() {
		return fattyacid;
	}
	public void setFattyacid(String fattyacid) {
		this.fattyacid = fattyacid;
	}
	public String getTransfat() {
		return transfat;
	}
	public void setTransfat(String transfat) {
		this.transfat = transfat;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "FoodVO [code=" + code + ", name=" + name + ", maker=" + maker + ", material=" + material + ", image="
				+ image + ", supportpereat=" + supportpereat + ", calory=" + calory + ", carbo=" + carbo + ", protein="
				+ protein + ", fat=" + fat + ", sugar=" + sugar + ", natrium=" + natrium + ", chole=" + chole
				+ ", fattyacid=" + fattyacid + ", transfat=" + transfat + ", allergy=" + allergy + ", year=" + year
				+ "]";
	}
	@Override
	public int compareTo(FoodVO o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
}
