package com.example.medremind;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class Graphing extends AppCompatActivity {
    String graphSunOut, graphSunOn, graphSunNot;
    String graphMonOut, graphMonOn, graphMonNot;
    String graphTueOut, graphTueOn, graphTueNot;
    String graphWedOut, graphWedOn, graphWedNot;
    String graphThuOut, graphThuOn, graphThuNot;
    String graphFriOut, graphFriOn, graphFriNot;
    String graphSatOut, graphSatOn, graphSatNot;
    int intgraphSunOn;
    int intgraphMonOn;
    int intgraphTueOn;
    int intgraphWedOn;
    int intgraphThuOn;
    int intgraphFriOn;
    int intgraphSatOn;
    int intgraphOnTotalWeek;

    int intgraphSunOut;
    int intgraphMonOut;
    int intgraphTueOut;
    int intgraphWedOut;
    int intgraphThuOut;
    int intgraphFriOut;
    int intgraphSatOut;
    int intgraphOutTotalWeek;

    int intgraphSunNot;
    int intgraphMonNot;
    int intgraphTueNot;
    int intgraphWedNot;
    int intgraphThuNot;
    int intgraphFriNot;
    int intgraphSatNot;
    int intgraphNotTotalWeek;

    String graphOnTotalWeek;
    TextView tvOnTime, tvNotTaken, tvNotInRange;
    PieChart pieChart;
    private MedDBHelper medDBHelper;
    private GraphDBHelper graphDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphing);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Weekly Medicine Statistics");
        tvOnTime = findViewById(R.id.tvOnTime);
        tvNotInRange = findViewById(R.id.tvNotInRange);
        tvNotTaken = findViewById(R.id.tvNotTaken);
        pieChart = findViewById(R.id.piechart);
        // to set the text in text view and pie chart
        setWeeklyData();
    }
    // graph statistics for the entire week
    private void setWeeklyData()
    {
        setTitle("Weekly Medicine Statistics");
        // clear the chart visuals
        pieChart.clearChart();
        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphSunOn = graphDBHelper.countTakeOnGraphSun();
        graphMonOn = graphDBHelper.countTakeOnGraphMon();
        graphTueOn = graphDBHelper.countTakeOnGraphTue();
        graphWedOn = graphDBHelper.countTakeOnGraphWed();
        graphThuOn = graphDBHelper.countTakeOnGraphThu();
        graphFriOn = graphDBHelper.countTakeOnGraphFri();
        graphSatOn = graphDBHelper.countTakeOnGraphSat();

        intgraphSunOn = Integer.parseInt(graphSunOn);
        intgraphMonOn = Integer.parseInt(graphMonOn);
        intgraphTueOn = Integer.parseInt(graphTueOn);
        intgraphWedOn = Integer.parseInt(graphWedOn);
        intgraphThuOn = Integer.parseInt(graphThuOn);
        intgraphFriOn = Integer.parseInt(graphFriOn);
        intgraphSatOn = Integer.parseInt(graphSatOn);
        intgraphOnTotalWeek = intgraphSunOn + intgraphMonOn + intgraphTueOn + intgraphWedOn + intgraphThuOn + intgraphFriOn + intgraphSatOn;

        graphSunOut = graphDBHelper.countTakeOutGraphSun();
        graphMonOut = graphDBHelper.countTakeOutGraphMon();
        graphTueOut = graphDBHelper.countTakeOutGraphTue();
        graphWedOut = graphDBHelper.countTakeOutGraphWed();
        graphThuOut = graphDBHelper.countTakeOutGraphThu();
        graphFriOut = graphDBHelper.countTakeOutGraphFri();
        graphSatOut = graphDBHelper.countTakeOutGraphSat();

        intgraphSunOut = Integer.parseInt(graphSunOut);
        intgraphMonOut = Integer.parseInt(graphMonOut);
        intgraphTueOut = Integer.parseInt(graphTueOut);
        intgraphWedOut = Integer.parseInt(graphWedOut);
        intgraphThuOut = Integer.parseInt(graphThuOut);
        intgraphFriOut = Integer.parseInt(graphFriOut);
        intgraphSatOut = Integer.parseInt(graphSatOut);
        intgraphOutTotalWeek = intgraphSunOut + intgraphMonOut + intgraphTueOut + intgraphWedOut + intgraphThuOut + intgraphFriOut + intgraphSatOut;

        graphSunNot = graphDBHelper.countTakeNotGraphSun();
        graphMonNot = graphDBHelper.countTakeNotGraphMon();
        graphTueNot = graphDBHelper.countTakeNotGraphTue();
        graphWedNot = graphDBHelper.countTakeNotGraphWed();
        graphThuNot = graphDBHelper.countTakeNotGraphThu();
        graphFriNot = graphDBHelper.countTakeNotGraphFri();
        graphSatNot = graphDBHelper.countTakeNotGraphSat();

        intgraphSunNot = Integer.parseInt(graphSunNot);
        intgraphMonNot = Integer.parseInt(graphMonNot);
        intgraphTueNot = Integer.parseInt(graphTueNot);
        intgraphWedNot = Integer.parseInt(graphWedNot);
        intgraphThuNot = Integer.parseInt(graphThuNot);
        intgraphFriNot = Integer.parseInt(graphFriNot);
        intgraphSatNot = Integer.parseInt(graphSatNot);
        intgraphNotTotalWeek = intgraphSunNot + intgraphMonNot + intgraphTueNot + intgraphWedNot + intgraphThuNot + intgraphFriNot + intgraphSatNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken On Time",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Not On Time",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }

    private void setSundayData()
    {
        setTitle("Sunday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphSunOn = graphDBHelper.countTakeOnGraphSun();

        intgraphSunOn = Integer.parseInt(graphSunOn);

        intgraphOnTotalWeek = intgraphSunOn;

        graphSunOut = graphDBHelper.countTakeOutGraphSun();

        intgraphSunOut = Integer.parseInt(graphSunOut);

        intgraphOutTotalWeek = intgraphSunOut;

        graphSunNot = graphDBHelper.countTakeNotGraphSun();

        intgraphSunNot = Integer.parseInt(graphSunNot);

        intgraphNotTotalWeek = intgraphSunNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken On Time",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }


    private void setMondayData()
    {
        setTitle("Monday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphMonOn = graphDBHelper.countTakeOnGraphMon();

        intgraphMonOn = Integer.parseInt(graphMonOn);

        intgraphOnTotalWeek = intgraphMonOn;

        graphMonOut = graphDBHelper.countTakeOutGraphMon();

        intgraphMonOut = Integer.parseInt(graphMonOut);

        intgraphOutTotalWeek = intgraphMonOut;

        graphMonNot = graphDBHelper.countTakeNotGraphMon();

        intgraphMonNot = Integer.parseInt(graphMonNot);

        intgraphNotTotalWeek = intgraphMonNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }

    private void setTuesdayData()
    {
        setTitle("Tuesday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphTueOn = graphDBHelper.countTakeOnGraphTue();

        intgraphTueOn = Integer.parseInt(graphTueOn);

        intgraphOnTotalWeek = intgraphTueOn;

        graphTueOut = graphDBHelper.countTakeOutGraphTue();

        intgraphTueOut = Integer.parseInt(graphTueOut);

        intgraphOutTotalWeek = intgraphTueOut;

        graphTueNot = graphDBHelper.countTakeNotGraphTue();

        intgraphTueNot = Integer.parseInt(graphTueNot);

        intgraphNotTotalWeek = intgraphTueNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }

    // pieChart.startAnimation();

    private void setWednesdayData()
    {
        setTitle("Wednesday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphWedOn = graphDBHelper.countTakeOnGraphWed();

        intgraphWedOn = Integer.parseInt(graphWedOn);
        intgraphOnTotalWeek = intgraphWedOn;

        graphWedOut = graphDBHelper.countTakeOutGraphWed();

        intgraphWedOut = Integer.parseInt(graphWedOut);

        intgraphOutTotalWeek = intgraphWedOut;

        graphWedNot = graphDBHelper.countTakeNotGraphWed();

        intgraphWedNot = Integer.parseInt(graphWedNot);

        intgraphNotTotalWeek = intgraphWedNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }

    private void setThursdayData()
    {
        setTitle("Thursday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphThuOn = graphDBHelper.countTakeOnGraphThu();

        intgraphThuOn = Integer.parseInt(graphThuOn);

        intgraphOnTotalWeek = intgraphThuOn;

        graphThuOut = graphDBHelper.countTakeOutGraphThu();

        intgraphThuOut = Integer.parseInt(graphThuOut);

        intgraphOutTotalWeek = intgraphThuOut;

        graphThuNot = graphDBHelper.countTakeNotGraphThu();

        intgraphThuNot = Integer.parseInt(graphThuNot);

        intgraphNotTotalWeek = intgraphThuNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }

    private void setFridayData()
    {
        setTitle("Friday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphFriOn = graphDBHelper.countTakeOnGraphFri();

        intgraphFriOn = Integer.parseInt(graphFriOn);
        intgraphOnTotalWeek = intgraphFriOn;

        graphFriOut = graphDBHelper.countTakeOutGraphFri();

        intgraphFriOut = Integer.parseInt(graphFriOut);
        intgraphOutTotalWeek = intgraphFriOut;

        graphFriNot = graphDBHelper.countTakeNotGraphFri();

        intgraphFriNot = Integer.parseInt(graphFriNot);
        intgraphNotTotalWeek = intgraphFriNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }
    private void setSaturdayData()
    {
        setTitle("Saturday's Medicine Statistics");

        pieChart.clearChart();

        medDBHelper=new MedDBHelper(this);
        graphDBHelper = new GraphDBHelper(this);
        graphSatOn = graphDBHelper.countTakeOnGraphSat();

        intgraphSatOn = Integer.parseInt(graphSatOn);
        intgraphOnTotalWeek = intgraphSatOn;

        graphSatOut = graphDBHelper.countTakeOutGraphSat();

        intgraphSatOut = Integer.parseInt(graphSatOut);
        intgraphOutTotalWeek = intgraphSatOut;

        graphSatNot = graphDBHelper.countTakeNotGraphSat();

        intgraphSatNot = Integer.parseInt(graphSatNot);
        intgraphNotTotalWeek = intgraphSatNot;

        tvOnTime.setText(Integer.toString(intgraphOnTotalWeek));
        tvNotInRange.setText(Integer.toString(intgraphOutTotalWeek));
        tvNotTaken.setText(Integer.toString(intgraphNotTotalWeek));

        pieChart.addPieSlice(
                new PieModel(
                        "Taken",
                        Integer.parseInt(tvOnTime.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Taken Late",
                        Integer.parseInt(tvNotInRange.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Not Taken",
                        Integer.parseInt(tvNotTaken.getText().toString()),
                        Color.parseColor("#EF5350")));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Graphing.this,MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.graphing_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.view_sun_graph:
                setSundayData();
                return true;
            case R.id.view_mon_graph:
                setMondayData();
                return true;
            case R.id.view_tue_graph:
                setTuesdayData();
                return true;
            case R.id.view_wed_graph:
                setWednesdayData();
                return true;
            case R.id.view_thu_graph:
                setThursdayData();
                return true;
            case R.id.view_fri_graph:
                setFridayData();
                return true;
            case R.id.view_sat_graph:
                setSaturdayData();
                return true;
            case R.id.view_weekly_graph:
                setWeeklyData();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

