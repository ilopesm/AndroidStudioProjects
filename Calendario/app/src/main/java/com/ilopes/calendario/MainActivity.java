package com.ilopes.calendario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //private CalendarView calendarView;
    private MaterialCalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);

        /*calendarView.state().edit()
                    .setMinimumDate(CalendarDay.from(2020,1,1))
                    .setMaximumDate(CalendarDay.from(2022,12,31))
                    .commit();
*/
        CharSequence messes[] = {"Janeiro","Fevereiro","Março","Abril", "Maio","Junho","Julho","Rogerio","Roberto","10","11","12"};
        calendarView.setTitleMonths(messes);
        //calendarView.setWeekDayLabels();
        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Toast.makeText(MainActivity.this, ""+(date.getMonth()), Toast.LENGTH_SHORT).show();
            }
        });

        /*calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.i("data:",""+dayOfMonth+"/"+month+"/"+year);
            }
        });*/
    }
}
