package br.com.iworkout.activity;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.androidplot.Plot;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Metrics;

public class EvolucaoActivity extends DBFragmentActivity implements AdapterView.OnItemSelectedListener {

    private XYPlot plot;
    private Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evolucao2);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.metrics_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        List<Metrics> metrics = getHelper().getMetricsDao().queryForAll();
        ArrayList<Number> y = new ArrayList<Number>();
        ArrayList<Number> x = new ArrayList<Number>();

        if (metrics != null) {
            for (Metrics metric : metrics) {
                y.add(metric.getDtInc().getTime());
                x.add(metric.getPeso());
            }
        }
        this.carregaGrafico(x,y,"Peso(kg)");
    }

    private void carregaGrafico(ArrayList<Number> x, ArrayList<Number> y,String nome){
        // initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.plot);
        plot.clear();

        Number[] series1Numbers = new Number[x.size()];
        x.toArray(series1Numbers);
        Number[] series2Numbers = new Number[y.size()];
        y.toArray(series2Numbers);

        XYSeries series2 = new SimpleXYSeries(
                Arrays.asList(series2Numbers),
                Arrays.asList(series1Numbers),
                nome);
        plot.setRangeLabel(nome);
        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels);


        plot.getGraphWidget().getGridBackgroundPaint().setColor(Color.WHITE);
        plot.getGraphWidget().getDomainOriginLinePaint().setColor(Color.BLACK);
        plot.getGraphWidget().getRangeOriginLinePaint().setColor(Color.BLACK);

        plot.setBorderStyle(Plot.BorderStyle.SQUARE, null, null);
        plot.getBorderPaint().setStrokeWidth(1);
        plot.getBorderPaint().setAntiAlias(false);
        plot.getBorderPaint().setColor(Color.WHITE);

//        plot.addSeries(series2, series2Format);
        plot.addSeries(series2, series1Format);

        // reduce the number of range labels
//        plot.setTicksPerRangeLabel(3);

        // rotate domain labels 45 degrees to make them more compact horizontally:
        plot.getGraphWidget().setDomainLabelOrientation(-45);
        plot.setRangeValueFormat(new DecimalFormat("0"));
        plot.setDomainValueFormat(new Format() {
            private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                long timestamp = ((Number) obj).longValue();
                Date date = new Date(timestamp);
                return dateFormat.format(date, toAppendTo, pos);
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;

            }
        });
        plot.redraw();
    }

    public void resetMetrics(View view){
        getHelper().getMetricsDao().delete(getHelper().getMetricsDao().queryForAll());
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selecionado = (String) adapterView.getItemAtPosition(i);


        List<Metrics> metrics = getHelper().getMetricsDao().queryForAll();
        ArrayList<Number> y = new ArrayList<Number>();
        ArrayList<Number> x = new ArrayList<Number>();
        String text = "peso";
        //TODO: arrumar essa porcada
        if (metrics != null) {

            if ("Peso".equals(selecionado)){
                    text = "Peso(kg)";
                for (Metrics metric : metrics) {
                    y.add(metric.getDtInc().getTime());
                    x.add(metric.getPeso());
                }

            }else if ("Perna".equals(selecionado)){
                text = "Perna(cm)";
                for (Metrics metric : metrics) {
                    y.add(metric.getDtInc().getTime());
                    x.add(metric.getCoxa());
                }

            }else if ("Biceps".equals(selecionado)){
                text = "Biceps(cm)";
                for (Metrics metric : metrics) {
                    y.add(metric.getDtInc().getTime());
                    x.add(metric.getBraco());
                }

            }else if ("Cintura".equals(selecionado)){
                text = "Cintura(cm)";
                for (Metrics metric : metrics) {
                    y.add(metric.getDtInc().getTime());
                    x.add(metric.getCintura());
                }

            }else if ("Peito".equals(selecionado)) {
                text = "Peito(cm)";
                for (Metrics metric : metrics) {
                    y.add(metric.getDtInc().getTime());
                    x.add(metric.getPeitoral());
                }

            }
        }
        this.carregaGrafico(x,y,text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

