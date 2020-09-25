package com.example.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

public class QuakeAdapter extends ArrayAdapter<QuakeInformation> {
    String PrimaryLocation, OffsetLocation;

    public QuakeAdapter(@NonNull Context context, ArrayList<QuakeInformation> quakeInformations) {
        super(context, 0, quakeInformations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        View listItems = convertView;
        if (listItems == null) {
            listItems = LayoutInflater.from(getContext()).inflate(R.layout.quake_information_list, parent, false);
        }


        QuakeInformation currentItem = getItem(position);

        TextView magnitude = (TextView) listItems.findViewById(R.id.quakeMagnitude);
        String formattedMagnitude = formateMagnitude(currentItem.getmMagnitude());
        magnitude.setText(formattedMagnitude);

        String originalLocation = currentItem.getMlocation();

        TextView offsetlocation = (TextView) listItems.findViewById(R.id.offsetLocation);
        TextView primarylocation = (TextView)listItems.findViewById(R.id.primaryLocation);

        if(originalLocation.contains("of")){
            String[] parts =  originalLocation.split("of");
            OffsetLocation =  parts[0]+"of";
            PrimaryLocation =  parts[1];
        }else {
            OffsetLocation =  getContext().getString(R.string.location_separtor);
            PrimaryLocation =  originalLocation;
        }

        offsetlocation.setText(OffsetLocation);
        primarylocation.setText(PrimaryLocation);

        GradientDrawable magnitudeCircle = (GradientDrawable)magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentItem.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);





        Date dateObject = new Date(currentItem.getmTimeInMilliseconds());
        TextView date = (TextView) listItems.findViewById(R.id.quakeEventDate);
        String formatedDate = formatDate(dateObject);
        date.setText(formatedDate);

        TextView time = (TextView) listItems.findViewById(R.id.quaketime);
        time.setText(String.valueOf(formatedTime(dateObject)));


        return listItems;
    }

    private String formateMagnitude(double getmMagnitude) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getmMagnitude);
    }

    private int getMagnitudeColor(double Magnitude) {
        int MagnitudeColorResourceID;
        int MagnitudeColor = (int) Math.floor(Magnitude);
        switch (MagnitudeColor){

            case 0:
            case 1:{
                MagnitudeColorResourceID = R.color.magnitude1;
                break;
            }

            case 2:{
                MagnitudeColorResourceID = R.color.magnitude2;
                break;
            }

            case 3:{
                MagnitudeColorResourceID = R.color.magnitude3;
                break;
            }

            case 4:{
                MagnitudeColorResourceID = R.color.magnitude4;
                break;
            }

            case 5:{
                MagnitudeColorResourceID = R.color.magnitude5;
                break;
            }
            case 6:{
                MagnitudeColorResourceID = R.color.magnitude6;
                break;
            }

            case 7:{
                MagnitudeColorResourceID = R.color.magnitude7;
                break;
            }

            case 8:{
                MagnitudeColorResourceID = R.color.magnitude8;
                break;
            }
            case 9:{
                MagnitudeColorResourceID = R.color.magnitude9;
                break;
            }
            default:
                MagnitudeColorResourceID = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(),MagnitudeColorResourceID);

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatedTime(Date dateObject) {

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateObject);
    }


}
