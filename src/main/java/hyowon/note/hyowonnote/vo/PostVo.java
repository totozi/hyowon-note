package hyowon.note.hyowonnote.vo;

import lombok.Data;

@Data
public class PostVo {

    private int    POST_NO;
    private String AUTHOR;
    private int    VIEW_CNT;
    private int    CATEGORY_NO;
    private String TITLE;
    private String CONTENT;
    private char   STATUS;
    private String FIRST_REG_DATETIME;
    private String LAST_UPD_DATETIME;
    private String FIRST_REG_IP;
    private String LAST_UPD_IP;
    
    
}
