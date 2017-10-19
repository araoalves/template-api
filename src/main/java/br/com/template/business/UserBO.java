package br.com.template.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.template.dao.IUserDAO;
import br.com.template.model.User;

@Component
public class UserBO implements IUserBO {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> recuperarUsers() throws Exception {
		return userDAO.recuperarUsers();
	}

	@Override
	public User insertUser(User user) throws Exception {
		return userDAO.insertUser(user);
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		return userDAO.getUserById(id);
	}

	@Override
	public User updateUser(User user) throws Exception {
		return userDAO.updateUser(user);
	}

	@Override
	public User deletUser(User user) throws Exception {
		return userDAO.deletUser(user);
	}

}
