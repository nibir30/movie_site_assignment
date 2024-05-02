package com.assignment.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
//@Profile("dev")
public class InitialDevData implements ApplicationRunner {

//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//    private final LookupMediaTypeRepository lookupMediaTypeRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        log.info(".... init application ...");
//        List<RoleModel> roleModels = roleRepository.findAll();
//        if (roleModels.isEmpty()) {
//            RoleModel adminModel = RoleModel.builder()
//                    .role_id(1L)
//                    .active_yn("Y")
//                    .role_name("ADMIN")
//                    .build();
//            RoleModel userModel = RoleModel.builder()
//                    .role_id(2L)
//                    .active_yn("Y")
//                    .role_name("USER")
//                    .build();
//            roleRepository.save(adminModel);
//            roleRepository.save(userModel);
//        }
//
//        List<UserModel> userModels = userRepository.findAll();
//        if (userModels.isEmpty()) {
//            Optional<RoleModel> roleModel = roleRepository.findById(1L);
//            List<RoleModel> userRoleModels = new ArrayList<RoleModel>();
//            userRoleModels.add(roleModel.get());
//            UserModel adminUser = UserModel.builder()
//                    .id(24021514114563204L)
//                    .userId("test@admin.com")
//                    .email("test@admin.com")
//                    .firstName("Super")
//                    .lastName("Admin")
//                    .insertTime(LocalDateTime.now())
//                    .userStatus("Y")
//                    .password(passwordEncoder.encode("123456"))
//                    .roleModels(userRoleModels)
//                    .passwordExpiryDate(LocalDateTime.now().plusDays(1000))
//                    .build();
//            userRepository.save(adminUser);
//        }
//
//        List<LookupMediaType> lookupMediaTypes = lookupMediaTypeRepository.findAll();
//        if (lookupMediaTypes.isEmpty()) {
//            List<LookupMediaType> lookupMediaTypeList = new ArrayList<>();
//            LookupMediaType image = LookupMediaType.builder()
//                    .mediaTypeId(1L)
//                    .mediaTypeName("image")
//                    .maximumSize(2000L)
//                    .build();
//            lookupMediaTypeList.add(image);
//            LookupMediaType audio = LookupMediaType.builder()
//                    .mediaTypeId(2L)
//                    .mediaTypeName("audio")
//                    .maximumSize(2000L)
//                    .build();
//            lookupMediaTypeList.add(audio);
//            LookupMediaType video = LookupMediaType.builder()
//                    .mediaTypeId(3L)
//                    .mediaTypeName("video")
//                    .maximumSize(5000L)
//                    .build();
//            lookupMediaTypeList.add(video);
//            LookupMediaType pdf = LookupMediaType.builder()
//                    .mediaTypeId(4L)
//                    .mediaTypeName("pdf")
//                    .maximumSize(2000L)
//                    .build();
//            lookupMediaTypeList.add(pdf);
//            LookupMediaType txt = LookupMediaType.builder()
//                    .mediaTypeId(5L)
//                    .mediaTypeName("txt")
//                    .maximumSize(600L)
//                    .build();
//            lookupMediaTypeList.add(txt);
//            lookupMediaTypeRepository.saveAll(lookupMediaTypeList);
//        }
//
    }
}




