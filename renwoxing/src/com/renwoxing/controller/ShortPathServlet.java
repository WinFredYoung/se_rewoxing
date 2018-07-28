package com.renwoxing.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONArray;		//不用这个json包
//import net.sf.json.JSONObject;

 
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.renwoxing.model.HotelModel;
import com.renwoxing.model.Models;
import com.renwoxing.model.PathDes;
import com.renwoxing.model.SuggestModel;
import com.renwoxing.model.Test;
import com.renwoxing.util.ResponseUtil;
import com.renwoxing.util.SQLConnection;

/**
 * Servlet implementation class ShortPathServlet
 */
@WebServlet("/ShortPathServlet")
public class ShortPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShortPathServlet() {
        // TODO Auto-generated constructor stub
    	//System.out.println("========================");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// TODO Auto-generated method stub
//		
//		//doGet(request, response);
////		SpotModel model = new SpotModel("丽江古城");
////		System.out.println(model.getSpotName());
//		System.out.println("slkadfjlsdjf");
		
		try {
//			Models modles = new Models("历史名胜古迹",2,0);
			
			Models modles = new Models("自然景观",2,500);
			SQLConnection.getConnection().close();
			PathDes pathDes = new PathDes(modles);
//			JSONObject jsonObject1 = JSONObject.fromObject(pathDes.getDisMap());			//按照距离排序获得的推荐路线集合
//			JSONObject jsonObject2 = JSONObject.fromObject(pathDes.getPriceMap());			//按照价格排序获得的推荐路线集合
			JSONObject jsonObject2 = JSONObject.parseObject(JSONObject.toJSONString(pathDes.getPriceMap()));			//按照价格排序获得的推荐路线集合
//			ResponseUtil.write(response, jsonObject1);
			
			
			
			
			ResponseUtil.write(response, jsonObject2);
			
			
		/*=====================================================================================================*/
		/*=====================================================================================================*/
		/*=========================================开始解析json数据=============================================*/
		/*=====================================================================================================*/
		/*=====================================================================================================*/
			
			
			
			System.out.println("==================================解析====================================================");
			Map<String, Object> jsmap = jsonObject2.getInnerMap();
			for(Map.Entry<String, Object> entry : jsmap.entrySet()){
				//获取json第一层数据，即路线
				System.out.println("Key = " + entry.getKey());//显示是第几条路线及其总的花费
				
				//获取第二层数据，即包含了suggestmodel的map
				JSONArray spotlist = JSONObject.parseArray(entry.getValue().toString());
				
				int days = 1;//遍历suggestmap，如果遇到key等于13的时候，说明天数要加1
				System.out.println("第" + days + "天:");
				
				
//				System.out.println(spotlist.size());
				for(int i = 0; i < spotlist.size(); ++i){
//					System.out.println(spotlist.get(i));
					//获取第三层数据，即suggestmodel
					Map<String, Object> suggestMap = (Map<String, Object>) spotlist.get(i);
					
					for(Map.Entry<String, Object> entry2 : suggestMap.entrySet()){
						
//						System.out.println("Key = " + entry2.getKey() + ", Value = " + entry2.getValue());\\
//						System.out.println("Key = " + entry2.getKey());
						
						
						//获取suggest中的各个model数据
						JSONObject map_3 = JSONObject.parseObject(JSONObject.toJSONString(entry2.getValue()));
						
//						System.out.println("hotelModel:"+map_3.get("hotelModel"));
//						System.out.println("restaurantModel:"+map_3.get("restaurantModel"));
//						System.out.println("shopModel:"+map_3.get("shopModel"));
//						System.out.println("spotModel:"+map_3.get("spotModel"));
						
						JSONObject map_hotel = JSONObject.parseObject(JSONObject.toJSONString(map_3.get("hotelModel")));
						JSONObject map_restaurant = JSONObject.parseObject(JSONObject.toJSONString(map_3.get("restaurantModel")));
						JSONObject map_shop = JSONObject.parseObject(JSONObject.toJSONString(map_3.get("shopModel")));
						JSONObject map_spot = JSONObject.parseObject(JSONObject.toJSONString(map_3.get("spotModel")));
						if(map_hotel != null){
							System.out.println("entertainment_distance:" + map_hotel.get("entertainment_distance"));
							System.out.println("spot_distance:" + map_hotel.get("spot_distance"));
							System.out.println("hotelAddress:" + map_hotel.get("hotelAddress"));
							System.out.println("hotelName:" + map_hotel.get("hotelName"));
							System.out.println("ave_price:" + map_hotel.get("ave_price"));
							System.out.println("hotelScore:" + map_hotel.get("hotelScore"));
							System.out.println("hotelLevel:" + map_hotel.get("hotelLevel"));
							System.out.println("hotelDescribe:" + map_hotel.get("hotelDescribe"));
							System.out.println("\n");
						}
						if(map_restaurant != null){
							System.out.println("restaurantScore:" + map_restaurant.get("restaurantScore"));
							System.out.println("spot_distance:" + map_restaurant.get("spot_distance"));
							System.out.println("restaurantDescribe:" + map_restaurant.get("restaurantDescribe"));
							System.out.println("restaurantAddress:" + map_restaurant.get("restaurantAddress"));
							System.out.println("restaurantName:" + map_restaurant.get("restaurantName"));
							System.out.println("restaurantType:" + map_restaurant.get("restaurantType"));
							System.out.println("agr_price:" + map_restaurant.get("agr_price"));
							System.out.println("\n");
						}
						if(map_shop != null){
							System.out.println("shopScore:" + map_shop.get("shopScore"));
							System.out.println("shopDescribe:" + map_shop.get("shopDescribe"));
							System.out.println("shopTime:" + map_shop.get("shopTime"));
							System.out.println("shopName:" + map_shop.get("shopName"));
							System.out.println("spot_distance:" + map_shop.get("spot_distance"));
							System.out.println("shopType:" + map_shop.get("shopType"));
							System.out.println("\n");
						}
						if(map_spot != null){
							System.out.println("spotSuggestTime:" + map_spot.get("spotSuggestTime"));
							System.out.println("spotPrice:" + map_spot.get("spotPrice"));
							System.out.println("spotScore:" + map_spot.get("spotScore"));
							System.out.println("spotTime:" + map_spot.get("spotTime"));
							System.out.println("spotDescribe:" + map_spot.get("spotDescribe"));
							System.out.println("spotName:" + map_spot.get("spotName"));
							System.out.println("\n");
						}
							
//						HotelModel hotel = (HotelModel)map_3.get("hotelModel");
						if(entry2.getKey().toString() == "13" && i != (spotlist.size() - 1)){
							//出现13表明今天下午的景点等已经安排完了，天数需要+1
							days++;
							System.out.println("第" + days + "天:");
						
						}
					}//for(Map.Entry<String, Object> entry2 : suggestMap.entrySet())
				
				System.out.println("\n\n");
				
					
				}//for(int i = 0; i < spotlist.size(); ++i)
			}//for(Map.Entry<String, Object> entry : jsmap.entrySet())
			
			
			
		/*=====================================================================================================*/
		/*=====================================================================================================*/
		/*=========================================解析完成 ====================================================*/
		/*=====================================================================================================*/
		/*=====================================================================================================*/
		
			
			
			
			
			
			
			
			
//			com.alibaba.fastjson.JSONObject suggestPath=JSON.parseObject(jsonObject.getString("1"));
			
			//如果是getTime天，而有安排了2条路线；显示两条路线，所以在前台，需要将2条路线，单独显示出来
			
//			JSONObject rows1=JSON.parseObject(jsonObject.getString("1"));
//			System.out.println(jsonObject);
			
		/*	
			Map map = (Map)jsonObject.get("1");
			System.out.println(map.get("3"));
			map.get("3");
			JSONObject map_3=JSONObject.fromObject(map.get("3"));
			System.out.println("hotelModel:"+map_3.get("hotelModel"));
			System.out.println("restaurantModel:"+map_3.get("restaurantModel"));
			System.out.println("shopModel:"+map_3.get("shopModel"));
			System.out.println("spotModel:"+map_3.get("spotModel"));
			Map<String,Map> hotel=(Map)map_3.get("hotelModel");
			System.out.println(hotel.get("ave_price"));
//			HotelModel hotel = (HotelModel)map_3.get("hotelModel");
//			System.out.println(hotel.getAve_price());
//			System.out.println(hotel.get("ave_price"));
//			map.get("3").getClass();3
//			HotelModel hotelModel= map.get("3");
			
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			
			*/
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Test.print();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
