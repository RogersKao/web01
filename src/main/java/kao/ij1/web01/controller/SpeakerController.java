package kao.ij1.web01.controller;

import kao.ij1.web01.models.Speaker;
import kao.ij1.web01.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/speakers")
    public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        System.out.println("===052===SpeakerController.java===List<Speaker> list()==== " );
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        System.out.println("===052===SpeakerController.java===get====id= " + id.toString() );
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker){
        System.out.println("===052===SpeakerController.java===create==== "  );
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //Also need to check for children records before deleting.
        System.out.println("===052===SpeakerController.java===Delete====id= " + id.toString() );
        speakerRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        //because this is a PUT, we expect all attributes to be passed in, A Patch would only need what
        //TODO: Add validation that all attributes are passed in, otherwisae return a 400 bad payload
        System.out.println("===052===SpeakerController.java===get====id= " + id.toString() );
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties ( speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
