package com.spring.service;

import com.spring.domain.UserRequest;
import com.spring.domain.UserResponse;
import com.spring.entity.User;
import com.spring.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public UserResponse getUserById(int id){
        UserResponse userResponse = new UserResponse();
        try{
            return new UserResponse();
        }catch (Exception e){
            CommonUtil.handleExceptionMessage(id);
        }
        return userResponse;
    }

    public UserResponse getUserByName(String name){
//        UserResponse userResponse = new UserResponse();
//        try{
            return new UserResponse();
//        }catch (Exception e){
//            CommonUtil.handleExceptionMessage(name);
//        }
//        return userResponse;
    }

    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setSsn(request.getSsn());
        return new UserResponse();
    }

    public UserResponse getUserByIdAndName(int id, String name) {
        UserResponse userResponse = new UserResponse();
        try{
            return new UserResponse();
        }catch (Exception e){
            CommonUtil.handleExceptionMessage(name);
        }
        return userResponse;
    }

    public UserResponse getEvelope(int id, String name){
        User user = new User();
        user.setId(156);
        user.setFirstname("amritesh");
        user.setLastname("singh");
        user.setSsn("4d8-1c4-er78");

        List<String> result = genrateDocument(Arrays.asList(
                new String("sanay"),
                new String("vinay")
        ));

        return new UserResponse(user);
    }

    public List<String> genrateDocument(List<String> asList) {
        System.out.println("inside genrateDocument method..");
        return asList;
    }

    public UserResponse getUserSample() {
        User user = new User();
        user.setId(156);
        user.setFirstname("random");
        user.setLastname("singh");
        user.setSsn("ran-1c4-eOMe8");
        return new UserResponse(user);
    }
}
