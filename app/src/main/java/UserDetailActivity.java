public class UserDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private User user;
    private GoogleMap mMap;
    private ImageView flagImageView;
    private TextView userNameTextView, userEmailTextView, userCountryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        user = (User) getIntent().getSerializableExtra("user");

        userNameTextView = findViewById(R.id.userName);
        userEmailTextView = findViewById(R.id.userEmail);
        userCountryTextView = findViewById(R.id.userCountry);
        flagImageView = findViewById(R.id.flagImageView);

        userNameTextView.setText(user.name);
        userEmailTextView.setText(user.email);
        userCountryTextView.setText(user.country);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fetchCountryFlag(user.country);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng userLocation = new LatLng(user.latitude, user.longitude);
        mMap.addMarker(new MarkerOptions().position(userLocation).title(user.city));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 10));
    }

    private void fetchCountryFlag(String countryName) {
        String url = "https://restcountries.com/v3.1/name/" + countryName;

        // Usar una librería como Picasso o Glide para cargar la bandera
        Picasso.get().load(url).into(flagImageView);
    }
}
