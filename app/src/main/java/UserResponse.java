public class UserResponse {
    public List<Result> results;
}

public class Result {
    public Name name;
    public Location location;
    public String email;
    public Picture picture;
}

public class Name {
    public String first;
    public String last;
}

public class Location {
    public Street street;
    public String city;
    public Coordinates coordinates;
    public Country country;
}

public class Coordinates {
    public String latitude;
    public String longitude;
}

public class Picture {
    public String large;
}