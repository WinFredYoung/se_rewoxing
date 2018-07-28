package com.renwoxing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PathDes {
//	public void 
	private Models models;
//	private Map<String, SuggestModel> map;
	public IdentityHashMap <String,Map<String,SuggestModel>> map;
	public Map<String, ArrayList<Map<String, Map<String, SuggestModel>>>> Disrecommend;
	public LinkedHashMap<String, ArrayList<Map<String, Map<String, SuggestModel>>>> Pricerecommend;
	//用LinkedHashMap存储路线信息，方便按照存入时的顺序读取第i条路线的信息
	public Models getModels() {
		return models;
	}
	public void setModels(Models models) {
		this.models = models;
	}
	public Map<String, ArrayList<Map<String, Map<String, SuggestModel>>>> getDisMap() {
		return Disrecommend;
	}
	public LinkedHashMap<String, ArrayList<Map<String, Map<String, SuggestModel>>>> getPriceMap() {
		return Pricerecommend;
	}
	public void setMap(IdentityHashMap<String, Map<String, SuggestModel>> map) {
		this.map = map;
	}
	public PathDes(Models models) {
		this.models = models;
		this.map = new IdentityHashMap<>();
		this.Disrecommend = new HashMap<String,ArrayList<Map<String,Map<String,SuggestModel>>>>();
		
		this.Pricerecommend = new LinkedHashMap<>();
		
//		shortestPath();
		Optimalpath();
		
	}
	
	
	private void Optimalpath() {
		//Optimalpath计算推荐路线，分别根据距离和价格花费来计算，根据距离计算的结果存入Disrecommend中，、
		//根据价格花费计算的结果存入Pricerecomend中
//		Map <String,Map<String,SuggestModel>> map = new HashMap<>();
	/*
		//编造数据；
		if (models.getTime() > 1) {
			List<SpotModel> spotModels = new ArrayList<>(models.getSpotModels());
			List<SpotModel> spotModels2 = new ArrayList<>(models.getSpotModels());
			List<SpotModel> spotModels3 = new ArrayList<>(models.getSpotModels());
			models.getSpotModels().addAll(spotModels);
//			System.out.println("***************"+models.getSpotModels().size());
			models.getSpotModels().addAll(spotModels2);
//			System.out.println("***************"+models.getSpotModels().size());
//			models.getSpotModels().addAll(spotModels3);
//			System.out.println("***************"+models.getSpotModels().size());
		}
		
		*/
		IdentityHashMap<Float, ArrayList<Map<String, Map<String, SuggestModel>>>> temp_Price_map = new IdentityHashMap<Float,ArrayList<Map<String,Map<String,SuggestModel>>>>();
		//temp_Price_map用来缓存需要根据价格排序的路线
		
		int totaldays = RecordPath();				//获取游玩所有景点需要的天数
		float traveldays = models.getTime();		//获取游玩天数
		
		System.out.println("totaldays:" + totaldays);
		System.out.println("travel:" + traveldays);
				
		int i_thRoute = 1;							//设定是第几条推荐的游玩路线
		float i_thRoute_price = 0;					//设定是第几条推荐路线的总花费
		
		
		/*========================================================================================*
		 * *====================================核心算法=============================================*
		 * *=======================================================================================*
		 *	从第一天的景点开始，顺序读取后面几天等于游玩天数的景点，一直读到第n天结束，则得出有几条推荐路线，存入disrecommend，并计算出  *
		 *			每一条推荐路线的花费，然后对其从小到大进行排序，最后的出的结果存入Pricerecommend中					   * 
		 * ========================================================================================*/
		
		
		
		for(int i = 1;  i <= totaldays; ++i){
			i_thRoute_price = 0;
			if(i + traveldays - 1 > totaldays){
				//如果游玩天数大于了游玩所有景点的天数，跳出循环
				System.out.println((i + traveldays - 1) + "break");
				break;
			}
			
			ArrayList spottem = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			ArrayList spotlist = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			
			//spottem用来存储每一条路线中每一个景点，餐馆，酒店，商店的信息
			System.out.println("第" + i_thRoute + "条路线-------");
	
			for(int k = 1, j = i; k <= traveldays && j <= totaldays; ++k, ++j){
				System.out.println("遍历");
				//从第一天开始遍历，之后遍历traveldays天的数据，并将之存入spottem这个链表中
				Set<String>  keytemp  = map.keySet();
				spottem.clear();
				
				for(String s1 : keytemp){
					//用于遍历并取出map中对应第i天的信息,并把它放到spottem中等待排序
					
					if(Integer.parseInt(s1) == j){
						System.out.println("第"+ k +"天+"  + map.get(s1).keySet());
						
						//获取某一天中某一个景点的价格，并将它加到i_thRout_price中，方便统计某条路线需要花费的总价
						Collection<SuggestModel> suggestmodels = map.get(s1).values();
						 for(SuggestModel mo : suggestmodels){
							 i_thRoute_price += mo.getPrice();
						}
						 
						 spottem.add(map.get(s1));
						 System.out.println("add:"+ map.get(s1).values().toString() + "  "+ map.get(s1) );
						 //获取完某一天的所有信息，将它添加到spottem这个链表中
					}
					
					
					
				}//for(String s1 : Keytemp)
				
				System.out.println("排序");
				//根据某一天当中游玩的时间来排序，然后将排好序的景点放入spotlist中
				Collections.sort(spottem, new Comparator<Map<String, Object>>() {
		            @Override
		            public int compare(Map<String, Object> arg0,Map<String, Object> arg1) {
		                String str1 =  arg0.keySet().toString();
		                String str2 =  arg1.keySet().toString();
		                return str1.compareTo(str2);
		            }
		        });
				for(int l = 0; l < spottem.size(); l++){
					System.out.println("key:" + spottem.get(l).toString());
					spotlist.add(spottem.get(l));
				}
				
			
				
			}//for(int k = 1, l = j; k < travelTime; ++k, ++l)
			
			if(!spotlist.isEmpty()){
				//如果spottem中有信息，表示有第i条路线的信息，将其格式化为一个map，方便json的存取
				//格式化后存入Disrecommend中
				Disrecommend.put("第"+ i_thRoute +"条路线：", spotlist);
				
				
				System.out.println("第"+ i_thRoute +"条路线total price:" + i_thRoute_price); 
				//得出某一条路线的总价格，并存储在temp_Price_map中，方便计算
				temp_Price_map.put(i_thRoute_price, spotlist);
			}
				
			i_thRoute++;
		}//for(int i = 1;  i <= totaldays; ++i)
		
		
		if(Disrecommend.isEmpty()){
			//如果Disrecommed中没有数据，表示游玩天数比游玩所有景点需要的天数都要多，此时只会有游玩所有景点一条路线
			ArrayList spottem = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			ArrayList spotlist = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			
			System.out.println("第" + i_thRoute + "路线");
			for(int k = 1; k < traveldays; ++k){
				
				Set <String> temp;
				temp = map.keySet();
				spottem.clear();
				for(String s1 : temp){
					if(Integer.parseInt(s1) == k){
						System.out.println("第"+ k +"天："  + map.get(s1)+map);
						
						//获取某一天中某一个景点的价格，并将它加到i_thRout_price中，方便统计某条路线需要花费的总价
						Collection<SuggestModel> suggestmodels = map.get(s1).values();
						 for(SuggestModel mo : suggestmodels){
							 i_thRoute_price += mo.getPrice();
						 }
						 
						spottem.add(map.get(s1));
						System.out.println("add:"+ map.get(s1).values() + "  "+ map.get(s1) );
						
						System.out.println("排序2");
						Collections.sort(spottem, new Comparator<Map<String, Object>>() {
				            @Override
				            public int compare(Map<String, Object> arg0,Map<String, Object> arg1) {
				                String str1 =  arg0.keySet().toString();
				                String str2 =  arg1.keySet().toString();
				                return str1.compareTo(str2);
				            }
				        });
						for(int l = 0; l < spottem.size(); l++){
							System.out.println("key:" + spottem.get(l).toString());
							spotlist.add(spottem.get(l));
						}
					}
				
				}//for(String s1 : temp)
			}//for
			Disrecommend.put("第"+ i_thRoute +"条路线：", spotlist);
			System.out.println("第"+ i_thRoute +"条路线total price:" + i_thRoute_price);
			//得出某一条路线的总价格，并存储在某个容器中，方便计算
			temp_Price_map.put(i_thRoute_price, spotlist);
			
		}//if(Disrecommend.isEmpty())
		
		
		
		 		/*==========================================================================================*
				 *	从temp_Price_map中取出某条路线的总花费，将它转存到一个TreeSet中，TreeSet自动将其从小到大排序，然后在根据排序后的结果，依次从其  *
				 *			对应的temp_Price_map中取出某一条路线的信息，然后将其格式化后写入到Pricerecommend中					    * 
				 * ======================================================================================== */
		
		
		//对temp_Price_map中的价格从小到大进行排序
		TreeSet<Float> temp_set = new TreeSet<Float>();
		temp_set.addAll(temp_Price_map.keySet());
		
		for(Float f : temp_set){
			System.out.println("sorted:" + f);
		}
		
		i_thRoute = 1;
		//根据取出的价格信息，取出temp_Price_map中的某一条路线的信息，格式化后存入Pricerecommend中
		
		for(Float f: temp_set){
			System.out.println("路线总花费价格：" + f );
			System.out.println("用户定义价格上限:" + models.getPrice());
//			Pricerecommend.put("路线", temp_Price_map.get(f));
			if(f < (models.getPrice() + 100.0)){
				Pricerecommend.put("第"+ i_thRoute +"路线(totalprice：" + f +")", temp_Price_map.get(f));
			}
			i_thRoute++;
		}

		
		
//		for (Map<String, SuggestModel> m1 : m.get("1")){
//			
//		}
		
//		for(int m = 0; m < models.getTime();m++){
//			
//		}
//		
//		map.
//		
		
		
		//k表示游玩到第几个景点
//		for(int m = 0; m < models.getTime();m++) {
			//m表示游玩到第几天
//			Map<String,SuggestModel> value = new HashMap<>();
//			float startTime = 9;
//			float suggestTime=0;
//			float endTime=startTime+suggestTime;
//			for(int j = k;j < models.getSpotModels().size();j++){
////				Map<String,SuggestModel> value = new HashMap<>();
//				SpotModel spotModel = models.getSpotModels().get(j);
//				String spotName = spotModel.getSpotName();
//				k++;
//				float[] spotTime = createKaiFangTime(spotModel.getSpotTime());
//				//如果开始游玩时间早于开馆时间，将景点开馆时间作为开始游玩时间
//				if ( startTime<spotTime[0]) {
//					startTime = spotTime[0];
//				}
//				suggestTime = suggestTime(spotModel.getSpotSuggestTime());
//				//如果开始游玩时间+建议游玩时长>=景点闭馆时间，将景点闭馆时间作为 结束游玩时间
//				if(startTime+suggestTime>=spotTime[1]){
//					endTime=spotTime[1];
//				}else{//如果开始游玩时间+建议游玩时长<景点闭馆时间，将 开始游玩时间+建议游玩时长 作为 结束游玩时间
//					endTime = startTime + suggestTime;
//				}
//				
//				/*===================================================================================*
//				 * ====================================时间的判断算法=====================================*
//				 * ==================================================================================*
//				 */
//				if(endTime<11){
//					//11点前结束游玩
//					System.out.println(spotName + ":" +startTime + " endTime<11 " + endTime);
//					SuggestModel suggestModel = new SuggestModel();
//					suggestModel.setSpotModel(spotModel);
//						value.put("11点前结束游玩的景点："+spotModel.getSpotName(), suggestModel);
//						//将本次结束时间+1小时，作为下次的开始时间
//						startTime = endTime +1;
//						map.put("第"+(m+1)+"天", value);
//						continue;
//						
//				}
//				else if (endTime >= 11 && endTime<=13) {
//					//11-13点之间结束游玩，安排景点、餐馆、商店
//					//首先判断是否可以根据id获取餐馆数据，可以获取则查出最近的餐馆信息，否则显示“无最近餐馆信息”
//					System.out.println(spotName + ":" +startTime + " endTime >= 11 && endTime<=13 " + endTime);
//					if(IsGetRestaurant(spotModel.getId())){
//						RestaurantModel restaurantModel = getShortestRestaurant(spotModel.getId());
//						
//						SuggestModel suggestModel = new SuggestModel();
//						suggestModel.setRestaurantModel(restaurantModel);
//						suggestModel.setSpotModel(spotModel);
//						value.put("11-13点之间结束游玩，安排景点、餐馆："+spotModel.getSpotName(), suggestModel);
//						startTime = endTime +1;		
//						map.put("第"+(m+1)+"天：", value);
//						continue;
//						
//					}else{
//						System.out.println("景点"+String.valueOf(spotModel.getSpotName())+"无最近餐馆信息");
//					}
//
//				} 
//				else if (endTime >= 13) {
//					//13点以后结束，下午安排景点、最近的餐馆、最近的旅馆、最近的商店
//					System.out.println(spotName + ":" +startTime + " endTime >= 13 " + endTime);
//					if ((spotTime[1] - startTime < 1 ) || startTime > spotTime[1]) {
//						//可以游玩时间（景点闭馆时间-开始游玩时间）少于1个小时 或者 开始游玩时间 在 闭馆时间之后，跳过该景点
//						continue;
//					}
////					//获取当前景点的建议游玩时长
////					suggestTime=suggestTime(spotModel.getSpotSuggestTime());
////					
//					if(IsGetRestaurant(spotModel.getId()) && IsGetHotel(spotModel.getId()) && IsGetShop(spotModel.getId()) ){
//						//餐馆，酒店，商店都可以获取到
//						SuggestModel suggestModel = new SuggestModel(spotModel,getShortestRestaurant(spotModel.getId()),getShortestHotel(spotModel.getId()),getShotestShop(spotModel.getId()));
//						value.put("13点以后结束的景点、餐馆、酒店、商店："+spotModel.getSpotName(), suggestModel);
//						map.put("第"+(m+1)+"天",value);
//					}else{
//						System.out.println("景点"+String.valueOf(spotModel.getSpotName()+ "无推荐路线"));
//					}
//					
//					break;			//结束今天的行程
//				}
				
//			}//for(int j = k;j < models.getSpotModels().size();j++)
		
	}
	
	private float[] createKaiFangTime(String kaifangshijian) {
		float[] tempTime = {0,24};
		if (kaifangshijian.equals("全天")) {
			
		} else {
			
			//字符串分割，将8：30-16：00 分割为8 30 16 00
			String[] temp = kaifangshijian.split("[：:-]");
			//将"分"转化成“小时”
			tempTime[0] = (new Float(temp[0])).floatValue() + ((new Float(temp[1])).floatValue())/60;
			tempTime[1] = (new Float(temp[2])).floatValue() + ((new Float(temp[3])).floatValue())/60;
		}
		return tempTime;	
	}
	private float suggestTime(String suggestTime) {
		float tempTime = 0;
		if (suggestTime == null) {
			System.out.println("建议时间为空");
		}else {
			tempTime = (new Float(suggestTime)).floatValue();
		}
		return tempTime;
	}
	//获取最近的餐馆
	private RestaurantModel getShortestRestaurant(int id) {
		
			List<RestaurantModel> restaurantModels = models.getRestaurantModels().get(String.valueOf(id));
			
			RestaurantModel model = restaurantModels.get(0);
			for (int i = 1; i < restaurantModels.size(); i++) {
				if (restaurantModels.get(i).getSpot_distance() <model.getSpot_distance()) {
					model = restaurantModels.get(i);
				}
			}
				return model;
	}
	private boolean IsGetRestaurant(int id){
		List<RestaurantModel> restaurantModels = models.getRestaurantModels().get(String.valueOf(id));
		if (restaurantModels == null){
			return false;
		}
		
		return true;
		
	}
	private boolean IsGetHotel(int id){
		if(IsGetRestaurant(id)){
			List<HotelModel> hotelModels = models.getHotelModels().get(String.valueOf(id));
			if (hotelModels == null){
				return false;
			}
		}
		return true;
	}
	
	private boolean IsGetShop(int id){
		if(IsGetRestaurant(id)){
			List<ShopModel> ShopModels = models.getShopModels().get(String.valueOf(id));
			if (ShopModels == null){
				return false;
			}
		}
		return true;
	}
	
	private HotelModel getShortestHotel(int id) {
		//首先查找出景点对应的餐馆信息，然后根据餐馆信息查找出酒店信息，最终算出距离最短的酒店。
//		List<HotelModel> tempModel =models.getHotelModels().get(id);
		List<RestaurantModel> restaurantModels =models.getRestaurantModels().get(String.valueOf(id));
		RestaurantModel model1 = null;
		ArrayList<RestaurantModel> arrayList = new ArrayList<>();
		int temp = 0;
		for (int i = 0; i < restaurantModels.size(); i++) {
			if (restaurantModels.get(i).getSpot_id() == id && (restaurantModels.get(i).getHotel_id() != 0)) {
				arrayList.add(restaurantModels.get(i));	
			}
		}
		model1 = arrayList.get(0);
		for (RestaurantModel restaurantModel : arrayList) {
			if (model1.getHotel_distance() > restaurantModel.getHotel_distance()) {
				model1 = restaurantModel;
			}
		}
		HotelModel tempModel1 = null;
		for (HotelModel hotelModel : models.getHotelModels().get(String.valueOf(id))) {
			if (hotelModel.getId() == model1.getHotel_id()){
				tempModel1 = hotelModel;
				break;
			}
		}
		return tempModel1;
	}
	
	
	
	private ShopModel getShotestShop(int id) {
		List<HotelModel> hotelModels = new ArrayList<>();
		for (HotelModel hotelModel : models.getHotelModels().get(String.valueOf(id))) {
			if (hotelModel.getSpot_id() == id) {
				hotelModels.add(hotelModel);
			}
		}
		
		HotelModel tempModle1 = hotelModels.get(0);
		for (HotelModel hotelModel : hotelModels) {
			if (tempModle1.getShop_distance() > hotelModel.getShop_distance()) {
				tempModle1 = hotelModel;
			}
		}
		ShopModel tempModel2 = null;
		for (ShopModel shopModel : models.getShopModels().get(String.valueOf(id))) {
			if (shopModel.getId() == tempModle1.getShop_id()) {
				tempModel2 = shopModel;
			}
		}
		return tempModel2;
	}
	private  int RecordPath(){
		//根据景点的游玩时间来判断游玩所有景点所需要的天数，并将游玩结果安排存入map中
		int days = 1;
		float startTime = 9;
		float suggestTime=0;
		float endTime=startTime+suggestTime;

		
		for(int j = 0;j < models.getSpotModels().size();j++){
			Map<String,SuggestModel> value = new HashMap<>();
			SpotModel spotModel = models.getSpotModels().get(j);
			String spotName = spotModel.getSpotName();
			
			float[] spotTime = createKaiFangTime(spotModel.getSpotTime());
			//如果开始游玩时间早于开馆时间，将景点开馆时间作为开始游玩时间
			if ( startTime<spotTime[0]) {
				startTime = spotTime[0];
			}
			suggestTime = suggestTime(spotModel.getSpotSuggestTime());
			//如果开始游玩时间+建议游玩时长>=景点闭馆时间，将景点闭馆时间作为 结束游玩时间
			if(startTime+suggestTime>=spotTime[1]){
				endTime=spotTime[1];
			}else{//如果开始游玩时间+建议游玩时长<景点闭馆时间，将 开始游玩时间+建议游玩时长 作为 结束游玩时间
				endTime = startTime + suggestTime;
			}
			
			/*===================================================================================*
			 * ====================================时间的判断算法=====================================*
			 * ==================================================================================*
			 */
			if(endTime<11){
				//11点前结束游玩
				System.out.println(spotName + ":" +startTime + " endTime<11 " + endTime);
				SuggestModel suggestModel = new SuggestModel();
				suggestModel.setSpotModel(spotModel);
				suggestModel.CalculatePrice();
				System.out.println("price" + suggestModel.getPrice());
				
				value.put("11", suggestModel);//表示11点前结束游玩的景点，不用
				//将本次结束时间+1小时，作为下次的开始时间
				startTime = endTime +1;
				map.put(""+days, value);
//				Needrevise = true;
				continue;
					
			}
			else if (endTime >= 11 && endTime<=13) {
				//11-13点之间结束游玩，安排景点、餐馆、商店
				//首先判断是否可以根据id获取餐馆数据，可以获取则查出最近的餐馆信息，否则显示“无最近餐馆信息”
				System.out.println(spotName + ":" +startTime + " endTime >= 11 && endTime<=13 " + endTime);
				if(IsGetRestaurant(spotModel.getId())){
					RestaurantModel restaurantModel = getShortestRestaurant(spotModel.getId());
					
					SuggestModel suggestModel = new SuggestModel();
					suggestModel.setRestaurantModel(restaurantModel);
					suggestModel.setSpotModel(spotModel);
					suggestModel.CalculatePrice();
					System.out.println("price" + suggestModel.getPrice());
					
					value.put("12", suggestModel);//表示11-13点之间结束游玩，需要安排景点、餐馆
					startTime = endTime +1;		
					map.put(""+days, value);
//					Needrevise = true;
					continue;
					
				}else{
					System.out.println("景点"+String.valueOf(spotModel.getSpotName())+"无最近餐馆信息");
				}

			} 
			else if (endTime >= 13) {
				//13点以后结束，下午安排景点、最近的餐馆、最近的旅馆、最近的商店
				System.out.println(spotName + ":" +startTime + " endTime >= 13 " + endTime);
				if ((spotTime[1] - startTime < 1 ) || startTime > spotTime[1]) {
					//可以游玩时间（景点闭馆时间-开始游玩时间）少于1个小时 或者 开始游玩时间 在 闭馆时间之后，跳过该景点
					continue;
				}
//				//获取当前景点的建议游玩时长
//				suggestTime=suggestTime(spotModel.getSpotSuggestTime());
//				
				if(IsGetRestaurant(spotModel.getId()) && IsGetHotel(spotModel.getId()) && IsGetShop(spotModel.getId()) ){
					//可以推荐的景点，餐馆，酒店，商店都可以获取到，此时天数需要+1，且不用修正天数
					SuggestModel suggestModel = new SuggestModel(spotModel,getShortestRestaurant(spotModel.getId()),getShortestHotel(spotModel.getId()),getShotestShop(spotModel.getId()));
					suggestModel.CalculatePrice();
					System.out.println("price" + suggestModel.getPrice());
					value.put("13", suggestModel);//表示13点以后结束，需要安排的景点、餐馆、酒店、商店
					map.put(""+days,value);
					days++;
//					Needrevise = false;
				}else{
					//不可以推荐的景点，
					System.out.println("景点"+String.valueOf(spotModel.getSpotName()+ "无推荐路线"));
				}
				
				
				//恢复到第二天的初始值
				startTime = 9;
				suggestTime=0;
				endTime=startTime+suggestTime;
				
				
//				break;			//结束今天的行程
			}
	
		}
//		if(Needrevise){
//			days++;
//		}
		
		System.out.println("retrun m :"+days);
		return days;
	}//RecordPath()
}
