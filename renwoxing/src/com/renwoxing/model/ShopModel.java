package com.renwoxing.model;

public class ShopModel {
	private int id;
	private String shopName;
	private String shopType;
	private String shopTime;
	private String shopDescribe;
	private String shopScore;
	private float entertainment_distance;
	private int entertainment_id;
	private float spot_distance;
	private int spot_id;
	
	public int getSpot_id() {
		return spot_id;
	}
	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	public String getShopTime() {
		return shopTime;
	}
	public void setShopTime(String shopTime) {
		this.shopTime = shopTime;
	}
	public String getShopDescribe() {
		return shopDescribe;
	}
	public void setShopDescribe(String shopDescribe) {
		this.shopDescribe = shopDescribe;
	}
	public String getShopScore() {
		return shopScore;
	}
	public void setShopScore(String shopScore) {
		this.shopScore = shopScore;
	}
	public float getEntertainment_distance() {
		return entertainment_distance;
	}
	public void setEntertainment_distance(float entertainment_distance) {
		this.entertainment_distance = entertainment_distance;
	}
	public int getEntertainment_id() {
		return entertainment_id;
	}
	public void setEntertainment_id(int entertainment_id) {
		this.entertainment_id = entertainment_id;
	}
	public float getSpot_distance() {
		return spot_distance;
	}
	public void setSpot_distance(float spot_distance) {
		this.spot_distance = spot_distance;
	}
}
