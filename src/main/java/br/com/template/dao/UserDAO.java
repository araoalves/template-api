package br.com.template.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.template.model.User;

@Repository
@Transactional
public class UserDAO extends AbstractDAO<User, Integer> implements IUserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> recuperarUsers() throws Exception {
		return createEntityCriteria().list();
	}

	@Override
	public User insertUser(User user) throws Exception {
		return save(user);
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		return findById(id);
	}

	@Override
	public Object updateUser(User user) throws Exception {
		return update(user);
	}

}
