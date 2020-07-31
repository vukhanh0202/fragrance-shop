package com.gemstones.service.impl;

import com.gemstones.entity.RoleEntity;
import com.gemstones.entity.UserEntity;
import com.gemstones.repository.ProductRepository;
import com.gemstones.repository.RoleRepository;
import com.gemstones.repository.UserRepository;
import com.gemstones.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public String save(UserEntity userEntity) {

        if (userEntity.getFullname().equals("") || userEntity.getPassword().equals("") || userEntity.getUsername().equals("")) {
            return "Vui lòng nhập đủ thông tin";
        }else if (userRepository.findOneByUsernameAndStatus(userEntity.getUsername(),"1") != null){
            return "Email đã được sử dụng";
        }else {
            userEntity.setPassword(BCrypt.hashpw(userEntity.getPassword(),BCrypt.gensalt()));
            userEntity.setStatus("1");
            List<RoleEntity> arrRole = new ArrayList<RoleEntity>();
            arrRole.add(roleRepository.findOneByCode("USER"));
            userEntity.setRoles(arrRole);
            userRepository.save(userEntity);
            return "Thành công";
        }

    }
}
