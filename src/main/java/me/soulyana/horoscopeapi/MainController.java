package me.soulyana.horoscopeapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    BirthdateRepository birthdateRepository;

    @RequestMapping("/add")
    public String birthdateForm(Model model) {
        model.addAttribute("birthdate", new Birthdate());
        return "birthdateform";
    }

    @PostMapping("/process")
    public String processBirthdateForm(@Valid @ModelAttribute("birthdate") Birthdate birthdate, BindingResult result) {
        if(result.hasErrors()) {
            return "birthdateform";
        }
        birthdateRepository.save(birthdate);
        if((birthdate.getMonth().equalsIgnoreCase("january") && birthdate.getDate() > 20) ||
                (birthdate.getMonth().equalsIgnoreCase("february") && birthdate.getDate() < 18)) {
            return "redirect:/showtodayhoroscope/aquarius";
        } else if((birthdate.getMonth().equalsIgnoreCase("february") && birthdate.getDate() > 18) ||
                (birthdate.getMonth().equalsIgnoreCase("march") && birthdate.getDate() < 20)) {
            return "redirect:/showtodayhoroscope/pisces";
        } else if((birthdate.getMonth().equalsIgnoreCase("march") && birthdate.getDate() > 21) ||
                (birthdate.getMonth().equalsIgnoreCase("april") && birthdate.getDate() < 19)) {
            return "redirect:/showtodayhoroscope/aries";
        } else if((birthdate.getMonth().equalsIgnoreCase("april") && birthdate.getDate() > 20) ||
                (birthdate.getMonth().equalsIgnoreCase("may") && birthdate.getDate() < 20)) {
            return "redirect:/showtodayhoroscope/taurus";
        } else if((birthdate.getMonth().equalsIgnoreCase("may") && birthdate.getDate() > 21) ||
                (birthdate.getMonth().equalsIgnoreCase("june") && birthdate.getDate() < 20)) {
            return "redirect:/showtodayhoroscope/gemini";
        } else if((birthdate.getMonth().equalsIgnoreCase("june") && birthdate.getDate() > 21) ||
                (birthdate.getMonth().equalsIgnoreCase("july") && birthdate.getDate() < 22)) {
            return "redirect:/showtodayhoroscope/cancer";
        } else if((birthdate.getMonth().equalsIgnoreCase("july") && birthdate.getDate() > 23) ||
                (birthdate.getMonth().equalsIgnoreCase("august") && birthdate.getDate() < 22)) {
            return "redirect:/showtodayhoroscope/leo";
        } else if((birthdate.getMonth().equalsIgnoreCase("august") && birthdate.getDate() > 23) ||
                (birthdate.getMonth().equalsIgnoreCase("septemeber") && birthdate.getDate() < 22)) {
            return "redirect:/showtodayhoroscope/virgo";
        } else if((birthdate.getMonth().equalsIgnoreCase("september") && birthdate.getDate() > 23) ||
                (birthdate.getMonth().equalsIgnoreCase("october") && birthdate.getDate() < 22)) {
            return "redirect:/showtodayhoroscope/libra";
        } else if((birthdate.getMonth().equalsIgnoreCase("october") && birthdate.getDate() > 23) ||
                (birthdate.getMonth().equalsIgnoreCase("november") && birthdate.getDate() < 21)) {
            return "redirect:/showtodayhoroscope/scorpio";
        } else if((birthdate.getMonth().equalsIgnoreCase("november") && birthdate.getDate() > 22) ||
                (birthdate.getMonth().equalsIgnoreCase("december") && birthdate.getDate() < 21)) {
            return "redirect:/showtodayhoroscope/sagittarius";
        } else if((birthdate.getMonth().equalsIgnoreCase("december") && birthdate.getDate() > 22) ||
                (birthdate.getMonth().equalsIgnoreCase("january") && birthdate.getDate() < 19)) {
            return "redirect:/showtodayhoroscope/capricorn";
        }

        return "redirect:/";
    }

    @RequestMapping("/")
    public String showBirthdate(Model model) {
        model.addAttribute("birthdates", birthdateRepository.findAll());
        return "list";

    }
    @RequestMapping("/showtodayhoroscope/{sunsign}")
    public @ResponseBody String showIndex(@PathVariable ("sunsign") String sunsign) {
        RestTemplate restTemplate = new RestTemplate();
        Horoscope horoscope = restTemplate.getForObject("http://horoscope-api.herokuapp.com/horoscope/today/"+sunsign, Horoscope.class);
        return horoscope.toString();
    }
}
