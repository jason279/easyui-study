package self.jason.study.easyui.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.Data;
import self.jason.study.easyui.entity.User;
import self.jason.study.easyui.repository.UserRepository;

@Service
@Data
public class UserService {
	private final UserRepository userRepository;

	public List<User> findAll() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Page<User> findAll(int page, int size){
		return userRepository.findAll(PageRequest.of(page, size));
	}
}
