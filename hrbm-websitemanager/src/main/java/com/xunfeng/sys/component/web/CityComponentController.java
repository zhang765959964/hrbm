package com.xunfeng.sys.component.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.component.model.City;
import com.xunfeng.sys.component.repository.CityRepository;
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;

/**
 * Created by wxl on 2015/7/31.
 */
@Controller
@RequestMapping("/city/")
public class CityComponentController extends BaseController {
	@Resource
	@Qualifier("baseConfig")
	private BaseConfigServiceInterf baseConfigService;
    /**
     * 1.获取热门城市
     * 2.获取省份 PID=0
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String defaultCode=RequestUtil.getString(request,"defaultCode");
        String targetId=RequestUtil.getString(request,"targetId");
        
        ModelAndView mv  = new ModelAndView("/sys/component/city/index.jsp"); 
        List<City>  provincesList=CityRepository.getProvincesList();
        String defaultCityAreaCode = baseConfigService.getConfigByName("AddreID").getCaos04();
        String defaultCityAreaName = baseConfigService.getConfigByName("AddreName").getCaos04();
        City city = CityRepository.getCityByCode(defaultCityAreaCode);
        List<City> defaultAreaList = CityRepository.getCityList(city.getId());
        mv.addObject("provincesList",provincesList)
        .addObject("defaultAreaList",defaultAreaList)
        .addObject("defaultCityAreaName",defaultCityAreaName)
        .addObject("defaultCode",defaultCode).addObject("targetId", targetId);
        return mv;
    }
    @RequestMapping("city-json")
    @ResponseBody
    public Object cityJson(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Long pId = RequestUtil.getLong(request, "pId");
        List<City> provincesList = CityRepository.getCityList(pId);
        return provincesList;
     }
    @RequestMapping("my-city")
    @ResponseBody
    public Object myCity(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String code = RequestUtil.getString(request, "code");
        City citie=  CityRepository.getCityByCode(code);
        return citie;
    }
}
