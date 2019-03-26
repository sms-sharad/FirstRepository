package com.rest.hibernate.oneTomany;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/comment/{postId}")
	public Page<Comment> getAllCommentByPost(@PathVariable Long postId, Pageable pageable){
		return commentRepository.findByPostId(postId, pageable);
	}
	
	
	@PostMapping("/comment/{postId}/comments")
	public Comment createComment(@PathVariable Long postId,@Valid @RequestBody Comment comment){
		
		return postRepository.findById(postId).map(post->{
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(()->new ResourceNotFoundException("Post Id: "+postId+" Not Found"));
	}
	
	@PutMapping("/comment/{postId}/comments/{commentId}")
	public Comment updateComment(@PathVariable Long postId, @PathVariable Long commentId,@Valid @RequestBody Comment commentRequest){
		if(!postRepository.existsById(postId)){
			throw new ResourceNotFoundException("PostId "+postId+" not found");
		}
		return commentRepository.findById(commentId).map(comment->{
			comment.setText(commentRequest.getText());
			return commentRepository.save(comment);
		}).orElseThrow(()->new ResourceNotFoundException("PostId :"+postId+" not found"));
	}
	
	
	
	
	
}
