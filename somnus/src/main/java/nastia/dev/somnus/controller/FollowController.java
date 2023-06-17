//package nastia.dev.somnus.controller;
//
//
//import nastia.dev.somnus.model.Follow;
//import nastia.dev.somnus.service.FollowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/follow")
//public class FollowController {
//
//    @Autowired
//    public FollowService followService;
//
//    @GetMapping("all")
//    public List<Follow> getAllFollow(){
//        return followService.getAllFollow();
//    }
//
//    @PostMapping("add/{followerID}/{followingID}")
//    public Follow addFollow(@PathVariable Long followerID, @PathVariable Long followingID) {
//        return null;
//    }
//}
