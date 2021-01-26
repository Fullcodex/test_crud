// Classe relevant une exception en cas d'action effectuée sur un utilisateur inexistant

package accessingdatamysql;

class UserNotFoundException extends RuntimeException {

	UserNotFoundException(Long id) {
		super("L'utilisateur " + id + " est introuvable");
	}
}