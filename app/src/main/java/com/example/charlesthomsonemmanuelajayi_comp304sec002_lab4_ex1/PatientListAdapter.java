package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PatientListAdapter extends BaseAdapter {

    Context context;
    private final int[] patientIds;
    private final String[] names;
    private final String[] departments;
    private final int[] nurseIds;
    private final String[] rooms;

    public PatientListAdapter(Context context, int[] patientIds, String[] names, String[] departments, int[] nurseIds, String[] rooms) {
        this.context = context;
        this.patientIds = patientIds;
        this.names = names;
        this.departments = departments;
        this.nurseIds = nurseIds;
        this.rooms = rooms;
    }

    @Override
    public int getCount() {
        return patientIds.length;
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
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            // Create new view holder and link with the views
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.patient_list_item, parent, false);
            viewHolder.patientId = (TextView)convertView.findViewById(R.id.txtPatientId);
            viewHolder.name = (TextView)convertView.findViewById(R.id.txtFullName);
            viewHolder.department = (TextView)convertView.findViewById(R.id.txtDepartment);
            viewHolder.nurseId = (TextView)convertView.findViewById(R.id.txtNurseId);
            viewHolder.room = (TextView)convertView.findViewById(R.id.txtRoom);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        // Attach the data
        viewHolder.patientId.setText("Patient ID: " + String.valueOf(patientIds[position]));
        viewHolder.name.setText("Name: " + names[position]);
        viewHolder.department.setText("Department: " + departments[position]);
        viewHolder.nurseId.setText("Nurse ID: " + String.valueOf(nurseIds[position]));
        viewHolder.room.setText("Rooms: " + rooms[position]);

        return convertView;
    }

    private static class ViewHolder {
        TextView patientId;
        TextView name;
        TextView department;
        TextView nurseId;
        TextView room;
    }
}
