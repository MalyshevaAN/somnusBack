package nastia.dev.somnus.service;


import nastia.dev.somnus.model.Comment;
import nastia.dev.somnus.model.Dream;
import nastia.dev.somnus.model.User;
import nastia.dev.somnus.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;
    @Autowired
    DreamService dreamService;

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId){
        return commentRepository.findById(commentId).get();
    }


    public Comment assignPostAuthor(Long commentId, Long dreamId, Long authorId){
        Comment comment  = commentRepository.findById(commentId).get();
        Dream dream  = dreamService.getDreamById(dreamId);
        User author  = userService.getUserById(authorId);
        comment.setAuthor(author);
        comment.setDreamComment(dream);
        return commentRepository.save(comment);
    }
}
