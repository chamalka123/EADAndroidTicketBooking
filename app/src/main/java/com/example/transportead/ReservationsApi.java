package com.example.transportead;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import java.util.List;

public interface ReservationsApi {
    @GET("api/reservation") // Adjust the endpoint as needed in accordance with your C# backend
    Call<List<Reservations>> getReservations();

    @POST("api/reservation") // Replace with the correct endpoint for creating users
    Call<Reservations> createReservation(@Body Reservations reservation);
}

