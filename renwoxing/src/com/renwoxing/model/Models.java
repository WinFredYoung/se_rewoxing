package com.renwoxing.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.renwoxing.util.SQLConnection;
import com.renwoxing.util.SQLUntil;

public class Models {
	private String describe;
	private List<SpotModel> spotModels;
	private Map<String, ArrayList<ShopModel>> shopModels;
	private Map<String, ArrayList<HotelModel>> hotelModels;
	private Map<String, ArrayList<RestaurantModel>> restaurantModels;
	private Connection connection;
	private float time;
	private float price;
	
//	public static void main(String[] args ) throws SQLException{
//		Models modles = new Models("自然景观",6,0);
//	}
	public Models() {
		super();
	}
	public Models(String describe,float time,float price) throws SQLException {
//		System.out.println("xxxxxxxxx");
		this.describe = describe;
		this.shopModels = new HashMap<>();
		this.spotModels = new ArrayList<>();
		this.hotelModels = new HashMap<>();
		this.restaurantModels = new HashMap<>();
		this.price = price;
		Connection connection = SQLConnection.getConnection();
		this.connection = connection;
		this.time = time;
		createModels();
		
		
	}
	private void createModels() throws SQLException {
		createSpotModels();
		createRestaurantModels();
		createhotelModels();
		createShopModels();
	}
	
	private void createSpotModels() throws SQLException {
		String sql = "select * from spot where spotDescribe like" +"'%" + this.describe + "%'";
		ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
		while (resultSet.next()) {
			String suggestTime = resultSet.getString("spotSuggestTime");
			String spotTime = resultSet.getString("spotTime");
			float[] tempSpotTime = createKaiFangTime(spotTime);
			float tempSuggestTime = suggestTime(suggestTime);
//			System.out.println(tempSpotTime[0] + tempSuggestTime + "===" + tempSpotTime[1]);
			//一天按8个小时来算，景点的开始时间+建议时长<闭馆时间，开始时间+建议时长<游客想游玩天数*8
			//（ques）
			if (tempSpotTime[0] + tempSuggestTime < tempSpotTime[1] && tempSpotTime[0] + tempSuggestTime < this.time * 8){
				SpotModel model = new SpotModel();
				model.setId(resultSet.getInt("id"));
				model.setSpotName(resultSet.getString("spotName"));
				model.setSpotDescribe(resultSet.getString("spotDescribe"));
				model.setSpotScore(resultSet.getString("spotScore"));
				model.setSpotSuggestTime(suggestTime);
				model.setSpotTime(spotTime);
				model.setSpotPrice(resultSet.getFloat("spot_price"));
				this.spotModels.add(model);
			}
		}
		resultSet.close();
	}
	
	private float[] createKaiFangTime(String kaifangshijian) {
		float[] tempTime = {0,24};
		if (kaifangshijian.equals("全天")) {
			
		} else {
//			System.out.println(kaifangshijian);
			//分割时间的字符串，例如：9：30-16：00,分割成9 30 16 00
			String[] temp = kaifangshijian.split("[：:-]");
			//开放时间
//			for (String st:temp){
//				System.out.println(Float.parseFloat(st));
//			}
			tempTime[0] = (new Float(temp[0])).floatValue() + ((new Float(temp[1])).floatValue())/60;
			//闭馆时间
			tempTime[1] = (new Float(temp[2])).floatValue() + ((new Float(temp[3])).floatValue())/60;
//			System.out.println(tempTime[0]+"                  "+tempTime[1]);
			
		}
		return tempTime;	
	}
	private float suggestTime(String suggestTime) {
		//处理建议时长的时间格式
		float tempTime = 0;
		if (suggestTime == null) {
			System.out.println("建议时间为空");
		}else {
			tempTime = (new Float(suggestTime)).floatValue();
		}
		return tempTime;
	}
	
	private void createShopModels() throws SQLException {
		for (SpotModel spotModel : spotModels) {
			int id = spotModel.getId();
			String sql = "select * from shop where shopDescribe like" +"'%" + this.describe + "%'" + "or spot_id =" + id;
			ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
			ArrayList<ShopModel> arrayList = null;
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
				if (this.shopModels.get(String.valueOf(id)) == null) {
					arrayList = new ArrayList<>();
					this.shopModels.put(String.valueOf(id), arrayList);
				}
				arrayList.add(model);
			}
			resultSet.close();
		}
		
		
	}
	
	private void createhotelModels() throws SQLException {
		for (SpotModel spotModel : spotModels) {
			int id = spotModel.getId();
			String sql = "select * from hotel where hotelDescribe like" +"'%" + this.describe + "%'"+"or spot_id =" + id ;
			ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
			ArrayList<HotelModel> arrayList = null;
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
				 if (this.hotelModels.get(String.valueOf(id)) == null) {
					arrayList = new ArrayList<>();
					this.hotelModels.put(String.valueOf(id), arrayList);
				}
				arrayList.add(model); 
			}
			resultSet.close();
		}
		
		
	}
	
	private void createRestaurantModels() throws SQLException  {
		for (SpotModel spotModel : spotModels) {
			int id = spotModel.getId();
			String sql = "select * from restaurant where restaurantDescribe like" +"'%" + this.describe + "%'" +"or spot_id =" + id;
			ResultSet resultSet = SQLUntil.getResultSet(sql, connection);
			ArrayList<RestaurantModel> arrayList = null;
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
				if (this.restaurantModels.get(String.valueOf(id)) == null) {
					arrayList = new ArrayList<>();
					this.restaurantModels.put(String.valueOf(id), arrayList);
				}
				arrayList.add(model);
			}
			resultSet.close();
		}
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<SpotModel> getSpotModels() {
		return spotModels;
	}
	public void setSpotModels(List<SpotModel> spotModels) {
		this.spotModels = spotModels;
	}
	public Map<String, ArrayList<ShopModel>> getShopModels() {
		return shopModels;
	}
	public void setShopModels(Map<String, ArrayList<ShopModel>> shopModels) {
		this.shopModels = shopModels;
	}
	public Map<String, ArrayList<HotelModel>> getHotelModels() {
		return hotelModels;
	}
	public void setHotelModels(Map<String, ArrayList<HotelModel>> hotelModels) {
		this.hotelModels = hotelModels;
	}
	public Map<String, ArrayList<RestaurantModel>> getRestaurantModels() {
		return restaurantModels;
	}
	public void setRestaurantModels(Map<String, ArrayList<RestaurantModel>> restaurantModels) {
		this.restaurantModels = restaurantModels;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	
}
