package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
@RequestMapping(path="/innovators")
public class InnovatorController {
    @Autowired
    private InnovatorRepository innovatorRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Innovator> getAllInnovators() {
        return innovatorRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody void addNewInnovator(
            @RequestParam String name, @RequestParam String address, @RequestParam String email, @RequestParam String pass, @RequestParam String tel, @RequestParam String gender) {
        Innovator innovator = new Innovator();
        innovator.setName(name);
        innovator.setAddress(address);
        innovator.setEmail(email);
        innovator.setPass(pass);
        innovator.setTel(tel);
        innovator.setGender(gender);
        innovatorRepository.save(innovator);
    }

    @PostMapping(path="/update")
    public @ResponseBody void updateInnovator(
            @RequestParam Integer iid, @RequestParam String name, @RequestParam String address, @RequestParam String email, @RequestParam String pass, @RequestParam String tel, @RequestParam String gender) {
        Innovator innovator = new Innovator();
        innovator.setIid(iid);
        innovator.setName(name);
        innovator.setAddress(address);
        innovator.setEmail(email);
        innovator.setPass(pass);
        innovator.setTel(tel);
        innovator.setGender(gender);
        innovatorRepository.save(innovator);
    }

    @PostMapping(path="/delete")
    public @ResponseBody void deleteInnovator(@RequestParam Integer iid) {
        innovatorRepository.deleteById(iid);
    }

    @PostMapping(path="/view")
    public @ResponseBody Optional<Innovator> viewInnovator(@RequestParam Integer iid) {
        return innovatorRepository.findById(iid);
    }
}
