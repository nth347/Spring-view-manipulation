package com.nth347.springviewmanipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Spring view manipulation");
        return "index";
    }

    @GetMapping("/main-fragment")
    public String mainFragment(Model model) {
        model.addAttribute("message", "Spring view manipulation");
        return "index :: main";
    }

    // ----------------------------------------------------------------------------------------------------------------

    @GetMapping("/user/profile")
    public String path(Model model, @RequestParam String lang) {
        model.addAttribute("name", "Nguyen Nguyen Nguyen");
        return "user/" + lang + "/profile";
    }

    @GetMapping("/custom-fragment")
    public String customFragment(@RequestParam String fragment) {
        return "index :: " + fragment;
    }

    // ----------------------------------------------------------------------------------------------------------------

    @PostMapping("/user/profile")
    public String post(Model model, @RequestParam String lang) {
        model.addAttribute("name", "Nguyen Nguyen Nguyen");
        return "user/" + lang + "/profile";
    }

    @GetMapping("/user/{id}")  // Hard to detect by black-box approach, there are no differences between responses
    public void noReturn(@PathVariable String id) {
        Logger logger = LoggerFactory.getLogger(MainController.class);
        logger.info("/user/" + id + "is requested");
    }

    @GetMapping("/custom-page/{page}") // Hard to detect by Burp scanner, it does not scan path variables
    public String customPage(@PathVariable String page) {
        return page;
    }

    // ----------------------------------------------------------------------------------------------------------------

    @GetMapping("/safe/fragment")
    @ResponseBody
    public String safeFragment(@RequestParam String fragment) {
        return "welcome :: " + fragment;
    }

    @GetMapping("/safe/redirect")
    public String redirect(@RequestParam String url) {
        return "redirect:" + url;
    }
}
