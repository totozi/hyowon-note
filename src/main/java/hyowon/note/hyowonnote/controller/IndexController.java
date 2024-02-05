package hyowon.note.hyowonnote.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller("/")
public class IndexController {
    
    @GetMapping("")
    public String getIndexPage() {
        System.out.println("Hello World!");
        return "index.html";
    }

    @GetMapping("/test")
    public String getTestPage(@RequestParam int POST_NO) {

        //List<PostVo> list = postService.select_single_list();

        System.out.println("POST_NO = " + POST_NO);
        
        return "post/post_select.html";
    }

}
