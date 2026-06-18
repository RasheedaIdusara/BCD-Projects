package lk.rasheeda.core.service;

import jakarta.ejb.Remote;
import lk.rasheeda.core.dto.UserDTO;

import java.util.List;

@Remote
public interface UserService {

    UserDTO getUserByid(Long id);

    void addUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> getUsers();

}
