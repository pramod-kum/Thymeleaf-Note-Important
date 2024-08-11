package com.bmt.school.controllers;

import com.bmt.school.models.AppUser;
import com.bmt.school.models.RecentActivityEntity;
import com.bmt.school.models.RegisterDto;
import com.bmt.school.repositories.AppUserRepository;
import com.bmt.school.repositories.RecentActivityRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Date;

@Controller
public class AccountController {
    @Autowired
    private AppUserRepository repo;

    @Autowired
    private RecentActivityRepository recentActivityRepository;

    @GetMapping("/register")
    public String register(Model model){
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success",false);
        return "register";
    }

    @PostMapping("/register")
    public String registers(@Valid @ModelAttribute RegisterDto registerDto, BindingResult result,Model model){

        if(!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
            result.addError(
                    new FieldError("registerDto","confirmPassword",
                            "Password and Confirm Password do not match")
            );
        }

        AppUser appUser = repo.findByEmail(registerDto.getEmail());
        if(appUser !=null){
            result.addError(
                    new FieldError("registerDto","email","Email address is already used")
            );
        }

        if(result.hasErrors()){
            return "register";
        }

        try{
            //create new account
            var bCryptEncoder = new BCryptPasswordEncoder();

            AppUser newUser = new AppUser();
            newUser.setFirstName(registerDto.getFirstName());
            newUser.setLastName(registerDto.getLastName());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone(registerDto.getPhone());
            newUser.setAddress(registerDto.getAddress());
            newUser.setRole("client");
            newUser.setCreatedAt(new Date());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));

            repo.save(newUser);

            model.addAttribute("registerDto",new RegisterDto());
            model.addAttribute("success",true);

        }catch (Exception e){
            result.addError(
                    new FieldError("registerDto","firstName",e.getMessage())
            );
        }

        return "register";
    }

    @GetMapping("/admin")
    public String admin() {

        return "admin";
    }


    @GetMapping("/admin/recent-activity")
    public String recentActivity(Model model){
        model.addAttribute("recentActivityData",recentActivityRepository.findAll());
        return "recent_activity";
    }
    @GetMapping("/admin/add-recent-activity")
    public String addRecentActivity(){
        return "add_recent_activity";
    }
    @PostMapping("/admin/add-recent-activity")
    public String saveRegistrationData(@RequestParam MultipartFile img, @ModelAttribute RecentActivityEntity recentActivityEntity, HttpSession session) {

        RecentActivityEntity im=recentActivityEntity;

        im.setImage(img.getOriginalFilename());

        RecentActivityEntity uplodImg = recentActivityRepository.save(im);

        if(uplodImg !=null) {
            try {
                File saveFile = new ClassPathResource("static/img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
                System.out.println(path);

                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/recent-activity";
    }
    @GetMapping("/admin/edit-recent-activity/{id}")
    public String editRecentActivity(@PathVariable Long id,Model model){
        model.addAttribute("recentActivityData",recentActivityRepository.findById(id));
        return "edit_recent_activity";
    }
    @PostMapping("/admin/edit-recent-activity/{id}")
    public String updateRecentActivity(@PathVariable Long id,@RequestParam MultipartFile img,@ModelAttribute RecentActivityEntity recentActivityEntity,HttpSession session){
        recentActivityEntity.setId(id);

        RecentActivityEntity im=recentActivityEntity;

        im.setImage(img.getOriginalFilename());

        RecentActivityEntity uplodImg = recentActivityRepository.save(im);

        if(uplodImg !=null) {
            try {
                File saveFile = new ClassPathResource("static/img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
                System.out.println(path);

                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/recent-activity";
    }
    @GetMapping("/admin/delete-recent-activity/{id}")
    public String editRegistrationData(@PathVariable Long id) {
        // Save registration data to the database
        recentActivityRepository.deleteById(id);
        // Redirect to the print registration page
        return "redirect:/admin/recent-activity";
    }

    //new
    @ModelAttribute
    private void commonForNameShow(Principal principal, Model model){
        if(principal!=null){
            String email = principal.getName();
            AppUser appUser = repo.findByEmail(email);
            model.addAttribute("user",appUser);
        }
    }

}
