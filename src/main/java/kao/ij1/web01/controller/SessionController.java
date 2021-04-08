package kao.ij1.web01.controller;


import kao.ij1.web01.models.Session;
import kao.ij1.web01.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        System.out.println("===051===SessionController.java===List<Session> list()==== " );
        return sessionRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        System.out.println("===051===SessionController.java===Session get(@PathVariable Long id)==== " +id.toString() );
        return sessionRepository.getOne(id);
    }

    // @ReponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Session create(@RequestBody final Session session){
        System.out.println("===051===Session create==== " );
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        System.out.println("===051===SessionController.java===Session DELETE==== " +id.toString() );
        sessionRepository.deleteById(id);
    }
    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //because this is a PUT, we expect all attributes to be passed in, A Patch would only need what
        //TODO: Add validation that all attributes are passed in, otherwisae return a 400 bad payload
        System.out.println("===051===SessionController.java===update====id= " +id.toString() );

        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


}
