package hyowon.note.hyowonnote.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hyowon.note.hyowonnote.service.PostService;
import hyowon.note.hyowonnote.vo.PostVo;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post_list")
    public ResponseEntity<List<PostVo>> select_post(@RequestBody Map<String, Object> requestBody) 
    {
        
        System.out.println(requestBody);

        int page_no = 1;

        try {
            page_no = Integer.parseInt(requestBody.get("PAGE_NO").toString());
        } catch (Exception e) {
            page_no = 1;
        }

        
        int limit  = 10; // 한 페이지에 출력할 데이터의 양
        int offset = limit * ( page_no - 1 );    // LIMIT * (페이지 번호 - 1)
        List<PostVo> listPostVo = postService.select_list(limit, offset);

        System.out.println(listPostVo);


        return new ResponseEntity<>(listPostVo, HttpStatus.OK);
    }
    

    
    @PostMapping("/single_select_post")
    @ResponseBody
    public ResponseEntity<PostVo> select_single_post(@RequestBody Map<String, Object> requestBody) 
    {
        // 받은 게시글 데이터를 처리하고 필요에 따라 데이터베이스에 저장하는 로직을 추가할 수 있습니다.

        String postNoString = (String) requestBody.get("POST_NO");
        int postNo = Integer.parseInt(postNoString);

        //System.out.println("POST_NO : " + POST_NO);
       
        PostVo postVo = new PostVo();
        postVo.setPOST_NO(postNo);
        System.out.println("postVo : " + postVo);
        // 예시로 받은 데이터를 그대로 응답합니다.
        PostVo resultVo = postService.select_single_list(postVo);

        //System.out.println(resultVo);
        
        // 성공적인 응답을 반환합니다.
        return new ResponseEntity<>(resultVo, HttpStatus.OK);
    }

    @GetMapping("/insert")
    public String getMethodName()
    {
        System.out.println("post_insert");
        return "post_insert.html";
    }
    
    
}
