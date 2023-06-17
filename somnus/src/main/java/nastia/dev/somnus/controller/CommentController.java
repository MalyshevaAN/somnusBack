package nastia.dev.somnus.controller;


import nastia.dev.somnus.model.Comment;
import nastia.dev.somnus.model.User;
import nastia.dev.somnus.repository.CommentRepository;
import nastia.dev.somnus.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("add")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("all")
    public List<Comment> getAll(){
        return commentService.getAllComments();
    }


    @PutMapping("{commentId}/post/{dreamId}/author/{authorId}")
    public Comment addPostAuthor(@PathVariable Long commentId, @PathVariable Long dreamId, @PathVariable Long authorId){
        return commentService.assignPostAuthor(commentId, dreamId, authorId);
    }
}
