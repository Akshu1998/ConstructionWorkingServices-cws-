package study.springboot.cws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.springboot.cws.Entity.ReviewEntity;
import study.springboot.cws.repository.ReviewRepository;

@RestController
@RequestMapping("cws/Review")
public class ReviewController {

	
	@Autowired  
	ReviewRepository reviewrepo;
	
	
	@GetMapping("/getAllReviews")
	public List<ReviewEntity> getReviews()
	{
		return reviewrepo.findAll();
	}
	
	@PostMapping("/addReview")
	public String addReview(@RequestBody ReviewEntity r)
	{
		ReviewEntity rev = new ReviewEntity(r.getId(),r.getCustomerId(),r.getBookingId(),
				r.getProviderId(),r.getReviewComment(),r.getReviewRating());
		reviewrepo.save(rev);
		return "review Added";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteReview(@PathVariable int id)
	{
		 reviewrepo.deleteById(id);
		 return "review Deleted";
	}
	
}
