package com.bmt.school.controllers;

import com.bmt.school.models.RecentActivityEntity;
import com.bmt.school.models.StudentRegistrationEntity;
import com.bmt.school.repositories.RecentActivityRepository;
import com.bmt.school.repositories.StudentRegistrationEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/menues")
public class HomeController {

    @Autowired
    private StudentRegistrationEntityRepo studentRegistrationEntityRepo;

    @Autowired
    private RecentActivityRepository recentActivityRepository;
    @GetMapping("/the-inspiration")
    public String theInspiration(){
        return"/the_inspiration";
    }
    @GetMapping("/home")
    public String home(){
        return "index";

    }
    @GetMapping("/the-school")
    public String theSchool(){
        return "/the_school";
    }
    @GetMapping("/the-team")
    public String theTeam(){
        return "/the_team";
    }
    @GetMapping("/vission-mission")
    public String vissionMission(){
        return "/vission_mission";
    }

    @GetMapping("/our-faculties")
    public String ourFaculties(){
        return "/our_faculties";
    }
    @GetMapping("/our-philosophy")
    public String ourPhilosophy(){
        return "/our_philosophy";
    }
    @GetMapping("/unique-activities")
    public String uniqueActivities(){
        return "/unique_activities";
    }
    @GetMapping("/mandatory-disclosure")
    public String mandatoryDisclosure(){
        return "/mandatory_disclosure";
    }
    @GetMapping("/student-council")
    public String studentCouncil(){
        return "/student_council";
    }
    @GetMapping("/interact-club")
    public String interactClub(){
        return "/nteract_club";
    }
    @GetMapping("/sports")
    public String sports(){
        return "/sports";
    }
    @GetMapping("/curriculum")
    public String curriculum(){
        return "/curriculum";
    }
    @GetMapping("/registration-and-enquiry")
    public String registrationAndEnquiry(){
        return "/registration_and_enquiry";
    }
    @GetMapping("/invite-to-visit")
    public String inviteToVisit(){
        return "/invite_to_visit";
    }
    @GetMapping("/admission-procedure")
    public String admissionProcedure(){
        return "/admission_procedure";
    }
    @GetMapping("/library-and-resource-center")
    public String libraryAndResourceCenter(){
        return "/library_and_resource_center";
    }
    @GetMapping("/ela-maths-and-science")
    public String elaMathsAndScience(){
        return "/ela_maths_and_science";
    }
    @GetMapping("/robotics-and-ict-labs")
    public String roboticsAndIctLabs(){
        return "/robotics_and_ict_labs";
    }
    @GetMapping("/yoga-sports")
    public String yogaSports(){
        return "/yoga_sports";
    }
    @GetMapping("/garden")
    public String garden(){
        return "/garden";
    }
    @GetMapping("/juniorwing")
    public String juniorwing(){
        return "/juniorwing";
    }
    @GetMapping("/career")
    public String career(){
        return "/career";
    }
    @GetMapping("/online-fee-payment")
    public String onlineFeePayment(){
        return "/online_fee_payment";
    }

    @GetMapping("/registration")
    public String registration(){
        return "/registration";
    }

    @PostMapping("/registrations")
    public String saveRegistrationData(@ModelAttribute StudentRegistrationEntity studentRegistrationEntity) {
        // Save registration data to the database
        studentRegistrationEntityRepo.save(studentRegistrationEntity);
        // Redirect to the print registration page
        Long id=studentRegistrationEntity.getId();
        return "redirect:/menues/registration-print/"+id;
    }

    @GetMapping("/registration-print/{id}")

    public String registrationPrint(@PathVariable Long id, Model model) {
        StudentRegistrationEntity studentRegistrationEntity = studentRegistrationEntityRepo.findById(id).orElse(null);
        model.addAttribute("studentRegistrationEntity",studentRegistrationEntity);
        return "registration_print";
    }



}
