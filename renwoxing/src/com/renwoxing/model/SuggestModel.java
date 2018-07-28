package com.renwoxing.model;

public class SuggestModel {
	private RestaurantModel restaurantModel;
	private HotelModel hotelModel;
	private ShopModel shopModel;
	private SpotModel spotModel;
	private float suggestPrice;
	public SuggestModel(SpotModel spotModel,RestaurantModel restaurantModel,HotelModel hotelModel,ShopModel shopModel) {
		// TODO Auto-generated constructor stub
		this.restaurantModel = restaurantModel;
		this.spotModel = spotModel;
		this.hotelModel = hotelModel;
		this.shopModel = shopModel;
	}
	public SuggestModel() {
		
	}
	
	public RestaurantModel getRestaurantModel() {
		return restaurantModel;
	}
	public void setRestaurantModel(RestaurantModel restaurantModel) {
		this.restaurantModel = restaurantModel;
	}
	public HotelModel getHotelModel() {
		return hotelModel;
	}
	public void setHotelModel(HotelModel hotelModel) {
		this.hotelModel = hotelModel;
	}
	public ShopModel getShopModel() {
		return shopModel;
	}
	public void setShopModel(ShopModel shopModel) {
		this.shopModel = shopModel;
	}
	public SpotModel getSpotModel() {
		return spotModel;
	}
	public void setSpotModel(SpotModel spotModel) {
		this.spotModel = spotModel;
	}
	
	public void CalculatePrice(){
		float totalprice = 0;
		if(this.spotModel != null){
		totalprice += this.spotModel.getSpotPrice();
		}
		if(this.restaurantModel != null)
		{
			totalprice += this.restaurantModel.getAgr_price();
		}
		if(this.hotelModel != null)
		{
			totalprice += this .hotelModel.getAve_price();
		}
		
		this.suggestPrice = totalprice;
	}
	public float getPrice() {
		// TODO Auto-generated method stub
		return this.suggestPrice;
	}
	
}
