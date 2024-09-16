
import retrofit2.http.GET

interface ApiService {
    @get:GET("api/?results=20")
    val users: Call<UserResponse?>?
}