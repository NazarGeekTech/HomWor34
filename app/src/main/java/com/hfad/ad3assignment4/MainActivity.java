package com.hfad.ad3assignment4;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.hfad.ad3assignment4.data.model.MyWeather;
import com.hfad.ad3assignment4.data.remote.WeatherStorage;
import com.hfad.ad3assignment4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WeatherStorage.getWeather("Bishkek",
                "metric",
                "4bbf5a1ed98cd9f688ebb3651474cdd2",
                new WeatherStorage.GetWeatherByCity() {
                    @Override
                    public void onSuccess(MyWeather myWeather) {
                        Log.e("TAG", "onSuccess: " + myWeather.getName() );
                    }

                    @Override
                    public void onFailure(String error) {
                        Log.e("TAG", "onFailure: " + error );
                    }
                });
    }
}