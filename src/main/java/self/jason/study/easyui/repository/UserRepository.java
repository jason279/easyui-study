package self.jason.study.easyui.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import self.jason.study.easyui.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

}
