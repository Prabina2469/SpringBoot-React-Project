package SpringBootReact.service.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SpringBootReact.entity.Users;
import SpringBootReact.repositories.java.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Users registerUser(Users user) {
        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }
        System.out.println("Saving User: " + user);
        return usersRepository.save(user);
    }

    // ✅ Login User
    @Transactional(readOnly = true)
    public boolean loginUser(String email, String password) {
        return usersRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    // ✅ Get all users
    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    // ✅ Get user by ID
    @Transactional(readOnly = true)
    public Users getUserById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // ✅ Delete User
    @Transactional
    public void deleteUser(Long id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        usersRepository.delete(user);
        System.out.println("Deleted User: " + user); // Debug print
    }
}
