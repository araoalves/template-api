package br.com.template.business;

import java.util.List;

import br.com.template.model.User;

public interface IUserBO {

	List<User> recuperarUsers() throws Exception;

	User insertUser(User user) throws Exception;

	User getUserById(Integer id) throws Exception;

	Object updateUser(User user) throws Exception;

}
