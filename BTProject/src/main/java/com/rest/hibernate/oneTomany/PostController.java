package com.rest.hibernate.oneTomany;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	
	/*@GetMapping("/post")
	public Page<Post> getAllPost(Pageable pageable){
		return postRepository.findAll(pageable);
	}*/
	
	@GetMapping("/post")
	public List<Post> getAllpost(){
		return postRepository.findAll();
	}
	
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody Post post){
//		post.getComment().add(new Comment("Hi...How are you"));
//		post.getComment().add(new Comment("I am fine. Thank you"));
		return postRepository.save(post);
	}
	
	
	@PutMapping("/post/{postId}")
	public Post updatePost(@PathVariable Long postId,@Valid @RequestBody Post postrequest){
		return postRepository.findById(postId).map(post->{
			post.setTitle(postrequest.getTitle());
			post.setDescription(postrequest.getDescription());
			post.setContent(postrequest.getContent());
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}
	
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId){
		
		return postRepository.findById(postId).map(post->{
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("Post Id: "+postId+" Not Found"));
	}
	
	
}
