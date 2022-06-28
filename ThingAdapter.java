package eduard.zaripov.innocamp2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

import eduard.zaripov.innocamp2022.model.Thing;


public class ThingAdapter extends ArrayAdapter<Thing> {
    private LayoutInflater layoutInflater;
    private int layout;
    private List<Thing> lifts;

    public ThingAdapter(@NonNull Context context, int resource, @NonNull List<Thing> objects) {
        super(context, resource, objects);

        this.layout = resource;
        this.lifts = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(this.layout, parent, false);
        TextView idView = view.findViewById(R.id.idView);
        Thing thing = lifts.get(position);
        idView.setText(thing.getId());
        return view;
    }
}