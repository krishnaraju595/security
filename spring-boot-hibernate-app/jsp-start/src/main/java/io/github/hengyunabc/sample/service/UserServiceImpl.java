package io.github.hengyunabc.sample.service;

import io.github.hengyunabc.sample.repository.RoleRepository;
import io.github.hengyunabc.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.hengyunabc.sample.model.Employee;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(Employee employee) {
		employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
		userRepository.save(employee);
	}

	@Override
	public Employee findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
