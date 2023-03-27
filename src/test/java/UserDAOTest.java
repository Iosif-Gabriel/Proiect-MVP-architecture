import Model.DAO.UserDAO;
import Model.Tables.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDAOTest {

    private UserDAO userDAOMock;

    @Before
    public void setup(){
        userDAOMock=mock(UserDAO.class);

    }

    @Test
    public void testGetUser(){
        User user=new User("123","Nita123","Gabriel123","student","student","123");
        when(userDAOMock.getUser("123")).thenReturn(user);
        User user2=new User("123","Nita123","Gabriel123","student","student","123");
        assertEquals(userDAOMock.getUser("123"),user2);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("123", "Nita123", "Gabriel123", "student", "student", "123"));
        userList.add(new User("1123", "Nita123", "Gabriel123", "student", "student1", "123"));
        userList.add(new User("12443", "Nita123", "Gabriel123", "student", "student2", "123"));
        when(userDAOMock.findAllUser()).thenReturn(userList);

        List<User> expectedUsers = Arrays.asList(
                new User("123", "Nita123", "Gabriel123", "student", "student", "123"),
                new User("1123", "Nita123", "Gabriel123", "student", "student1", "123"),
                new User("12443", "Nita123", "Gabriel123", "student", "student2", "123")
        );

        assertEquals(expectedUsers, userDAOMock.findAllUser());
    }

    @Test
    public void testUpdateUser() {
        User user = new User("123", "Nita123", "Gabriel123", "student", "student", "123");
        when(userDAOMock.updateUser(user)).thenReturn(true);
        User updatedUser = new User("123", "John", "Doe", "teacher", "johndoe", "password");
        userDAOMock.updateUser(updatedUser);
        assertNotEquals(user, updatedUser);
    }

    @Test
    public void testCreateUser(){
        User user=new User("123", "Nita123", "Gabriel123", "student", "student", "123");
        when(userDAOMock.createUser(user)).thenReturn(true);
        when(userDAOMock.getUser("123")).thenReturn(user);
        assertEquals(userDAOMock.getUser("123"),user);
    }

    @Test
    public void testDeleteUser(){
        User user=new User("123", "Nita123", "Gabriel123", "student", "student", "123");
        when(userDAOMock.createUser(user)).thenReturn(true);
        //when(userDAOMock.deleteUser("123")).thenReturn(true);
        when(userDAOMock.getUser("123")).thenReturn(null);
        assertEquals(userDAOMock.getUser("123"),null);

    }



}
