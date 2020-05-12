package com.example.demo.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> userList = new ArrayList<>();

    private static int userCount =3;

    static {
        userList.add(new User(1,"Nesli",new Date()));
        userList.add(new User(2,"Nesli2",new Date()));
        userList.add(new User(3 ,"Nesli3",new Date()));
    }

    public List<User> findAll(){
        return userList;
    }

    public User save(User user){
        if(user.getId() ==null){
            user.setId((++userCount));
        }
        userList.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user: userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    //silindikten sonra silinen kaynak geri döner
    //for kullanılsaydı null dönecekti
    public User deleteById(int id){
        Iterator<User> userIterable = userList.iterator();
        while (userIterable.hasNext()){
            User user = userIterable.next();
            if(user.getId() == id) {
                userIterable.remove();
                return user;
            }
        }
        return null;
    }

}
