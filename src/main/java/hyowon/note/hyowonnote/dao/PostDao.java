package hyowon.note.hyowonnote.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hyowon.note.hyowonnote.vo.PostVo;

@Mapper
public interface  PostDao {

    PostVo select_single_post(PostVo postVo);
    
}
