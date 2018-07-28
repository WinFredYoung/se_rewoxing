package com.renwoxing.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.renwoxing.util.SQLConnection;
import com.renwoxing.util.SQLUntil;

public class RestaurantModel {
	private float agr_price;//平均价格
	private int entertainent_id;//娱乐区id
	private float entertainment_distance;//距离
	private int id;
	private int spot_id;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantLevel;
	private String restaurantType;
	private String restaurantDescribe;
	private String restaurantTime;
	private String restaurantScore;
	
	private float spot_distance;
	private int hotel_id;
	private float hotel_distance;
	private int shop_id;
	private float shop_distance;
	
	
	Connection connection;
	
	private List<HotelModel> hotelModels;
	private List<ShopModel> shopModels;
	
	public RestaurantModel() throws SQLException {
		connection = SQLConnection.getConnection();
		
		
	}
	
	public void setModels() throws SQLException {
//		List<HotelModel> temphotelModels = new ArrayList<>();
//		List<ShopModel> tempshopModels = new ArrayList<>();
//		setHotelModels(temphotelModels);
//		setShopModels(tempshopModels);
	}
	
	public List<HotelModel> getHotelModels() {
		return hotelModels;
	}
	public void setHotelModels(List<HotelModel> hotelModels) throws SQLException {
		String sql = "select * from hotel where spot_id =" + this.spot_id;
		ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
		while (resultSet.next()) {
			 HotelModel model = new HotelModel();
			 model.setId(resultSet.getInt("id"));
			 model.setHotelName(resultSet.getString("hotelName"));
			 model.setSpot_id(resultSet.getInt("spot_id"));
			 model.setHotelAddress(resultSet.getString("hotelAddress"));
			 model.setAve_price(resultSet.getFloat("ave_price"));
			 model.setSpot_distance(resultSet.getFloat("spot_distance"));
			 model.setShop_id(resultSet.getInt("shop_id"));
			 model.setShop_distance(resultSet.getFloat("shop_distance"));
			 model.setHotelLevel(resultSet.getInt("hotelLevel"));
			 model.setHotelDescribe(resultSet.getString("hotelDescribe"));
			 model.setHotelScore(resultSet.getString("hotelScore"));
			 model.setEntertainment_id(resultSet.getInt("entertainment_id"));
			 model.setEntertainment_distance(resultSet.getFloat("entertainment_distance"));
			 hotelModels.add(model);
			 model.setModels();
		}
		resultSet.close();
		this.hotelModels = hotelModels;
	}
	public List<ShopModel> getShopModels() {
		return shopModels;
	}
	public void setShopModels(List<ShopModel> shopModels) throws SQLException {
		String sql = "select * from shop where spot_id = " + this.spot_id;
		ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
		while(resultSet.next()) {
			ShopModel model = new ShopModel();
			model.setId(resultSet.getInt("id"));
			model.setShopName(resultSet.getString("shopName"));
			model.setShopType(resultSet.getString("shopType"));
			model.setShopTime(resultSet.getString("shopTime"));
			model.setSpot_id(resultSet.getInt("spot_id"));
			model.setShopDescribe(resultSet.getString("shopDescribe"));
			model.setShopScore(resultSet.getString("shopScore"));
			model.setEntertainment_id(resultSet.getInt("entertainment_id"));
			model.setEntertainment_distance(resultSet.getFloat("entertainment_distance"));
			model.setSpot_distance(resultSet.getFloat("spot_distance"));
			shopModels.add(model);
		}
		this.shopModels = shopModels;
		resultSet.close();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpot_id() {
		return spot_id;
	}
	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public String getRestaurantLevel() {
		return restaurantLevel;
	}
	public void setRestaurantLevel(String restaurantLevel) {
		this.restaurantLevel = restaurantLevel;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	public String getRestaurantDescribe() {
		return restaurantDescribe;
	}
	public void setRestaurantDescribe(String restaurantDescribe) {
		this.restaurantDescribe = restaurantDescribe;
	}
	public String getRestaurantTime() {
		return restaurantTime;
	}
	public void setRestaurantTime(String restaurantTime) {
		this.restaurantTime = restaurantTime;
	}
	public String getRestaurantScore() {
		return restaurantScore;
	}
	public void setRestaurantScore(String restaurantScore) {
		this.restaurantScore = restaurantScore;
	}
	public float getAgr_price() {
		return agr_price;
	}
	public void setAgr_price(float agr_price) {
		this.agr_price = agr_price;
	}
	public float getSpot_distance() {
		return spot_distance;
	}
	public void setSpot_distance(float spot_distance) {
		this.spot_distance = spot_distance;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public float getHotel_distance() {
		return hotel_distance;
	}
	public void setHotel_distance(float hotel_distance) {
		this.hotel_distance = hotel_distance;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public float getShop_distance() {
		return shop_distance;
	}
	public void setShop_distance(float shop_distance) {
		this.shop_distance = shop_distance;
	}
	public int getEntertainent_id() {
		return entertainent_id;
	}
	public void setEntertainent_id(int entertainent_id) {
		this.entertainent_id = entertainent_id;
	}
	public float getEntertainment_distance() {
		return entertainment_distance;
	}
	public void setEntertainment_distance(float entertainment_distance) {
		this.entertainment_distance = entertainment_distance;
	}
}
