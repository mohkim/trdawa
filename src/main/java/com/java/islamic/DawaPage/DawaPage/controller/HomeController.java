/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage.controller;

import com.java.islamic.DawaPage.DawaPage.entity.Comment;
import com.java.islamic.DawaPage.DawaPage.entity.Post;
import com.java.islamic.DawaPage.DawaPage.entity.User;
import com.java.islamic.DawaPage.DawaPage.service.CommentService;
import com.java.islamic.DawaPage.DawaPage.service.PostService;
import com.java.islamic.DawaPage.DawaPage.service.SubTopicService;
import com.java.islamic.DawaPage.DawaPage.service.TopicService;
import com.java.islamic.DawaPage.DawaPage.service.UserService;
import java.security.Principal;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author KEMAL
 */
@Controller
public class HomeController {

    @Autowired
    public UserService userService;
    @Autowired
    public TopicService topicService;
    @Autowired
    public SubTopicService subTopicService;
    @Autowired
    public PostService postService;
    @Autowired
    public CommentService commentService;
    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());

    @GetMapping("/")
    public String getHomePage(Model model) {

        model.addAttribute("topicList", topicService.getAllTopic());
        model.addAttribute("mostReadList", postService.findMostVisitedPost());
        model.addAttribute("LatestPostList", postService.findLatestPost());

        return "index";
    }

    @GetMapping("/showsub")
    public String getSubTopicPage(Model model, @RequestParam Long id) {

        model.addAttribute("subtopicList", subTopicService.getByTopicFK(id));
        model.addAttribute("topic", topicService.getTopic(id));

        return "home/subShow";
    }

    @GetMapping("/showPost")
    public String getShowPostList(Model model, @RequestParam Long id) {

        model.addAttribute("postList", postService.findbySubTopic(id));
        model.addAttribute("subtopic", subTopicService.getSubTopic(id));

        return "home/showPost";
    }

    @GetMapping("/showPostDetail")
    public String getShowPostDetail(Model model, @RequestParam Long id, Principal principal) {

        try {

            if (principal.getName() != null) {
                User user = userService.findByEmail(principal.getName());
                model.addAttribute("user_name", user.getFullName());
                model.addAttribute("comment", new Comment());
            }

        } catch (Exception e) {
        }

//        
        model.addAttribute("post", postService.findPost(id));
        model.addAttribute("commentList", commentService.getCommentListByPost(postService.findPost(id)));

        return "home/showPostDetail";
    }

    @PostMapping("/CommentSave")
    public String saveComment(Model model, Comment comment, @RequestParam Long id, Principal principal) {

        Post post = postService.findPost(id);
        comment.setUser(userService.findByEmail(principal.getName()));
        commentService.saveComent(comment);

        post.addComment(commentService.getCommentByUserAndContent(userService.findByEmail(principal.getName()), comment.getContent()));

        model.addAttribute("post", post);
        model.addAttribute("commentList", commentService.getCommentListByPost(postService.findPost(id)));
        model.addAttribute("comment", new Comment());
        model.addAttribute("user_name", (userService.findByEmail(principal.getName())).getFullName());

        postService.savePost(post);

        return "home/showPostDetail";

    }

    @GetMapping("/login")
    public String getLogin(Model model) {

        model.addAttribute("user", new User());

        return "user/login";
    }

    @GetMapping("/login2")
    @ResponseBody
    public  int  getLogin2(String email) {

        return userService.userDiabled(email);

    }
    
    
     @GetMapping("/about")
    public String getAboutPage(Model model) {

        return "home/about";
    }
    

}
