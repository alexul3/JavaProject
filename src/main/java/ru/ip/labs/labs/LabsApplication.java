package ru.ip.labs.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class LabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
	}
	int getDegree(int x, int y) {
		if(y == 1) return x;

		int res = getDegree(x, y / 2);
		res *= res;
		if(y % 2 != 0) res *= x;

		return res;
	}
	@GetMapping("/sum")
	public int sum(@RequestParam int x, @RequestParam int y) {
		return x + y;
	}
	@GetMapping("/diff")
	public int diff(@RequestParam int x, @RequestParam int y) {
		return x - y;
	}
	@GetMapping("/multiply")
	public double multiply(@RequestParam double x, @RequestParam double y) {
		return x * y;
	}
	@GetMapping("/divide")
	public double divide(@RequestParam double x, @RequestParam double y) {
		return x / y;
	}

	@GetMapping("/degree")
	public int degree(@RequestParam int x, @RequestParam int y) {
		return getDegree(x, y);
	}
}
