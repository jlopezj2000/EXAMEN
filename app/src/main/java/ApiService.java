public interface ApiService {
    @GET("api/?results=20")
    Call<UserResponse> getUsers();
}