package com.hp.controller;

import com.hp.bean.Cat;
import com.hp.bean.Goodfirend;
import com.hp.bean.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lxy")
public class LoginController {
    //  1.k-v 结构或者对象  实体类收参数  2、收参----对象
    @RequestMapping("/a1")
    public Map a1(Login login){
        System.out.println("login = " + login);
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","实体类收参成功！");
        return codeMap;
    }
    //3、 集合或数组的接收参数
    @RequestMapping("/a3")
    @ResponseBody
    public Map a3(@RequestParam("names[]") List<String> names){
        for (String name : names) {
            System.out.println("name = " + name);
        }
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功！");
        codeMap.put("data",names);
        return codeMap;
    }

    //4、接收 传json对象
    @RequestMapping("/a4")
    @ResponseBody
    public Map a4(@RequestBody Login login){
        System.out.println("login = " + login);
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功！");
        codeMap.put("data",login);
        return codeMap;
    }
    //5、接收 多个对象
    @InitBinder("goodfirend")
    public void binding01(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("goodfirend.");
    }
    @InitBinder("cat")
    public void binding02(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("cat.");
    }

    @RequestMapping("/a5")
    @ResponseBody
    public Map a5(@ModelAttribute Goodfirend goodfirend, @ModelAttribute Cat cat){
        System.out.println("goodfirend = " + goodfirend);
        System.out.println("cat = " + cat);
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功！");
        codeMap.put("data1",goodfirend);
        codeMap.put("data2",cat);
        return codeMap;
    }

    //6、多个对象批量传参 +json
    @RequestMapping("/a6")
    @ResponseBody
    public Map a6(@RequestBody List<Goodfirend> goodfirendList){
        for (Goodfirend goodfirend : goodfirendList) {
            System.out.println("goodfirend = " + goodfirend);
        }
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功！");
        codeMap.put("data",goodfirendList);
        return codeMap;
    }

    //7、map传参   翻版的第一种  不常用，要会 map+json 常用  用json 必须使用  @RequestBody
    @RequestMapping("/a7")
    @ResponseBody
    public Map a7(@RequestBody Map map){
        System.out.println("map = " + map);
        Map codeMap=new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功！");
        codeMap.put("data",map);
        return codeMap;
    }

    // 8、对象——常用类型 混合 常见于 分页  ajax08
    @RequestMapping("/a8")
    @ResponseBody
    public Map a8(Goodfirend goodfirend, @RequestParam(value = "limit",required = false,defaultValue = "5") Integer pageSize, Integer page){
        return null;
    }

    // 以上是接收参数的 八种方式

    //以下是传值的 5种方式
    //1.原生方式
    @RequestMapping("/demo1")
    public String demo1(HttpSession session, HttpServletRequest request){
        System.out.println(" 原生的方式来传值===" );
        String lname=request.getParameter("lname");
        String pwd=request.getParameter("pwd");
        request.setAttribute("lname",lname);
        request.setAttribute("pwd",pwd);
        //return "rediect:/pages/home.jsp";
        return "home";
    }

    //2.modelAndView 传值
    @RequestMapping("/demo2")
    public ModelAndView demo2(Login login){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("lname",login.getLname());
        modelAndView.addObject("pwd",login.getPwd());
        System.out.println("modelAndView = " + modelAndView);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    // 3： model 传值
    @RequestMapping("/demo3")
    public String model(Login login, Model model){
        model.addAttribute("lname",login.getLname());
        model.addAttribute("pwd",login.getPwd());
        return "home";
    }

    //4: modelAndMap 传值
    @RequestMapping("/demo4")
    public String demo4(Login login, ModelMap modelMap){
        modelMap.put("lname",login.getLname());
        modelMap.put("pwd",login.getPwd());
        return "home";
    }

    //5: map 传值
    @RequestMapping("/demo5")
    public String demo5(Login login,Map<String, Object> map) {
        map.put("lname", login.getLname());
        map.put("pwd", login.getPwd());
        return "home";
    }
}
