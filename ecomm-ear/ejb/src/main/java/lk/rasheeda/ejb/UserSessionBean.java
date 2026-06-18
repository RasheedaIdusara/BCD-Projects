package lk.rasheeda.ejb;

import jakarta.ejb.Stateless;
import lk.rasheeda.core.dto.UserDTO;
import lk.rasheeda.core.service.UserService;

import java.util.List;

@Stateless
public class UserSessionBean implements UserService {

    @Override
    public UserDTO getUserByid(Long id) {
        System.out.println("getUserByid");
        return null;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        System.out.println("addUser");
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        System.out.println("updateUser");
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("deleteUser");
    }

    @Override
    public List<UserDTO> getUsers() {
        return List.of();
    }

}
