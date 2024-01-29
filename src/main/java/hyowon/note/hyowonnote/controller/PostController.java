package hyowon.note.hyowonnote.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hyowon.note.hyowonnote.service.PostService;
import hyowon.note.hyowonnote.vo.PostVo;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/single_select_post")
    public ResponseEntity<PostVo> select_single_post(@RequestBody Map<String, Object> requestBody) {
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
    
}
