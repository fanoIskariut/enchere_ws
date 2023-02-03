package enchere_ws.controller;

import enchere_ws.model.*;
import enchere_ws.repository.ClientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
@CrossOrigin("*")
public class ClientController {
    private final ClientRepository repository;

    public ClientController(ClientRepository repository){
        this.repository=repository;
    }
// insert client
    @PostMapping("/Client/save")
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }
// login client
    @PostMapping("/Client/login")
    Object login (@RequestBody Client user){
        try{
            JsonDataSuccess<Client> data = new JsonDataSuccess();
            Client u = repository.findByEmailAndMotdepasse(user.getEmail(), user.getMotdepasse());
            if(u==null)
                data.setData("Login invalid");
            else
                data.setData(u);
            return data;
        }catch(Exception ex){
            JsonError err = new JsonError();
            Erreur e = new Erreur();
            e.setCode(404);
            e.setMessage("Error found");
            err.setError(e);
            return err;
        }
    }
}
