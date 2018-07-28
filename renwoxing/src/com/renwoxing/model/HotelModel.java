package com.renwoxing.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.renwoxing.util.SQLConnection;
import com.renwoxing.util.SQLUntil;

public class HotelModel {
	private int id;
	private String hotelName;
	private int spot_id;
	private String hotelAddress;
	private float ave_price;
	private float spot_distance;
	private int hotelLevel;
	private String hotelDescribe;
	private String hotelScore;
	private int entertainment_id;
	private float entertainment_distance;
	private int shop_id;
	private float shop_distance;	
	private List<ShopModel> shopModels;
	private Connection connection;
	public HotelModel() throws SQLException {
		this.connection = SQLConnection.getConnection();
		
	}
	
	public void setModels() throws SQLException {
		List<ShopModel> tempshopModels = new ArrayList<>();
//		setShopModels(tempshopModels);
	}
	
	public List<ShopModel> getShopModels() {
		return shopModels;
	}

	private void setShopModels(List<ShopModel> shopModels) throws SQLException
	{
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
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getSpot_id() {
		return spot_id;
	}
	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public float getAve_price() {
		return ave_price;
	}
	public void setAve_price(float ave_price) {
		this.ave_price = ave_price;
	}
	public float getSpot_distance() {
		return spot_distance;
	}
	public void setSpot_distance(float spot_distance) {
		this.spot_distance = spot_distance;
	}
	public int getHotelLevel() {
		return hotelLevel;
	}
	public void setHotelLevel(int hotelLevel) {
		this.hotelLevel = hotelLevel;
	}
	public String getHotelDescribe() {
		return hotelDescribe;
	}
	public void setHotelDescribe(String hotelDescribe) {
		this.hotelDescribe = hotelDescribe;
	}
	public String getHotelScore() {
		return hotelScore;
	}
	public void setHotelScore(String hotelScore) {
		this.hotelScore = hotelScore;
	}
	public int getEntertainment_id() {
		return entertainment_id;
	}
	public void setEntertainment_id(int entertainment_id) {
		this.entertainment_id = entertainment_id;
	}
	public float getEntertainment_distance() {
		return entertainment_distance;
	}
	public void setEntertainment_distance(float entertainment_distance) {
		this.entertainment_distance = entertainment_distance;
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
}
