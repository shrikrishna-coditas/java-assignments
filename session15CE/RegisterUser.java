package session15CE;

public class RegisterUser {
    public void validate(int age) throws InvalidAgeException {
        if(age <= 18)
            throw new InvalidAgeException("You are Minor");//2options==>try catch /throws
    }
    public void validate(String citizenship) throws InvalidCitizenshipException {
        if(!"Indian".equalsIgnoreCase(citizenship))
            throw new InvalidCitizenshipException("Citizenship should be INDIAN");
    }
}
