package ru.yandex.yamblz.euv.hackathon.views;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;


public class StatChart extends CombinedChart {
    //region constructors
    public StatChart(Context context) {
        super(context);
        initMe();
    }
    public StatChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMe();
    }
    public StatChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initMe();
    }
    //endregion

    private void initMe(){
        setTouchEnabled(false);
        setDragEnabled(false);
        setScaleEnabled(false);
        setDescription("");


        CombinedData combinedData=new CombinedData();
        BarData barData=new BarData(getBarDataSets());
        barData.groupBars(0,0.2f,0.2f);
        combinedData.setData(barData);
        combinedData.setData(lineData());
        setData(combinedData);
        YAxis yAxis=getAxisLeft();
        yAxis.setAxisMinValue(0);
        yAxis.setAxisMaxValue(60);
        yAxis.setDrawGridLines(false);
        yAxis.setTextSize(12);

        yAxis=getAxisRight();
        yAxis.setAxisMinValue(0);
        yAxis.setAxisMaxValue(60);
        yAxis.setValueFormatter(new AxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if(value==30)return "30";
                else return "";
            }

            @Override
            public int getDecimalDigits() {
                return 1;
            }
        });
        yAxis.setDrawGridLines(false);
        yAxis.setTextSize(12);

        getXAxis().setDrawAxisLine(false);
        getXAxis().setDrawGridLines(false);
        getXAxis().setDrawLabels(false);
        getXAxis().setAxisMaxValue(9);
        getLegend().setEnabled(true);
        setPadding(20,0,0,0);
    }
    private List<IBarDataSet> getBarDataSets(){
        List<IBarDataSet> entries=new ArrayList<>();
        entries.add(generateBarDataSet(0,10,"ПН"));
        entries.add(generateBarDataSet(1,20,"ВТ"));
        entries.add(generateBarDataSet(2,30,"СР"));
        entries.add(generateBarDataSet(3,50,"ЧТ"));
        entries.add(generateBarDataSet(4,20,"ПТ"));
        entries.add(generateBarDataSet(5,10,"СБ"));
        entries.add(generateBarDataSet(6,10,"ВС"));
        return entries;
    }

    private IBarDataSet generateBarDataSet(int x,int y,String name){
        List<BarEntry> barEntries=new ArrayList<>();
        BarEntry day=new BarEntry(x,y);
        barEntries.add(day);
        BarDataSet barDataSet=new BarDataSet(barEntries,name);
        barDataSet.setDrawValues(false);
        return barDataSet;
    }
    public LineData lineData(){
        ArrayList<Entry> line = new ArrayList<>();
        line.add(new Entry(0f, 30));
        line.add(new Entry(20f, 30));
        LineDataSet lineDataSet = new LineDataSet(line,"");
        LineData lineData = new LineData(lineDataSet);
        lineData.setDrawValues(false);
        return lineData;

    }
}
