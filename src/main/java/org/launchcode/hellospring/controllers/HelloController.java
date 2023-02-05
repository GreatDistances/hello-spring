package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return "<html>" +
                "<body>" +
                "<h1>" + createMessage(name, language) + "</h1>" +
                "</body>" +
                "</html>";
        //return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<label for='language-select'> Choose a language: </label>" +
                "<select id='language' name='language' path='language'>" +
                    "<optgroup label='Asia'>" +
                        "<option value='japanese'>Japanese</option>" +
                        "<option value='korean'>Korean</option>" +
                        "<option value='hindi'>Hindi</option>" +
                        "<option value='khmer'>Khmer</option>" +
                        "<option value='burmese'>Burmese</option>" +
                    "<optgroup label='Africa'>" +
                        "<option value='amharic'>Amharic</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {

        String greeting = "";
        if (language.equals("japanese")) {
            greeting = "こんにちは";
        } else if (language.equals("korean")) {
            greeting = "안녕하세요";
        } else if (language.equals("hindi")) {
            greeting = "नमस्ते";
        } else if (language.equals("burmese")) {
            greeting = "မင်္ဂလာပါ";
        } else if (language.equals("khmer")) {
            greeting = "សួស្តី";
        } else if (language.equals("amharic")) {
            greeting = "ሀሎ";
        } else {
            greeting = "Hello";
        }
        return greeting + ", " + name + "!";
    }
}






    /*
    // Handles request at path /hello
    *//*
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }
    *//*

    // Handles request at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping ("1{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hi' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hi")
    @ResponseBody
    public String hiWithQueryParam(@RequestParam String name) {
        return "Hi, " + name + "!";
    }
    @GetMapping("form2")
    @ResponseBody
    public String hiForm() {
        return "<html>" +
                "<body>" +
                "<form action='hi' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
*/

