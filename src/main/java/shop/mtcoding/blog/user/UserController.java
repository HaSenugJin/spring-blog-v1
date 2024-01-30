package shop.mtcoding.blog.user;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * 컨트롤러의 책임
 * 1. 요청받기 (URL) I = 아이덴티파이, L = 로케이션
 * 2. http body (데이터)는 DTO로 받음
 * 3. 기본 mime 전략 : x-www-form-urlencoded (username=ssar&password=1234)
 * 4. 유효성 검사하기 (body 데이터가 있다면)
 * 5. 클라이언트가 view만 원하는지? 혹은 DB 처리 후 view도 원하는지?
 * 6. view만 원하면 view를 응답하면 끝
 * 7. DB처리를 원하면 Model(DAO)에게 응답하고 view를 응답하면 끝
 */

@Controller
public class UserController {

    // 의존성 주입
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 로그인만 select 요청할 때 post매핑함
    // 다른 select 요청은 Get
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        // 1. 유효성 검사하기
        if (requestDTO.getUsername().length() < 3) {
            return "error/400";
        }

        // 2. 모델 연결 select * from user_tb where username=? and password=?
        User user = userRepository.findByUsernameAndPassword(requestDTO);

        System.out.println(user);

        // 3. 응답 (index)
        return "redirect:/";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {

        // 1. 유효성 검사하기
        if (requestDTO.getUsername().length() < 3) {
            return "error/400";
        }

        // 2. Model에게 DB처리 위임하기
        userRepository.saveV2(requestDTO); // 의존성 주입해야함


        System.out.println(requestDTO);

        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
