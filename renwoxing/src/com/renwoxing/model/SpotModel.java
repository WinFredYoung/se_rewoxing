package com.renwoxing.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.renwoxing.util.SQLUntil;

public class SpotModel {
	private int id;
	private String spotName;
	private String spotDescribe;
	private String spotTime;
	private float spotPrice;
	private String spotSuggestTime;
	private String spotScore;
	private List<RestaurantModel> restaurantModels;
	private List<HotelModel> hotelModels;
	private List<ShopModel> shopModels;
	private Connection connection;
	public SpotModel() throws SQLException {
//		String sql = "select * from spot where spotDescribe like" +"'%" + describe + "%'";
//		Connection connection = SQLConnection.getConnection();
//		this.connection = connection;
//		ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
//		while (resultSet.next()) {
//			this.id = resultSet.getInt("id");
//			this.spotName = resultSet.getString("spotName");
//			this.spotDescribe = resultSet.getString("spotDescribe");
//			this.spotScore = resultSet.getString("spotScore");
//			this.spotSuggestTime = resultSet.getString("spotSuggestTime");
//		}
//		resultSet.close();
//		List<RestaurantModel> temprestaurantModels = new ArrayList<>();
//		List<HotelModel> temphotelModels = new ArrayList<>();
//		List<ShopModel> tempshopModels = new ArrayList<>();
//		setRaurantModels(temprestaurantModels);
//		setHotelModels(temphotelModels);
//		setShopModels(tempshopModels);
	}
	
	public List<RestaurantModel> getRestaurantModels() {
		return restaurantModels;
	}


	private void setRaurantModels(List<RestaurantModel> raurantModels) throws SQLException {
		String sql = "select * from restaurant where spot_id =" + this.id;
		ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
		while(resultSet.next()) {
			RestaurantModel model = new RestaurantModel();
			model.setId(resultSet.getInt("id"));
			model.setSpot_id(resultSet.getInt("spot_id"));
			model.setRestaurantName(resultSet.getString("restaurantName"));
			model.setRestaurantAddress(resultSet.getString("restaurantAddress"));
			model.setRestaurantLevel(resultSet.getString("restaurantLevel"));
			model.setRestaurantType(resultSet.getString("restaurantType"));
			model.setRestaurantDescribe(resultSet.getString("restaurantDescribe"));
			model.setRestaurantScore(resultSet.getString("RestaurantScore"));
			model.setAgr_price(resultSet.getFloat("agr_price"));
			model.setSpot_distance(resultSet.getFloat("spot_distance"));
			model.setHotel_id(resultSet.getInt("hotel_id"));
			model.setHotel_distance(resultSet.getFloat("hotel_distance"));
			model.setShop_id(resultSet.getInt("shop_id"));
			model.setShop_distance(resultSet.getFloat("shop_distance"));
			model.setEntertainent_id(resultSet.getInt("entertainment_id"));
			model.setEntertainment_distance(resultSet.getFloat("entertainment_distance"));
			raurantModels.add(model);
			model.setModels();
		}
		resultSet.close();
		this.restaurantModels = raurantModels;
	}
	

	public List<HotelModel> getHotelModels() {
		return hotelModels;
	}


	private void setHotelModels(List<HotelModel> hotelModels) throws SQLException {
		String sql = "select * from hotel where spot_id =" + this.id;
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
		}
		this.hotelModels = hotelModels;
		resultSet.close();
	}


	public List<ShopModel> getShopModels() {
		return shopModels;
	}


	private void setShopModels(List<ShopModel> shopModels) throws SQLException {
		String sql = "select * from shop where spot_id = " + this.id;
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
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public String getSpotDescribe() {
		return spotDescribe;
	}
	public void setSpotDescribe(String spotDescribe) {
		this.spotDescribe = spotDescribe;
	}
	public String getSpotTime() {
		return spotTime;
	}
	public void setSpotTime(String spotTime) {
		this.spotTime = spotTime;
	}
	public void setSpotPrice(float price) {
		this.spotPrice = price;
	}
	public float getSpotPrice() {
		return spotPrice;
	}
	public String getSpotSuggestTime() {
		return spotSuggestTime;
	}
	public void setSpotSuggestTime(String spotSuggestTime) {
		this.spotSuggestTime = spotSuggestTime;
	}
	public String getSpotScore() {
		return spotScore;
	}
	public void setSpotScore(String spotScore) {
		this.spotScore = spotScore;
	}
}
