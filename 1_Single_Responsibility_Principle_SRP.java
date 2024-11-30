// QUEBRAR CLASSES (com vários métodos) EM CLASSES SINGULARES 

// Before SRP (01 class, 02 methods)
class UserService {
    public void saveUser(User user) {
        // Save user to database
    }

    public void sendEmail(User user) {
        // Send a welcome email to user
    }
}

// After SRP (02 classes w/ 01 methos each)
class UserRepository {
    public void saveUser(User user) {
        // Save user to database
    }
}

class EmailService {
    public void sendEmail(User user) {
        // Send a welcome email to user
    }
}
