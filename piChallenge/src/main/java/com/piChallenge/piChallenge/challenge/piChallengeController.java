package com.piChallenge.piChallenge.challenge;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class piChallengeController {
    @RequestMapping(value = "/challenge", method=RequestMethod.POST)
    public static ModelAndView processPIView() {
        try {
            Solution m = new Solution();
            ModelAndView mv = new ModelAndView();
            mv.addObject("answer", m.giveAnswer());
            mv.setViewName("results");

            return mv;

        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }
}