package hyowon.note.hyowonnote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hyowon.note.hyowonnote.dao.PostDao;
import hyowon.note.hyowonnote.vo.PostVo;

@Service
public class PostService {
    
    @Autowired
    private PostDao postDao;


        public PostVo select_single_list(PostVo postVo)
        {
            return postDao.select_single_post(postVo);

        }


        public List<PostVo> select_list(int limit, int offset)
        {
            return postDao.select_list(limit, offset);
        
        }
}
