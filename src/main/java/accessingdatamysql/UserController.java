/* Le controller est une composante essentielle :
 * Il permet de gérer les différentes requetes HTTP (GET / POST / PUT / DELETE) réalisées sur notre application
 */

package accessingdatamysql;


/********* Import des librairies nécesssaires au fonctionnement du projet ************/
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Transactional //Autorise les transactions avec la database
@RestController //Controller utilisant l'API REST
class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }


  // [CRUD : READ] Lister l'ensemble des utilisateurs déclarés dans la table 
  @GetMapping("/Users")
  List<User> all() {
    return (List<User>) repository.findAll();
  }

  // [CRUD : CREATE] Créer un nouvel utilisateur dans la table
  @PostMapping("/Users")
  User newUser(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  // [CRUD : READ] Lister un utilisateur spécifique
  @GetMapping("/Users/{id}")
  User one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  // [CRUD : UPDATE] Modifier les informations d'un utilisateur
  @PutMapping("/Users/{id}")
  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

    return repository.findById(id)
      .map(User -> {
        User.setNom(newUser.getNom());
        User.setPrenom(newUser.getPrenom());
        return repository.save(User);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
      });
  }

//[CRUD : DELETE] Supprimer un utilisateur de la table
  @DeleteMapping("/Users/{id}")
  public void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }
  
  
}