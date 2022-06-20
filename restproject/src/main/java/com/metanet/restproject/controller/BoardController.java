package com.metanet.restproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.restproject.dto.Article;

@RestController
public class BoardController {
	//ResponseEntity<> : 실제 데이터와 전송 결과 정보를 함께 보낼 수 있는 객체
	//RequestBody : json 형식으로 넘어오는 데이터를 매칭되는 객체로 생성해줌
	
	@PostMapping("/boards")
	public ResponseEntity<String> addArticle(@RequestBody Article article){
		ResponseEntity<String> result = null;
		try {
			System.out.println(article);
			result = new ResponseEntity<String>("새 글 등록 성공", HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	@GetMapping("/boards/{articleNo}")
	//@RequestMapping(value="/boards/{articleNo}", method=RequestMethod.GET)
	public ResponseEntity<Article> findArticle(@PathVariable("articleNo") Integer articleNo){
		//articleNo로 DB에서 조회
		Article article = new Article();
		article.setArticleNo(articleNo);
		article.setWriter("김연아");
		article.setTitle("동계 올림픽");
		article.setContent("피겨여왕의 일상");
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@PutMapping("/boards/{articleNo}")
	//@RequestMapping(value="/boards/{articleNo}", method=RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNo") Integer articleNo,
			@RequestBody Article article){
		try {
			//DB에서 articleNo로 검색하여 article로 수정한다.
			System.out.println(article);
			return new ResponseEntity<String>("글 수정 성공", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	
		}
	}	
	
	@DeleteMapping("/boards/{articleNo}")
	public ResponseEntity<String> deleteArticle(@PathVariable("articleNo") Integer articleNo){
		System.out.println(articleNo);
		//DB에서 articleNo로 검색하여 삭제
		return new ResponseEntity<String>("글 삭제 성공", HttpStatus.OK);
	}
}
