package shop.mtcoding.blog.user;

import lombok.Data;

/**
 * 요청 DTO : Data Transfer Object
 * 데이터를 전송하는 오브젝트
 * 이렇게 하면 관리하기 편함
 */
public class UserRequest {

    @Data // get, set, ToString 다 들고있음
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }
}
