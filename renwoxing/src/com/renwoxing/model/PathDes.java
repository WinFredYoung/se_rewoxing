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
	//��LinkedHashMap�洢·����Ϣ�����㰴�մ���ʱ��˳���ȡ��i��·�ߵ���Ϣ
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
		//Optimalpath�����Ƽ�·�ߣ��ֱ���ݾ���ͼ۸񻨷������㣬���ݾ������Ľ������Disrecommend�У���
		//���ݼ۸񻨷Ѽ���Ľ������Pricerecomend��
//		Map <String,Map<String,SuggestModel>> map = new HashMap<>();
	/*
		//�������ݣ�
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
		//temp_Price_map����������Ҫ���ݼ۸������·��
		
		int totaldays = RecordPath();				//��ȡ�������о�����Ҫ������
		float traveldays = models.getTime();		//��ȡ��������
		
		System.out.println("totaldays:" + totaldays);
		System.out.println("travel:" + traveldays);
				
		int i_thRoute = 1;							//�趨�ǵڼ����Ƽ�������·��
		float i_thRoute_price = 0;					//�趨�ǵڼ����Ƽ�·�ߵ��ܻ���
		
		
		/*========================================================================================*
		 * *====================================�����㷨=============================================*
		 * *=======================================================================================*
		 *	�ӵ�һ��ľ��㿪ʼ��˳���ȡ���漸��������������ľ��㣬һֱ������n���������ó��м����Ƽ�·�ߣ�����disrecommend���������  *
		 *			ÿһ���Ƽ�·�ߵĻ��ѣ�Ȼ������С��������������ĳ��Ľ������Pricerecommend��					   * 
		 * ========================================================================================*/
		
		
		
		for(int i = 1;  i <= totaldays; ++i){
			i_thRoute_price = 0;
			if(i + traveldays - 1 > totaldays){
				//������������������������о��������������ѭ��
				System.out.println((i + traveldays - 1) + "break");
				break;
			}
			
			ArrayList spottem = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			ArrayList spotlist = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			
			//spottem�����洢ÿһ��·����ÿһ�����㣬�͹ݣ��Ƶ꣬�̵����Ϣ
			System.out.println("��" + i_thRoute + "��·��-------");
	
			for(int k = 1, j = i; k <= traveldays && j <= totaldays; ++k, ++j){
				System.out.println("����");
				//�ӵ�һ�쿪ʼ������֮�����traveldays������ݣ�����֮����spottem���������
				Set<String>  keytemp  = map.keySet();
				spottem.clear();
				
				for(String s1 : keytemp){
					//���ڱ�����ȡ��map�ж�Ӧ��i�����Ϣ,�������ŵ�spottem�еȴ�����
					
					if(Integer.parseInt(s1) == j){
						System.out.println("��"+ k +"��+"  + map.get(s1).keySet());
						
						//��ȡĳһ����ĳһ������ļ۸񣬲������ӵ�i_thRout_price�У�����ͳ��ĳ��·����Ҫ���ѵ��ܼ�
						Collection<SuggestModel> suggestmodels = map.get(s1).values();
						 for(SuggestModel mo : suggestmodels){
							 i_thRoute_price += mo.getPrice();
						}
						 
						 spottem.add(map.get(s1));
						 System.out.println("add:"+ map.get(s1).values().toString() + "  "+ map.get(s1) );
						 //��ȡ��ĳһ���������Ϣ��������ӵ�spottem���������
					}
					
					
					
				}//for(String s1 : Keytemp)
				
				System.out.println("����");
				//����ĳһ�쵱�������ʱ��������Ȼ���ź���ľ������spotlist��
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
				//���spottem������Ϣ����ʾ�е�i��·�ߵ���Ϣ�������ʽ��Ϊһ��map������json�Ĵ�ȡ
				//��ʽ�������Disrecommend��
				Disrecommend.put("��"+ i_thRoute +"��·�ߣ�", spotlist);
				
				
				System.out.println("��"+ i_thRoute +"��·��total price:" + i_thRoute_price); 
				//�ó�ĳһ��·�ߵ��ܼ۸񣬲��洢��temp_Price_map�У��������
				temp_Price_map.put(i_thRoute_price, spotlist);
			}
				
			i_thRoute++;
		}//for(int i = 1;  i <= totaldays; ++i)
		
		
		if(Disrecommend.isEmpty()){
			//���Disrecommed��û�����ݣ���ʾ�����������������о�����Ҫ��������Ҫ�࣬��ʱֻ�����������о���һ��·��
			ArrayList spottem = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			ArrayList spotlist = new ArrayList<Map<String, Map<String, SuggestModel>>> ();
			
			System.out.println("��" + i_thRoute + "·��");
			for(int k = 1; k < traveldays; ++k){
				
				Set <String> temp;
				temp = map.keySet();
				spottem.clear();
				for(String s1 : temp){
					if(Integer.parseInt(s1) == k){
						System.out.println("��"+ k +"�죺"  + map.get(s1)+map);
						
						//��ȡĳһ����ĳһ������ļ۸񣬲������ӵ�i_thRout_price�У�����ͳ��ĳ��·����Ҫ���ѵ��ܼ�
						Collection<SuggestModel> suggestmodels = map.get(s1).values();
						 for(SuggestModel mo : suggestmodels){
							 i_thRoute_price += mo.getPrice();
						 }
						 
						spottem.add(map.get(s1));
						System.out.println("add:"+ map.get(s1).values() + "  "+ map.get(s1) );
						
						System.out.println("����2");
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
			Disrecommend.put("��"+ i_thRoute +"��·�ߣ�", spotlist);
			System.out.println("��"+ i_thRoute +"��·��total price:" + i_thRoute_price);
			//�ó�ĳһ��·�ߵ��ܼ۸񣬲��洢��ĳ�������У��������
			temp_Price_map.put(i_thRoute_price, spotlist);
			
		}//if(Disrecommend.isEmpty())
		
		
		
		 		/*==========================================================================================*
				 *	��temp_Price_map��ȡ��ĳ��·�ߵ��ܻ��ѣ�����ת�浽һ��TreeSet�У�TreeSet�Զ������С��������Ȼ���ڸ��������Ľ�������δ���  *
				 *			��Ӧ��temp_Price_map��ȡ��ĳһ��·�ߵ���Ϣ��Ȼ�����ʽ����д�뵽Pricerecommend��					    * 
				 * ======================================================================================== */
		
		
		//��temp_Price_map�еļ۸��С�����������
		TreeSet<Float> temp_set = new TreeSet<Float>();
		temp_set.addAll(temp_Price_map.keySet());
		
		for(Float f : temp_set){
			System.out.println("sorted:" + f);
		}
		
		i_thRoute = 1;
		//����ȡ���ļ۸���Ϣ��ȡ��temp_Price_map�е�ĳһ��·�ߵ���Ϣ����ʽ�������Pricerecommend��
		
		for(Float f: temp_set){
			System.out.println("·���ܻ��Ѽ۸�" + f );
			System.out.println("�û�����۸�����:" + models.getPrice());
//			Pricerecommend.put("·��", temp_Price_map.get(f));
			if(f < (models.getPrice() + 100.0)){
				Pricerecommend.put("��"+ i_thRoute +"·��(totalprice��" + f +")", temp_Price_map.get(f));
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
		
		
		//k��ʾ���浽�ڼ�������
//		for(int m = 0; m < models.getTime();m++) {
			//m��ʾ���浽�ڼ���
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
//				//�����ʼ����ʱ�����ڿ���ʱ�䣬�����㿪��ʱ����Ϊ��ʼ����ʱ��
//				if ( startTime<spotTime[0]) {
//					startTime = spotTime[0];
//				}
//				suggestTime = suggestTime(spotModel.getSpotSuggestTime());
//				//�����ʼ����ʱ��+��������ʱ��>=����չ�ʱ�䣬������չ�ʱ����Ϊ ��������ʱ��
//				if(startTime+suggestTime>=spotTime[1]){
//					endTime=spotTime[1];
//				}else{//�����ʼ����ʱ��+��������ʱ��<����չ�ʱ�䣬�� ��ʼ����ʱ��+��������ʱ�� ��Ϊ ��������ʱ��
//					endTime = startTime + suggestTime;
//				}
//				
//				/*===================================================================================*
//				 * ====================================ʱ����ж��㷨=====================================*
//				 * ==================================================================================*
//				 */
//				if(endTime<11){
//					//11��ǰ��������
//					System.out.println(spotName + ":" +startTime + " endTime<11 " + endTime);
//					SuggestModel suggestModel = new SuggestModel();
//					suggestModel.setSpotModel(spotModel);
//						value.put("11��ǰ��������ľ��㣺"+spotModel.getSpotName(), suggestModel);
//						//�����ν���ʱ��+1Сʱ����Ϊ�´εĿ�ʼʱ��
//						startTime = endTime +1;
//						map.put("��"+(m+1)+"��", value);
//						continue;
//						
//				}
//				else if (endTime >= 11 && endTime<=13) {
//					//11-13��֮��������棬���ž��㡢�͹ݡ��̵�
//					//�����ж��Ƿ���Ը���id��ȡ�͹����ݣ����Ի�ȡ��������Ĳ͹���Ϣ��������ʾ��������͹���Ϣ��
//					System.out.println(spotName + ":" +startTime + " endTime >= 11 && endTime<=13 " + endTime);
//					if(IsGetRestaurant(spotModel.getId())){
//						RestaurantModel restaurantModel = getShortestRestaurant(spotModel.getId());
//						
//						SuggestModel suggestModel = new SuggestModel();
//						suggestModel.setRestaurantModel(restaurantModel);
//						suggestModel.setSpotModel(spotModel);
//						value.put("11-13��֮��������棬���ž��㡢�͹ݣ�"+spotModel.getSpotName(), suggestModel);
//						startTime = endTime +1;		
//						map.put("��"+(m+1)+"�죺", value);
//						continue;
//						
//					}else{
//						System.out.println("����"+String.valueOf(spotModel.getSpotName())+"������͹���Ϣ");
//					}
//
//				} 
//				else if (endTime >= 13) {
//					//13���Ժ���������簲�ž��㡢����Ĳ͹ݡ�������ùݡ�������̵�
//					System.out.println(spotName + ":" +startTime + " endTime >= 13 " + endTime);
//					if ((spotTime[1] - startTime < 1 ) || startTime > spotTime[1]) {
//						//��������ʱ�䣨����չ�ʱ��-��ʼ����ʱ�䣩����1��Сʱ ���� ��ʼ����ʱ�� �� �չ�ʱ��֮�������þ���
//						continue;
//					}
////					//��ȡ��ǰ����Ľ�������ʱ��
////					suggestTime=suggestTime(spotModel.getSpotSuggestTime());
////					
//					if(IsGetRestaurant(spotModel.getId()) && IsGetHotel(spotModel.getId()) && IsGetShop(spotModel.getId()) ){
//						//�͹ݣ��Ƶ꣬�̵궼���Ի�ȡ��
//						SuggestModel suggestModel = new SuggestModel(spotModel,getShortestRestaurant(spotModel.getId()),getShortestHotel(spotModel.getId()),getShotestShop(spotModel.getId()));
//						value.put("13���Ժ�����ľ��㡢�͹ݡ��Ƶꡢ�̵꣺"+spotModel.getSpotName(), suggestModel);
//						map.put("��"+(m+1)+"��",value);
//					}else{
//						System.out.println("����"+String.valueOf(spotModel.getSpotName()+ "���Ƽ�·��"));
//					}
//					
//					break;			//����������г�
//				}
				
//			}//for(int j = k;j < models.getSpotModels().size();j++)
		
	}
	
	private float[] createKaiFangTime(String kaifangshijian) {
		float[] tempTime = {0,24};
		if (kaifangshijian.equals("ȫ��")) {
			
		} else {
			
			//�ַ����ָ��8��30-16��00 �ָ�Ϊ8 30 16 00
			String[] temp = kaifangshijian.split("[��:-]");
			//��"��"ת���ɡ�Сʱ��
			tempTime[0] = (new Float(temp[0])).floatValue() + ((new Float(temp[1])).floatValue())/60;
			tempTime[1] = (new Float(temp[2])).floatValue() + ((new Float(temp[3])).floatValue())/60;
		}
		return tempTime;	
	}
	private float suggestTime(String suggestTime) {
		float tempTime = 0;
		if (suggestTime == null) {
			System.out.println("����ʱ��Ϊ��");
		}else {
			tempTime = (new Float(suggestTime)).floatValue();
		}
		return tempTime;
	}
	//��ȡ����Ĳ͹�
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
		//���Ȳ��ҳ������Ӧ�Ĳ͹���Ϣ��Ȼ����ݲ͹���Ϣ���ҳ��Ƶ���Ϣ���������������̵ľƵꡣ
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
		//���ݾ��������ʱ�����ж��������о�������Ҫ���������������������Ŵ���map��
		int days = 1;
		float startTime = 9;
		float suggestTime=0;
		float endTime=startTime+suggestTime;

		
		for(int j = 0;j < models.getSpotModels().size();j++){
			Map<String,SuggestModel> value = new HashMap<>();
			SpotModel spotModel = models.getSpotModels().get(j);
			String spotName = spotModel.getSpotName();
			
			float[] spotTime = createKaiFangTime(spotModel.getSpotTime());
			//�����ʼ����ʱ�����ڿ���ʱ�䣬�����㿪��ʱ����Ϊ��ʼ����ʱ��
			if ( startTime<spotTime[0]) {
				startTime = spotTime[0];
			}
			suggestTime = suggestTime(spotModel.getSpotSuggestTime());
			//�����ʼ����ʱ��+��������ʱ��>=����չ�ʱ�䣬������չ�ʱ����Ϊ ��������ʱ��
			if(startTime+suggestTime>=spotTime[1]){
				endTime=spotTime[1];
			}else{//�����ʼ����ʱ��+��������ʱ��<����չ�ʱ�䣬�� ��ʼ����ʱ��+��������ʱ�� ��Ϊ ��������ʱ��
				endTime = startTime + suggestTime;
			}
			
			/*===================================================================================*
			 * ====================================ʱ����ж��㷨=====================================*
			 * ==================================================================================*
			 */
			if(endTime<11){
				//11��ǰ��������
				System.out.println(spotName + ":" +startTime + " endTime<11 " + endTime);
				SuggestModel suggestModel = new SuggestModel();
				suggestModel.setSpotModel(spotModel);
				suggestModel.CalculatePrice();
				System.out.println("price" + suggestModel.getPrice());
				
				value.put("11", suggestModel);//��ʾ11��ǰ��������ľ��㣬����
				//�����ν���ʱ��+1Сʱ����Ϊ�´εĿ�ʼʱ��
				startTime = endTime +1;
				map.put(""+days, value);
//				Needrevise = true;
				continue;
					
			}
			else if (endTime >= 11 && endTime<=13) {
				//11-13��֮��������棬���ž��㡢�͹ݡ��̵�
				//�����ж��Ƿ���Ը���id��ȡ�͹����ݣ����Ի�ȡ��������Ĳ͹���Ϣ��������ʾ��������͹���Ϣ��
				System.out.println(spotName + ":" +startTime + " endTime >= 11 && endTime<=13 " + endTime);
				if(IsGetRestaurant(spotModel.getId())){
					RestaurantModel restaurantModel = getShortestRestaurant(spotModel.getId());
					
					SuggestModel suggestModel = new SuggestModel();
					suggestModel.setRestaurantModel(restaurantModel);
					suggestModel.setSpotModel(spotModel);
					suggestModel.CalculatePrice();
					System.out.println("price" + suggestModel.getPrice());
					
					value.put("12", suggestModel);//��ʾ11-13��֮��������棬��Ҫ���ž��㡢�͹�
					startTime = endTime +1;		
					map.put(""+days, value);
//					Needrevise = true;
					continue;
					
				}else{
					System.out.println("����"+String.valueOf(spotModel.getSpotName())+"������͹���Ϣ");
				}

			} 
			else if (endTime >= 13) {
				//13���Ժ���������簲�ž��㡢����Ĳ͹ݡ�������ùݡ�������̵�
				System.out.println(spotName + ":" +startTime + " endTime >= 13 " + endTime);
				if ((spotTime[1] - startTime < 1 ) || startTime > spotTime[1]) {
					//��������ʱ�䣨����չ�ʱ��-��ʼ����ʱ�䣩����1��Сʱ ���� ��ʼ����ʱ�� �� �չ�ʱ��֮�������þ���
					continue;
				}
//				//��ȡ��ǰ����Ľ�������ʱ��
//				suggestTime=suggestTime(spotModel.getSpotSuggestTime());
//				
				if(IsGetRestaurant(spotModel.getId()) && IsGetHotel(spotModel.getId()) && IsGetShop(spotModel.getId()) ){
					//�����Ƽ��ľ��㣬�͹ݣ��Ƶ꣬�̵궼���Ի�ȡ������ʱ������Ҫ+1���Ҳ�����������
					SuggestModel suggestModel = new SuggestModel(spotModel,getShortestRestaurant(spotModel.getId()),getShortestHotel(spotModel.getId()),getShotestShop(spotModel.getId()));
					suggestModel.CalculatePrice();
					System.out.println("price" + suggestModel.getPrice());
					value.put("13", suggestModel);//��ʾ13���Ժ��������Ҫ���ŵľ��㡢�͹ݡ��Ƶꡢ�̵�
					map.put(""+days,value);
					days++;
//					Needrevise = false;
				}else{
					//�������Ƽ��ľ��㣬
					System.out.println("����"+String.valueOf(spotModel.getSpotName()+ "���Ƽ�·��"));
				}
				
				
				//�ָ����ڶ���ĳ�ʼֵ
				startTime = 9;
				suggestTime=0;
				endTime=startTime+suggestTime;
				
				
//				break;			//����������г�
			}
	
		}
//		if(Needrevise){
//			days++;
//		}
		
		System.out.println("retrun m :"+days);
		return days;
	}//RecordPath()
}
