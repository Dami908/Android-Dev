package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
public class TestListAdapter extends BaseAdapter  {

    Context context;
    private final int[] testIds;
    private final int[] patientIds;
    private final int[] nurseIds;
    private final double[] bpls;
    private final double[] bphs;
    private final double[] temperatures;
    private final double[] glucoses;
    private final double[] thymols;
    private final double[] boneMarrows;

    public TestListAdapter(Context context, int[] testIds, int[] patientIds, int[] nurseIds, double[] bpls, double[] bphs, double[] temperatures, double[] glucoses, double[] thymols, double[] boneMarrows) {
        this.context = context;
        this.testIds = testIds;
        this.patientIds = patientIds;
        this.nurseIds = nurseIds;
        this.bpls = bpls;
        this.bphs = bphs;
        this.temperatures = temperatures;
        this.glucoses = glucoses;
        this.thymols = thymols;
        this.boneMarrows = boneMarrows;
    }

    @Override
    public int getCount() {
        return testIds.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TestListAdapter.ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            // Create new view holder and link with the views
            viewHolder = new TestListAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.test_list_item, parent, false);
            viewHolder.testId = (TextView)convertView.findViewById(R.id.txtTestId);
            viewHolder.patientId = (TextView)convertView.findViewById(R.id.txtPatientId);
            viewHolder.nurseId = (TextView)convertView.findViewById(R.id.txtNurseId);
            viewHolder.bpl = (TextView)convertView.findViewById(R.id.txtBPL);
            viewHolder.bph = (TextView)convertView.findViewById(R.id.txtBPH);
            viewHolder.temperature = (TextView)convertView.findViewById(R.id.txtTemperature);
            viewHolder.glucose = (TextView)convertView.findViewById(R.id.txtGlucose);
            viewHolder.thymol = (TextView)convertView.findViewById(R.id.txtThymol);
            viewHolder.boneMarrow = (TextView)convertView.findViewById(R.id.txtBoneMarrow);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (TestListAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }

        // Attach the data
        viewHolder.testId.setText("Test ID: " + String.valueOf(testIds[position]));
        viewHolder.patientId.setText("Patient ID: " + String.valueOf(patientIds[position]));
        viewHolder.nurseId.setText("Nurse ID: " + String.valueOf(nurseIds[position]));
        viewHolder.bpl.setText("BPL: " + String.valueOf(bpls[position]));
        viewHolder.bph.setText("BPH: " + String.valueOf(bphs[position]));
        viewHolder.temperature.setText("Temperature: " + String.valueOf(temperatures[position]));
        viewHolder.glucose.setText("Glucose Tolerance: " + String.valueOf(glucoses[position]));
        viewHolder.thymol.setText("Thymol Turbidity: " + String.valueOf(thymols[position]));
        viewHolder.boneMarrow.setText("Bone Marrow Aspiration: " + String.valueOf(boneMarrows[position]));

        return convertView;
    }

    private static class ViewHolder {
        TextView testId;
        TextView patientId;
        TextView nurseId;
        TextView bpl;
        TextView bph;
        TextView temperature;
        TextView glucose;
        TextView thymol;
        TextView boneMarrow;
    }
}
