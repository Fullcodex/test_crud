/* Un Bean est une classe qui permet d'encaspuler plusieurs objets en une seule entité.
 * Dans notre cas tous les enregistrement des utilisateurs seront conservés dans un Bean appelé UserRepository.
 * Ce dernier sera implémenté automatiquement par SPRING
 * Rappel : CRUD fait référence aux opérations de bases sur un objet d'une databse soit CREATE - READ - UPDATE - DELETE
 */

package accessingdatamysql;

/********* Import des librairies nécesssaires au fonctionnement du projet ************/
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findById(Long id);

	void deleteById(Long id);

}