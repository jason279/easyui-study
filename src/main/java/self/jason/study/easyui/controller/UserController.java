package self.jason.study.easyui.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;
import self.jason.study.easyui.Paging;
import self.jason.study.easyui.entity.User;
import self.jason.study.easyui.service.UserService;

@Controller
@Data
public class UserController {
	private final UserService userService;

	@RequestMapping("/crud")

	public String crud(Model model) {
		return "crud";
	}

	@GetMapping("/getUsers")
	@ResponseBody
	public Paging<User> getUsers(@RequestParam int page, @RequestParam("rows") int size) {
		Paging<User> userPaging = new Paging<>();
		Page<User> users = userService.findAll(page - 1, size);
		userPaging.setTotal(users.getTotalElements());
		userPaging.setRows(users.getContent());
		Map<String, Object> footer = new HashMap<>();
		footer.put("name", "xxx");
		footer.put("price", 14);
		userPaging.setFooter(Arrays.asList(footer));
		System.out.println(userPaging);
		return userPaging;

	}

}
