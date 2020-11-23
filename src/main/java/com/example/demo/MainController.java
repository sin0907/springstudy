package com.example.demo;

import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv){
		mv.addObject("name", "名前がここに入ります");
		mv.addObject("age", "年齢がここに入ります");
		mv.addObject("height", "身長がここに入ります");
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv,
		@RequestParam("nameVal")String name,
		@RequestParam("ageVal")String age,
		@RequestParam("heightVal")String height){
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.addObject("height", height);
		mv.setViewName("index");
		return mv;
	}

//ifの例題
	@RequestMapping(value="/if", method=RequestMethod.GET)
	public ModelAndView ifGet(ModelAndView mv){
		mv.addObject("suzuki", false);
		mv.setViewName("if");
		return mv;
	}
	@RequestMapping(value="/if", method=RequestMethod.POST)
	public ModelAndView ifPost(ModelAndView mv){
		mv.addObject("suzuki", true);
		mv.setViewName("if");
		return mv;
	}
	
//宿題
	@RequestMapping(value="/homework", method=RequestMethod.GET)
	public ModelAndView homeworkGet(ModelAndView mv){
		mv.addObject("math","階乗を計算します！");
		mv.setViewName("homework");
		return mv;
	}
	@RequestMapping(value="/homework", method=RequestMethod.POST)
	public ModelAndView homeworkPost(ModelAndView mv,
		@RequestParam("numbers")int number){
		//		計算式
		int total = 1;
	     for(int i=1; i<=number; i++) 
	    	 total*= i ;	    

		mv.addObject("math", number+"の階乗は"+total+"です");
		mv.setViewName("homework");
		return mv;
	}
	
//	@RequestMapping("/{name}")
//	public ModelAndView index(@PathVariable String name, ModelAndView mv){
//	mv.addObject("name", name);
//	mv.setViewName("index");
//	return mv;
//	}
//	@RequestMapping("/{num}")
//	public ModelAndView index(@PathVariable int num, ModelAndView mv){
//	String line="";
//	for(int i=0; i<num; i++) line+="あ";
//	mv.addObject("name", line);
//	mv.setViewName("index");
//	return mv;
//	}
//	課題
	@RequestMapping("/{num}")
	public ModelAndView prime(@PathVariable int num, ModelAndView mv){
	String line="";
		if (num < 2) {
			line+=num+"は、素数ではないです";	
	    }
		else if(num==2){		
			line+=num+"は、素数です";
		}      
//		boolean sosu=true;
		for(int i=2;i<num;i++){   
	        if(num%i==0)   {
	        	line=num+"は、素数ではないです";	
//	        	sosu=false;
	        	break;
	        }         
	        line=num+"は、素数です";
	  }
//		if(sosu){
////			line+=num+"は、素数です";	
//		}
//		else{		
//			line+=num+"は、素数ではないです";
//		}      
	    
	mv.addObject("name", line);
	mv.setViewName("prime");
	return mv;
	}
	
//	for
	@RequestMapping(value="/for")
	public ModelAndView forPost(ModelAndView mv){
	ArrayList<String[]> customers = new ArrayList<String[]>();
	customers.add(new String[] {"佐藤HTML太郎","35歳","男性","愛知県"});
	customers.add(new String[] {"鈴木Java五郎","24歳","男性","大阪府"});
	customers.add(new String[] {"高橋CSS子","29歳","女性","北海道"});
	customers.add(new String[] {"高橋じゃヴぁ子","29歳","女性","沖縄県"});
	customers.add(new String[] {"高橋CSS","29歳","女性","東京都"});
	mv.addObject("customers", customers);
	mv.setViewName("for");
	return mv;
	}	
		
		
	}
	


