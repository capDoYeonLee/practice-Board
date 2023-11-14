package tony.demo.comment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tony.demo.comment.dto.CommentDto;
import tony.demo.comment.service.CommentService;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/post/{id}/comment")
    public String list(@PathVariable("id") Model model) {
        List<CommentDto> commentDtoList = commentService.getCommentList();
        model.addAttribute("commentList", commentDtoList);
        return "redirect:/";
    }

    @PostMapping("post/{id}/comment")
    public String write(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        commentDto.setId(id);
        commentService.saveComment(commentDto);
        return "redirect:/";
    }

    @PutMapping("post/{id}/edit/comment")
    public String update(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        commentDto.setId(id);
        commentService.saveComment(commentDto);
        return "redirect:/";
    }
}
