package com.poly.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        System.out.println("hi");
        model.addAttribute("name","김가현");
        model.addAttribute("mail",50);
        return "greetings";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/randomQuote")
    public String randomQuoteMethod(Model model){
        String[] quotes={
                "느린 것을 두려워하지 말고, 중도에 멈추는 것을 두려워하라.",
                "만족할 줄 아는 사람은 항상 즐겁고, 참을 줄 아는 사람은 스스로 평온하다.",
                "미래를 결정할 수 있는 건 자기 자신일 뿐이다.",
                "비바람을 겪지 않고서 어떻게 무지개를 볼 수 있나.",
                "만족할 줄 아는 자는 항상 즐겁다."
        };
        int ranNum=(int)(Math.random() * 5);
        model.addAttribute("result",quotes[ranNum]);
        return "randomQuteView";
    }



}
